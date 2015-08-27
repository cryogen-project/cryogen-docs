{:title "Directory Structure"
 :layout :page
 :page-index 2
 :section "Getting Started"}
 
A basic Cryogen site usually looks something like this:
(New files may be added in the future)

```
my-blog
├── project.clj
├── src
│   └── cryogen
│       ├── core.clj
│       └── server.clj
└── resources
└── templates
├── md
│   ├── posts
│   │   ├── 2014-11-04-second-post.md
│   │   ├── 2014-03-10-first-post.md
│   │   └── 2014-12-11-docs.md
│   └── pages
│       ├── another-page.md
│       └── about.md
├── config.edn
├── themes
│   ├── blue
│   │   ├── css
│   │   │   └── screen.css
│   │   ├── html
│   │   │   ├── base.html
│   │   │   ├── page.html
│   │   │   ├── home.html
│   │   │   ├── tags.html
│   │   │   ├── 404.html
│   │   │   ├── archives.html
│   │   │   ├── previews.html
│   │   │   ├── post.html
│   │   │   ├── post-content.html
│   │   │   └── tag.html
│   │   └── js
│   │       └── highlight.pack.js
│   └── blue_centered
│       ├── css
│       │   └── screen.css
│       ├── html
│       │   ├── base.html
│       │   ├── page.html
│       │   ├── home.html
│       │   ├── tags.html
│       │   ├── 404.html
│       │   ├── archives.html
│       │   ├── previews.html
│       │   ├── post.html
│       │   ├── post-content.html
│       │   └── tag.html
│       └── js
│           └── highlight.pack.js
├── img
└── asc
├── posts
│   └── 2014-10-10-adoc-post.asc
└── pages
                └── adoc-page.asc
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
<td>`Resources`</td>
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
<td>`themes`</td>
<td>This directory contains selectable themes for html/css/js that you can choose via config.edn to apply to your site.</td>
</tr>
<tr>
<td>`themes\{theme}\css`</td>
<td>Pretty self explanatory. Put your themes css files here</td>
</tr>
<tr>
<td>`themes\{theme}\html`</td>
<td>These are they templates that wrap posts and pages. Layouts are selected on a post-by-post basis and content gets injected by Selmer.
</td>
</tr>
<tr>
<td>`themes\{theme}\js`</td>
<td>Also self explanatory. The themes JavaScript files go here.</td>
</tr>
<tr>
<td>`md`</td>
<td>Keep your Markdown content here.
</td>
</tr>
<tr>
<td>`asc`</td>
<td>Keep your AsciiDoc content here.
</td>
</tr>
<tr>
<td>`pages`</td>
<td>The root folder for all your custom Markdown pages. This folder name can be changed in config.edn.</td>
</tr>
<tr>
<td>`posts`</td>
<td>The root folder for all your post content in Markdown. This folder name can also be changed.</td>
</tr>
<tr>
<td>`img`</td>
<td>The default directory to place images.</td>
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
<td>`sass-src`</td>
<td>Directory containing sass(scss) files to be compiled; nil defaults to "css". Be sure to include this directory in your resources section.</td>
</tr>
<tr>
<td>`project.clj`</td>
<td>Your typical project file for a Clojure project.</td>
</tr>
</tbody>
</table>
