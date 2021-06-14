{:title "Directory Structure"
 :layout :page
 :page-index 2
 :section "Getting Started"}
 
A basic Cryogen site usually looks something like this:
(New files may be added in the future)

```
my-blog
├── content
│   ├── asc
│   │   ├── pages
│   │   │   └── adoc-page.asc
│   │   └── posts
│   │       └── 2014-10-10-adoc-post.asc
│   ├── md
│   │   ├── pages
│   │   │   ├── about.md
│   │   │   └── another-page.md
│   │   └── posts
│   │       ├── 2014-03-10-first-post.md
│   │       ├── 2014-11-04-second-post.md
│   │       └── 2014-12-11-docs.md
│   ├── img
│   └── config.edn
├── public
│   ⋮
├── src
│   └── cryogen
│       ├── core.clj
│       └── server.clj
├── themes
│   ├── blue
│   │   ├── css
│   │   │   └── screen.css
│   │   ├── html
│   │   │   ├── 404.html
│   │   │   ├── archives.html
│   │   │   ├── base.html
│   │   │   ├── home.html
│   │   │   ├── page.html
│   │   │   ├── post-content.html
│   │   │   ├── post.html
│   │   │   ├── previews.html
│   │   │   ├── tag.html
│   │   │   └── tags.html
│   │   └── js
│   │       └── highlight.pack.js
│   └── blue_centered
│       ⋮
└── project.clj
```

| File/Dir              | Description                                                                                                                                       |
|-----------------------|---------------------------------------------------------------------------------------------------------------------------------------------------|
| `public`              | This is where the generated site will go (by default) once Cryogen is done compiling your content. This can be configured in `config.edn`         |
| `content`             | The main folder where all your Markdown/AsciiDoc content and other resources will go.                                                             |
| `themes`              | This directory contains themes that you may apply to your site. You may use a theme by specifying its name under the `theme` key in `config.edn`. |
| `content/config.edn`  | Configuration data for your site.                                                                                                                 |
| `content/asc`         | If you are using AsciiDoc then keep your content here.                                                                                            |
| `content/md`          | If you are using Markdown then keep your content here.                                                                                            |
| `pages`               | The root folder for all your custom Markdown/Asciidoc pages. This folder name can be changed in `config.edn`.                                     |
| `posts`               | The root folder for all your post content in Markdown/Asciidoc. This folder name can also be changed.                                             |
| `content/img`         | The default directory to place images.                                                                                                            |
| `themes/{theme}/css`  | Pretty self explanatory. Put your theme's css files here                                                                                          |
| `themes/{theme}/html` | These are the templates that wrap posts and pages. Layouts are selected on a post-by-post basis and content gets injected by Selmer.              |
| `themes/{theme}/js`   | Also self explanatory. The theme's JavaScript files go here.                                                                                      |
| `src/cryogen`         | Contains the core and server.                                                                                                                     |
| `project.clj`         | Your typical project file for a Clojure project.                                                                                                  |
<!-- TODO: Add {.table .table-bordered} when the flexmark ext. https://github.com/vsch/flexmark-java/wiki/Attributes-Extension added -->


The html templates use [Selmer](https://github.com/yogthos/Selmer) which can extend other templates. Most html templates extend off of `base.html`. The following diagram gives an overview of the Cryogen Selmer hierachy.

![Selmer Hierachy](/img/selmer-hierachy.png)

Markdown/AsciiDoc content is injected into their specified layout files and then injected into the base html layout to create each page of your site.  
