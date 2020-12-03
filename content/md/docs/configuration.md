{:title "Configuration"
 :layout :page
 :page-index 3
 :section "Getting Started"
 :toc true}

## Your Options

Cryogen provides some flexible configuration options. Your site's configuration file can be found at `content/config.edn` and contains the following by default:

```clojure
{:site-title                   "My Awesome Blog"
 :author                       "Bob Bobbert"
 :description                  "This blog is awesome"
 :site-url                     "http://blogawesome.com/"
 :post-root                    "posts"
 :page-root                    "pages"
 :post-root-uri                "posts-output"
 :page-root-uri                "pages-output"
 :tag-root-uri                 "tags-output"
 :author-root-uri              "authors-output"
 :public-dest                  "public"
 :blog-prefix                  "/blog"
 :rss-name                     "feed.xml"
 :rss-filters                  ["cryogen"]
 :recent-posts                 3
 :post-date-format             "yyyy-MM-dd"
 :archive-group-format         "yyyy MMMM"
 :sass-src                     []
 :sass-path                    "sass"
 :compass-path                 "compass"
 :theme                        "blue"
 :resources                    ["img"]
 :keep-files                   [".git"]
 :disqus?                      false
 :disqus-shortname             ""
 :ignored-files                [#"\.#.*" #".*\.swp$"]
 :previews?                    false
 :posts-per-page               5
 :blocks-per-preview           2
 :description-include-elements #{:p :h1 :h2 :h3 :h4 :h5 :h6}
 :clean-urls                   :trailing-slash
 :collapse-subdirs?            false
 :hide-future-posts?           true
 :klipse                       {}
 :debug?                       false}}
```

### Details

Keys marked with a * must be provided.

<table class="table table-bordered">
<thead>
<tr>
  <th>Key</th>
  <th>Description</th>
</tr>
</thead>
<tbody>
<tr>
  <td style="width:150px">* `site-title`</td>
  <td>Your site's title</td>
</tr>
<tr>
	<td>* `author`</td>
	<td>Your name goes here!</td>
</tr>
<tr>
	<td>* `description`</td>
	<td>A blurb describing your site</td>
</tr>
<tr>
	<td>* `site-url`</td>
	<td>Your site's root url. This, along with all of the above values are used when generating your sitemap and RSS feed.</td>
</tr>
<tr>
	<td>* `post-root`</td>
	<td>The folder where the compiler will look for blog posts.</td>
</tr>
<tr>
	<td>* `page-root`</td>
	<td>The folder where the compiler will look for your custom pages.</td>
</tr>
<tr>
	<td>`post-root-uri`</td>
	<td>The folder where the compiler will output compiled blog posts. This value is prepended to all post uri's. If this key is omitted then the name of the output folder will be the same as the `post-root` folder. If en empty string ("") is provided then the posts will be outputted to the root folder of the blog (ie. `{public-dest}/{blog-prefix}`).</td>
</tr>
<tr>
	<td>`page-root-uri`</td>
	<td>The folder where the compiler will output compiled pages. This value is prepended to all page uri's. If this key is omitted then the name of the output folder will be the same as the `page-root` folder. If the empty string ("") is provided then the posts will be outputted to the root folder of the blog.</td>
</tr>
<tr>
	<td>`tag-root-uri`</td>
	<td>The folder where the compiler will output compiled tag pages. This value is prepended to all tag page uri's. If this key is omitted then the empty string will be used.</td>
