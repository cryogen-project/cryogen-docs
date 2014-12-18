{:title "Configuration"
 :layout :post
 :page-index 3}
 
Cryogen provides some flexible configuration options. Your site's configuration file can be found at `templates/config.edn` and contains the following by default: 
 
```
{:site-title       "My Awesome Blog"
 :author           "Bob Bobbert"
 :description      "This blog is awesome"
 :site-url         "http://blogawesome.com/"
 :post-root        "posts"
 :tag-root         "tags"
 :page-root        "pages"
 :blog-prefix      "/blog"
 :recent-posts     5
 :post-date-format "dd-MM-yyyy"
 :rss-name         "feed.xml"
 :sass-src         nil
 :sass-dest        nil
 :resources        ["css" "js" "img"]
 :keep-files       [".git"] 
 :disqus?          false
 :disqus-shortname ""}
```

## Your options

  * `site-title` - Your site's title.
  * `author` - Your name goes here!
  * `description` - A blurb describing your site.
  * `site-url` - Your site's root url. All of the above values are used when generating your sitemap and RSS feed.
  * `post-root` - The folder where the compiler will look for blog posts. This value is prepended to all post uri's. Must be provided.
  * `tag-root` - This value is prepended to all tag page uri's. Must be provided.
  * `page-root` - The folder where the compiler will look for your custom pages. This value is prepended to all page uri's. Must be provided.
  * `blog-prefix` - Prepended to all uri's. This must start with a slash. 
  * `recent-posts` - The maximum number of recent posts to show in the sidebar.
  * `post-date-format` - Set the date format that you want to use for the names of your .md files representing your posts; nil defaults to yyyy-MM-dd.
  * `rss-name` - The name of the rss file generated, nil defaults to rss.xml.
  * `sass-src` -  Directory containing sass(scss) files to be compiled; nil defaults to "css". Be sure to include this directory in your resources section.
  * `sass-dest` - Directory where the compiled sass would be spit out; nil defaults to "css". Be sure to include this directory in your resources section.
  * `resources` - A vector of directories/files to be copied over from `template` to `public` upon compilation.
  * `keep-files` - When wiping the `public` folder, keep the listed directories/files; eg. you would want to keep your `.git` folder if you plan on publishing to Github Pages from the `public` folder.
  * `disqus?` - Set this to `true` if you want Disqus enabled on your site; nil defaults to `false`.
  * `disqus-shortname` - Your Disqus shortname.