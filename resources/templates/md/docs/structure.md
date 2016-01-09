{:title "Directory Structure"
 :layout :page
 :page-index 2
 :section "Getting Started"}
 
A basic Cryogen site usually looks something like this:
(New files may be added in the future)

```
my-blog
├── resources
│   ├── public
│   │   ⋮
│   └── resources
│       ├── asc
│       │   ├── pages
│       │   │   └── adoc-page.asc
│       │   └── posts
│       │       └── 2014-10-10-adoc-post.asc
│       ├── md
│       │   ├── pages
│       │   │   ├── about.md
│       │   │   └── another-page.md
│       │   └── posts
│       │       ├── 2014-03-10-first-post.md
│       │       ├── 2014-11-04-second-post.md
│       │       └── 2014-12-11-docs.md
│       ├── img
│       ├── themes
│       │   ├── blue
│       │   │   ├── css
│       │   │   │   └── screen.css
│       │   │   ├── html
│       │   │   │   ├── 404.html
│       │   │   │   ├── archives.html
│       │   │   │   ├── base.html
│       │   │   │   ├── home.html
│       │   │   │   ├── page.html
│       │   │   │   ├── post-content.html
│       │   │   │   ├── post.html
│       │   │   │   ├── previews.html
│       │   │   │   ├── tag.html
│       │   │   │   └── tags.html
│       │   │   └── js
│       │   │       └── highlight.pack.js
│       │   └── blue_centered
│       │       ⋮
│       ├── config.edn
├── src
│   └── cryogen
│       ├── core.clj
│       └── server.clj       
└── project.clj
```

<table class="table table-bordered">
<thead>
<tr>
<th>File/Dir</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr>
<td>`resources`</td>
<td>This is where all of your site content and configuration will go. It's divided into the `templates` folder and the `public` folder.</td>
</tr>
<tr>
<td>`public`</td>
<td>This is where the generated site will go once Cryogen is done compiling your content.</td>
</tr>
<tr>
<td>`templates`</td>
<td>The main folder where all your HTML themes and Markdown/AsciiDoc content will go.</td>
</tr>
<tr>
<td>`asc`</td>
<td>If you are using AsciiDoc then keep your content here.
</td>
</tr>
<tr>
<td>`md`</td>
<td>If you are using Markdown then keep your content here.
</td>
</tr>
<tr>
<td>`pages`</td>
<td>The root folder for all your custom Markdown/Asciidoc pages. This folder name can be changed in config.edn.</td>
</tr>
<tr>
<td>`posts`</td>
<td>The root folder for all your post content in Markdown/Asciidoc. This folder name can also be changed.</td>
</tr>
<tr>
<td>`img`</td>
<td>The default directory to place images.</td>
</tr>
<tr>
<td>`themes`</td>
<td>This directory contains themes that you may apply to your site. You may use a theme by specifying its name under the `theme` key in `config.edn`.</td>
</tr>
<tr>
<td>`themes/{theme}/css`</td>
<td>Pretty self explanatory. Put your theme's css files here</td>
</tr>
<tr>
<td>`themes/{theme}/html`</td>
<td>These are the templates that wrap posts and pages. Layouts are selected on a post-by-post basis and content gets injected by Selmer.
</td>
</tr>
<tr>
<td>`themes/{theme}/js`</td>
<td>Also self explanatory. The theme's JavaScript files go here.</td>
</tr>
<tr>
<td>`config.edn`</td>
<td>Configuration data for your site.</td>
</tr>
<tr>
<td>`src/cryogen`</td>
<td>Contains the core and server.</td>
</tr>
<tr>
<td>`project.clj`</td>
<td>Your typical project file for a Clojure project.</td>
</tr>
</tbody>
</table>

The html templates use [Selmer](https://github.com/yogthos/Selmer) which can extend other templates. Most html templates extend off of `base.html`. The following diagram gives an overview of the Cryogen Selmer hierachy.

![Selmer Hierachy](/img/selmer-hierachy.png)

Markdown/AsciiDoc content is injected into their specified layout files and then injected into the base html layout to create each page of your site.  