</tr>
<tr>
	<td>`author-root-uri`</td>
	<td>If this value is provided then the compiler will generate a page for each author containing a list of all their posts. More info [here](/docs/writing-posts.html#multiple_authors).</td>
</tr>
<tr>
  <td>`public-dest`</td>
  <td>Sets where to output the rendered site. Defaults to `"public"` if not specified.</td>
</tr>
<tr>
	<td>* `blog-prefix`</td>
	<td>Prepended to all uri's. This must start with a slash.</td>
</tr>
<tr>
	<td>* `rss-name`</td>
	<td>The name of the rss file generated.</td>
</tr>
<tr>
	<td>`rss-filters`</td>
	<td>A vector of specific tags for which you want to create a separate RSS feed.</td>
</tr>
<tr>
	<td>`recent-posts`</td>
	<td>The maximum number of recent posts to show in the sidebar. Defaults to 3.</td>
</tr>
<tr>
	<td>* `post-date-format`</td>
	<td>Set the date format that you want to use for the names of your .md files representing your posts.</td>
</tr>
<tr>
	<td>`archive-group-format`</td>
	<td>Set the date format in which your archive page is organised. "yyyy" organises by year, "yyyy MMMM" organises by year and month. Defaults to "yyyy MMMM".</td>
</tr>
<tr>
	<td>`sass-src`</td>
	<td>A vector of directories containing sass(scss) files to be compiled. If this key is omitted then the default is `["css"]`. Be sure to include these directories in your `:resources` section as the compiled css will be outputted in the same directory.</td>
</tr>
<tr>
	<td>`sass-path`</td>
	<td>Path at which the `sass` executable can be found. The default value "sass" works if you have the executable in your path, in that case
nothing needs to be changed. If the executable is not in the
search path or has a different name than please adapt this value.
</td>
</tr>
<tr>
	<td>`compass-path`</td>
	<td>Path at which the `compass` executable can be found.
Just as with the `sass-path` fhe default value "compass" works
if you have the executable in your path, in that case
nothing needs to be changed. If the executable is not in the
search path or has a different name than please adapt this value.
</td>
</tr>
<tr>
	<td>* `theme`</td>
	<td>Set this to the theme you wish to deliver from the `themes` directory. You can add your own theme to this folder along with the current `blue`, `blue_centered` and `nucleus` themes.</td>
</tr>
<tr>
	<td>`resources`</td>
	<td>A vector of directories/files to be copied over from `content` to `public` upon compilation.</td>
</tr>
<tr>
	<td>`keep-files`</td>
	<td>A vector of directories/files to preserve when wiping the `public` folder between compilations.</td>
</tr>
<tr>
	<td>`disqus?`</td>
	<td>Set this to `true` if you want Disqus enabled on your site. `disqus-shortname` must be provided if this is `true`.</td>
</tr>
<tr>
	<td>`disqus-shortname`</td>
	<td>Your Disqus shortname.</td>
</tr>
<tr>
	<td>`ignored-files`</td>
	<td>A vector of regexes matching files that you want to ignore during compilation. (Ex: emacs interlock files.)</td>
</tr>
<tr>
	<td>`ignored-sitemap-paths`</td>
	<td>A vector of regexes matching paths that you want to ignore
	when generating a sitemap.</td>
</tr>
<tr>
	<td>`previews?`</td>
	<td>Set this to `true` if you would like to display a list of recent posts rather than a full, single post on your home page. Discussed [here](/docs/customizing-the-index.html). `post-per-page` and `blocks-per-preview` must provided if this is `true`.</td>
</tr>
<tr>
	<td>`post-per-page`</td>
	<td>If post previews are enabled then this is the maximum number of previews on a page. Defaults to 5.</td>
</tr>
<tr>
	<td>`blocks-per-preview`</td>
	<td>The default number of (html) blocks to display per post preview. This can be overwritten by adding `<!--more-->` to your .md or .asc file to indicate where you'd like to break off your post. Defaults to 2.</td>
</tr>
</tr>
<tr>
	<td>`:description-include-elements`</td>
	<td>The HTML elements from a preview whose content should be included in the plain-text `:description` of the page/post. Defaults to paragraphs and all headings, i.e. `#{:p :h1 :h2 :h3 :h4 :h5 :h6}`.</td>
</tr>
<tr>
	<td>* `clean-urls`</td>
	<td>`:trailing-slash`, `:no-trailing-slash`, and `:dirty` are valid options. Set this to `:trailing-slash` to emit html as subdirectories, e.g., `prefix/root/page-name/index.html`. Links would then end in `/page-name/`. Set this to `:no-trailing-slash` if you use GitHub Pages and prefer URLs not contain a final trailing slash. Links would then end in `/page-name`. <strong>Note:</strong> `:no-trailing-slash` will not work on all hosting providers such as Amazon S3. Set this to `:dirty` will result in `prefix/root/page-name.html`. Links would then end in `/page-name.html`
	<strong>Note 2:</strong> You can override the default URL with a smart use of <a href="/docs/customizing-cryogen.html"><code>:update-article-fn</code></a>.</td>
</tr>
<tr>
	<td>`collapse-subdirs?`</td>
	<td>Set this to `true` if you have your posts or pages organized in subdirectories and do not want that structure reflected in the url.  e.g., `/awesome-post/` instead of `/2016/awesome-post/`.</td>
</tr>
<tr>
	<td>`hide-future-posts?`</td>
	<td>Set this to `true` to include only current and past blogs in the compiled site. This allows for easy drafting of future articles.</td>
</tr>
<tr>
	<td>`klipse`</td>
	<td>Set [Klipse](https://github.com/viebel/klipse) configuration for the whole site.
See [Klipse Integration](klipse.html) for details.</td>
</tr>
<tr>
	<td>`debug?`</td>
	<td>Enable debug outputs for compiler.</td>
</tr>
</tbody>
</table>


### Custom Values
In addition to these default configuration options, you may add your own custom values. For example, if your blog has a subtitle that you'd like to display on your site:

1. Add `:subtitle "My subtitle"` to the config file
2. Inject the value into your templates via Selmer using `{% subtitle %}`

## Advanced Configuration
 If you want to override or extend `config.edn` from code, (e.g. by reading environment variables or by using an untracked file) you can edit `src/cryogen/core.clj` and `src/cryogen/server.clj` to pass a clojure map to the `compile-assets-timed` function. This is especially useful if you are making use of the custom values to configure 3rd party integrations like ReCaptcha.

 For Example, if you wanted to have private options loaded from a `secrets.edn` file, you could do the following:
 ```clojure
 ;; src/cryogen/core.clj

 ;; ...
 (defn -main []
   (load-plugins)
   (compile-assets-timed (read-string (slurp "secrets.edn")))
   (System/exit 0))
 ;; ...
 ```


```clojure
 ;; src/cryogen/server.clj

 ;; ...
 (defn init []
   (let [overrides (read-string (slurp "secrets.edn"))]
     (load-plugins)
     (compile-assets-timed overrides)
     (let [ignored-files (-> (resolve-config) :ignored-files)]
       (start-watcher! "content" ignored-files (partial compile-assets-timed overrides))
       (start-watcher! "themes" ignored-files (partial compile-assets-timed overrides)))))
;; ...
```
### Deriving Additional Params for Use in Templates

If you wish to further derive more parameters from the data that the cryogen compiler generates, you may pass in a `:extend-params-fn` in your overrides map which will be invoked by the compiler like so

```clojure
((:extend-params-fn overrides)
  params
  {:posts posts
   :pages pages
   :posts-by-tag posts-by-tag
   :navbar-pages navbar-pages
   :sidebar-pages sidebar-pages})
```

It should return the `params`, likely with additional keys. These will be visible to your templates.

See [Customizing/Extending Cryogen](/docs/customizing-cryogen.html) for an example.
