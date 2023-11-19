{:title "Customizing/Extending Cryogen"
 :layout :page
 :toc true
 :page-index 12
 :section "Additional Resources"}

If the malleability provided by the [configuration](configuration.html) and templates isn't enough for your needs, here are your options.

## Leverage Cryogen config and hooks to add, modify, or derive new template parameters and modify content

You can invoke [`cryogen-core.compiler/compile-assets-timed`](https://github.com/cryogen-project/cryogen-core/blob/master/src/cryogen_core/compiler.clj) with a custom `config` to:

1. Override any settings from `config.edn`
2. Add any additional parameters that will be made available to your pages (ex.: `{{my-custom-key}}`)
   (Similarly as you can do with custom keys in the article (i.e. page or post) metadata but for all articles.)
3. Derive new / modify existing page parameters (available in your Selmer templates) by supplying under `:extend-params-fn`
   a function of the signature `(fn [params site-data] params)`. See the code for the available `site-data`.
4. Add or modify data of any "article" (a page or a post) or exclude it from further processing by supplying under
   `:update-article-fn` a function of the signature `(fn [article, config] article)`. The function may change the content of the article
   by modifying its `:content-dom`, which is an [Enlive snippet](https://github.com/cgrand/enlive#concepts), i.e. a sequence of nodes.
   You may operate on it using e.g. `enlive/transform`. Return `nil` to exclude that article.
6. Post-process the HTML `:content` of any article right before it is written to the disk by supplying under `:postprocess-article-html-fn` a function of the signature `(fn [article, params] article)`. (Notice that when an article is first read, its `:content` is the markup text, it is later removed and replaced with `:content-dom` of Enlive nodes, and this again is later removed and replaced with `:content`, this time HTML text - this one is what this function sees.)

### Examples

#### Add counts of tag occurrences

We want to show not only tags but also how frequent they are at `/tags/`. So let's first find that out:

```clojure
(cryogen-core.compiler/compile-assets-timed
  {:extend-params-fn
   (fn extend-params [params site-data]
     (let [tag-count (->> (:posts-by-tag site-data)
                          (map (fn [[k v]] [k (count v)]))
                          (into {}))]
       (update
         params :tags
         #(map (fn [t] (assoc t
                         :count (tag-count (:name t))))
               %))))})
```

And in `tags.html`:

```diff
- <li><a href="{{tag.uri}}">{{tag.name}}</a></li>
+ <li><a href="{{tag.uri}}">{{tag.name}}</a> ({{tag.count}})</li>
```

#### Auto-link headings in posts and pages, GitHub style

See the cryogen 0.4.4 [auto-link customization gist](https://gist.github.com/holyjak/bbeb714ca25ec99b55933c40f2e75881).


#### Override the default URI based on a custom article metadata
You have the post `2019-12-31-my-awesome-post.asc`, which would normally be displayed at https://blog.example.com/2019-12-31-my-awesome-post/ but you don't want to have the date in the URL. (You could simply move the date from the file name into the `:date` metadata but let's assume you don't want to for a reason.) So you have added the desired URL slug to the post:

```clojure
{:title "Awesome!" :slug "my-awesome-post"}
My blog post is the greatest!
```

Now let's tell Cryogen to use the slug instead of the default `:uri`:

```clojure
(cryogen-core.compiler/compile-assets-timed
  {:update-article-fn
   (fn update-article [{:keys [slug] :as article} config]
       (if slug
         (assoc article :uri (str "/" slug "/"))
         article))})
```

Voilà, https://blog.example.com/my-awesome-post/ is there!

#### Post-process article HTML content with Selmer

Having a post like this:

```markdown
{:title "Test of markdown with Selmer templating"
 :date "2020-11-26"
 :my/postprocess? true}

Selmer test - it says: {{HELLO}}
```

and configuring Cryogen with this `postprocess-article-html-fn`:

```clojure
(cryogen-core.compiler/compile-assets-timed
     {:postprocess-article-html-fn
      (fn postprocess-article [article params]
        (require 'selmer.parser)
        (if (:my/postprocess? article)
          (update article :content selmer.parser/render {:HELLO "Nazdar!"})
          article))})
```

we end up with HTML including

```html
<p>Selmer test - it says: Nazdar!</p>
```

## Extra pages / posts

You can leverage the functions in `cryogen-core.compiler` and write your own, invoking them from your `cryogen.core/-main` and `cryogen.server/init`, to generate additional pages and posts in the same way as `compile-assets-timed` does.

## Customizing the code

You can copy the `cryogen-core.compiler` namespace directly into your project (where it will override the one from the cryogen-core.jar) and modify it to your liking. It is not very long or complicated and is quite easy to modify. That is [what we did for this site](https://github.com/cryogen-project/cryogen-docs/blob/fd601c857cc88f7cb633a41c47b4c692e1522ed8/src/cryogen/compiler.clj) (although it uses a much older version of cryogen-core, you may still use the same strategy today).
