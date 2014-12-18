{:title "Cryogen's Directory Structure"
 :layout :page
 :page-index 2}
 
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

