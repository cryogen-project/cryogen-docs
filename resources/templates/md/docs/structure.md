{:title "Cryogen's Directory Structure"
 :layout :page
 :page-index 2}
 
A basic Cryogen site usually* looks something like this:
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

  * `resources` - This is where all of your site content and configuration will go. It's divided into the `templates` folder and the `public` folder.
  * `public` - This is where the generated site will go once Cryogen is done compiling your content.
  * `templates` - The main folder where all your HTML layouts and Markdown content will go.
  * `css` - Pretty self explanatory. Put your css files here.
  * `html/layouts` - These are they templates that wrap posts and pages. Layouts are selected on a post-by-post basis and content gets injected by [Selmer](https://github.com/yogthos/selmer).
  * `js` - Also self explanatory.
  * `md` - Keep your Markdown content here.
  * `pages` - The root folder for all your custom Markdown pages. This folder name can be changed in `config.edn`.
  * `posts` - The root folder for all your post content in Markdown. This folder name can also be changed.
  * `404.html` - The default 404 page provided.
  * `config.edn` - Configuration data for your site.
  * `src/cryogen` - Contains the server.
  * `project.clj` - Your typical project file for a Clojure project.