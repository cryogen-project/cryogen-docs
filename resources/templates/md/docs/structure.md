{:title "Directory Structure"
 :layout :page
 :page-index 2
 :section "Getting Started"}
 
A basic Cryogen site usually looks something like this:
(New files may be added in the future)

```
my-blog
 |---resources
 |   |---public
 |   |---templates
 |   |   |---css
 |   |   |   |---screen.css
 |   |   |---html
 |   |   |   |---layouts
 |   |   |       |---archives.html
 |   |   |       |---base.html
 |   |   |       |---home.html
 |   |   |       |---page.html
 |   |   |       |---post.html
 |   |   |       |---tag.html
 |   |   |---js
 |   |   |   |---highlight.pack.js
 |   |   |---md
 |   |   |   |---pages
 |   |   |   |   |---about.md
 |   |   |   |   |---another-page.md
 |   |   |   |---posts
 |   |   |       |---10-03-2014-first-post.md
 |   |   |       |---11-04-2014-second-post.md
 |   |   |       |---13-11-2014-docs.md
 |   |   |---404.html
 |   |   |---config.edn
 |---src
 |   |---cryogen
 |   |   |---server.clj
 |---project.clj
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
<td>The main folder where all your HTML layouts and Markdown content will go.</td>
</tr>
<tr>
<td>`css`</td>
<td>Pretty self explanatory. Put your css files here</td>
</tr>
<tr>
<td>`html/layouts`</td>
<td>These are they templates that wrap posts and pages. Layouts are selected on a post-by-post basis and content gets injected by Selmer.
</td>
</tr>
<tr>
<td>`js`</td>
<td>Also self explanatory. JavaScript files go here.</td>
</tr>
<tr>
<td>`md`</td>
<td>Keep your Markdown content here.
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
<td>`404.html`</td>
<td>The default 404 page provided.</td>
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
