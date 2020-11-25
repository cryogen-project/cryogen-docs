{:title "Klipse Integration"
 :layout :page
 :page-index 8
 :section "Your Content"
 :toc true}

[Klipse](https://github.com/viebel/klipse)
is a javascript plugin that transforms static code snippets of an html page into live and
interactive snippets. making code snippets on a web page interactive.
Visitors can edit the snippets and they are evaluated continuously as they type.

In Cryogen you can integrate Klipse in your blog with minimal effort.
To get started, configure the Klipse plugin in `config.edn` and set `:klipse` to `true` in
the post or page metadata.
Alternatively you can override parts of the global configuration by passing a
configuration map containing the desired changes to the `:klipse` key in the post/page metadata.

## Configuration

The configuration is a map that may include the keys described below. The map must must contain at least selectors for the language(s) you want to klipsify, see examples below.

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
All the settings are documented [here](https://github.com/viebel/klipse#configuration). (In cryogen you can use `:lisp-cased-keywords` instead of `"snake_cased"`/`"camelCased"` strings.)
</td>
</tr>
<tr>
<td>`js-src`</td>
<td>A map with the keys `:min` and `:non-min`. These are uris that point to the
minified and non-minified version of the Klipse plugin.
They default to the plugin hosted by Klipse, but to host it yourself,
just set the appropriate uris.
</td>
</tr>
<tr>
<td>`js`</td>
<td>Can be either `:min` or `:non-min`. Self-hosted clojurescript is not (yet?)
compatible with advanced compilation, so if a post has cljs snippets, it needs
to use the non-minified version, but any other languages can use the minified version.
<br><br>
Cryogen will infer this based on the setting and the classes in the code blocks
in each post, so normally you don't need to worry about it.
Can be overridden if necessary.</td>
</tr>
<tr>
<td>`css-base`</td>
<td>The uri to the codemirror css that is used by Klipse. As with `:js-src`,
it defaults to css hosted by Klipse and you can override it if you want
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

This config is all you need to write code blocks with live vanilla ClojureScript,
Reagent and/or Ruby evaluation.

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

Alternatively, for asciidoc:

`hello-world.asc`

    {:title "A post"
     :layout :post
     :date "2017-01-19"
     :klipse true
     :tags ["cljs"]}

    == Hello world!

    [source,klipse-cljs]
    ----
    (map #(* % %) (range 10))
    ----

(Notice that in both cases `language-` is prepended to the language so the selector is `.language-klipse-cljs`.)

### More advanced config

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
