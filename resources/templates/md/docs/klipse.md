{:title "Klipse integration"
 :layout :page
 :page-index 8
 :toc true
 :section "Your Content"}

[Klipse](https://github.com/viebel/klipse)
is a tool for making code snippets on a web page interactive.
It consists of a javascript plugin that evaluates your code snippets.
Visitors can edit the snippets and they are evaluated continuously as they type.
It's all evaluated client-side, so no server involved.

In Cryogen you can integrate klipse in your blog with minimal effort.
You configure the klipse plugin in `config.edn` and set `:klipse` to `true` in
the post or page metadata.
Alternatively you can override parts of the global configuration by passing a
configuration map containing the desired changes to the `:klipse` key in the post/page metadata.

## Configuration

The configuration is a map that may include the following keys.

<table class="table table-bordered">
<thead>
<tr>
<th>Key</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr>
<td>`settings`</td>
<td>Contains a clojure map that's passed to `window.klipse_settings`.
All the settings are documented [here](https://github.com/viebel/klipse#configuration).

(In cryogen you can use `:lisp-cased-keywords` instead of `"snake_cased"`/`"camelCased"` strings.)
</td>
</tr>
<tr>
<td>`js-src`</td>
<td>A map with the keys `:min` and `:non-min`. These are uris that point to the
minified and non-minified version of the klipse plugin.
They default to the plugin hosted by klipse, but to host it yourself,
just set the appropriate uris.
</td>
</tr>
<tr>
<td>`js`</td>
<td>Can be either `:min` or `:non-min`. Self-hosted clojurescript is not (yet?)
compatible with advanced compilation, so if a post has cljs snippets, it needs
to use the non-minified version, but any other languages can use the minified version.

Cryogen will infer this based on the setting and the classes in the code blocks
in each post, so normally you don't need to worry about it.
Can be overridden if necessary.</td>
</tr>
<tr>
<td>`css-base`</td>
<td>The uri to the codemirror css that is used by klipse. As with `:js-src`,
it defaults to css hosted by klipse and you can override it if you want
to host it yourself.</td>
</tr>
<tr>
<td>`css-theme`</td>
<td>You can also use a codemirror theme for the snippets,
just set this to a uri pointing to one.</td>
</tr>
</tbody>
</table>

## Examples

### Basic config

This config is all you need to write code blocks with normal cljs, reagent and/or ruby eval.

`config.edn`
```
{...
:hide-future-posts? true

:klipse {:settings {:selector ".klipse-cljs"
                    :selector-reagent ".klipse-reagent"
                    :selector-eval-ruby ".klipse-ruby"}}

:debug? false}
```

`hello-world.md`

    {:title "A post"
     :layout :post
     :date "2017-01-19"
     :klipse true
     :tags ["cljs"]}
    
    ## Hello world!
    
    ```klipse-cljs
    (map #(* % %) (range 10))
    ```


### More complicated config

This one has some more configuration to show how you can override settings
in a specific post.

`config.edn`
```
{...
:hide-future-posts? true

:klipse {:settings {:selector ".klipse-cljs"
                    :selector-reagent ".klipse-reagent"
                    :selector-eval-ruby ".klipse-ruby"
                    :codemirror-options-in {:line-numbers true}
                    :codemirror-options-out {:line-numbers true}}
         ;; Set a css theme for the code snippets.
         :css-theme "/css/some-codemirror-theme.css"}

:debug? false}
```

`hello-world.md`

    {:title "A post"
     :layout :post
     :date "2017-01-19"
    
     ;; Override config.edn and turn off line numbers for snippet output.
     :klipse {:settings {:codemirror-options-out {:line-numbers false}}}
    
     :tags ["cljs"]}
    
    ## Hello world!
    
    ```klipse-ruby
    (0...10).map {|i| i * i}
    ```

