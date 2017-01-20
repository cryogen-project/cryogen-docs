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
There are two places to configure klipse, in `config.edn` and in the post/page metadata.
The two are merged so that the config in the post/page overrides the config in `config.edn`.

## Configuration

The configuration is a map that may include the following keys.

### :settings

Contains a map that's passed to `window.klipse_settings`.
All the settings are documented [here](https://github.com/viebel/klipse#configuration).
In cryogen you can use `:lisp-cased-keywords` instead of `"snake_cased_strings"`.

### :js-src

A map with the keys `:min` and `:non-min`. These are uris that point to the
minified and non-minified version of the klipse plugin.
They default to the plugin hosted by klipse, but to host it yourself,
just set the appropriate uris.

### :js

Can be either `:min` or `:non-min`. Self-hosted clojurescript is not (yet?)
compatible with advanced compilation, so if a post has cljs snippets, it needs
to use the non-minified version, but any other languages can use the minified version.

Cryogen will infer this from which selectors are included in the `:settings`,
so you don't have to include this key, but you can override it if it is inferred incorrectly.

### :css-base

The uri to the codemirror css that is used by klipse. As with `:js-src`,
it defaults to css hosted by klipse and you can override it if you want
to host it yourself.

### :css-theme

You can also use a codemirror theme for the snippets,
just set this to a uri pointing to one.

## Example

`config.edn`
```clojure
{...
:hide-future-posts? true

;; Turn on line numbers for the input and output.
:klipse {:settings {:codemirror-options-in {:line-numbers true}
                    :codemirror-options-out {:line-numbers true}}
         ;; Set a css theme for the code snippets.
         :css-theme "/css/some-codemirror-theme.css"}

:debug? false}
```

`hello-world.md`
```
{:title "A post"
 :layout :post
 :date "2017-01-19"

 ;; Code blocks with the css selector klipse-clojure will be eval'd with clojurescript
 :klipse {:settings {:selector ".klipse-clojure"

                     ;; Override config.edn and turn off line numbers for snippet output.
                     :codemirror-options-out {:line-numbers false}}}

 :tags ["cljs"]}

## Hello world!

Lorem ipsum etc.
```
