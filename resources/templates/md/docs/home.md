{:title "Welcome"
 :layout :page
 :page-index 0
 :section "Getting Started"}

This site aims to be a complete guide to Cryogen. I hope to cover how to get your site up and running, creating and managing your content and layouts, customizing the aesthetics and functionality of your site, and finally how to deploy your site.

## What is Cryogen?

Cryogen is a simple static site generator built with Clojure. It's shipped on Leiningen so setup is fuss free and there's no need to mess with databases or other CMS systems. 

Cryogen reads through a directory containing your Markdown content, compiles it into HTML and injects the content into your templates with the [Selmer](https://github.com/yogthos/selmer) templating system. It then spits out a ready-to-publish website complete with a sitemap and RSS feed.
 
If you come across anything along the way that this guide doesn't cover, please [open an issue](https://github.com/lacarmen/cryogen/issues/new) on the Github page and further instructions can be included here.

