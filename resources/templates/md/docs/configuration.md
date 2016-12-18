{:title "Configuration"
 :layout :post
 :page-index 3
 :section "Getting Started"}

Cryogen provides some flexible configuration options. Your site's configuration file can be found at `templates/config.edn` and contains the following by default:

```
{:site-title           "My Awesome Blog"
 :author               "Bob Bobbert"
 :description          "This blog is awesome"
 :site-url             "http://blogawesome.com/"
 :post-root            "posts"
 :page-root            "pages"
 :post-root-uri        "posts-output"
 :page-root-uri        "pages-output"
 :tag-root-uri         "tags-output"
 :author-root-uri      "authors-output"
 :blog-prefix          "/blog"
 :rss-name             "feed.xml"
 :rss-filters          ["cryogen"]
 :recent-posts         3
 :post-date-format     "yyyy-MM-dd"
 :archive-group-format "yyyy MMMM"
 :sass-src             nil
 :sass-dest            nil
 :sass-path            "sass"
 :compass-path         "compass"
 :theme                "blue"
 :resources            ["img"]
 :keep-files           [".git"]
 :disqus?              false
 :disqus-shortname     ""
 :ignored-files        [#"\.#.*" #".*\.swp$"]
 :previews?            false
 :posts-per-page       5
 :blocks-per-preview   2
 :clean-urls?          true
 :hide-future-posts?   true}
```

## Your options

<table class="table table-bordered">
<thead>
<tr>
<th>Key</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr>
<td style="width:150px">`site-title`</td>
<td>Your site's title</td>
</tr>
<tr>
<td>`author`</td>
<td>Your name goes here!</td>
</tr>
<tr>
<td>`description`</td>
<td>A blurb describing your site</td>
</tr>
<tr>
<td>`site-url`</td>
<td>Your site's root url. This, along with all of the above values are used when generating your sitemap and RSS feed.</td>
</tr>
<tr>
<td>`post-root`</td>
<td>The folder where the compiler will look for blog posts. Must be provided.
</td>
</tr>
<tr>
<td>`page-root`</td>
<td>The folder where the compiler will look for your custom pages. Must be provided.
</td>
</tr>
<tr>
<td>`post-root-uri`</td>
<td>The folder where the compiler will output compiled blog posts. This value is prepended to all post uri's. If this value is `nil` then the name of the output folder will be the same as the `post-root` folder. If the empty string ("") is provided then the posts will be outputted to the root folder of the blog (ie. `resources/public/{blog-prefix}`).
</td>
</tr>
<tr>
<tr>
<td>`page-root-uri`</td>
<td>The folder where the compiler will output compiled pages. This value is prepended to all page uri's. If this value is `nil` then the name of the output folder will be the same as the `page-root` folder. If the empty string ("") is provided then the posts will be outputted to the root folder of the blog.
</td>
</tr>
<td>`tag-root-uri`</td>
<td>The folder where the compiler will output compiled tag pages. This value is prepended to all tag page uri's. If no value is provided then the empty string will be used.</td>
</tr>
<tr>
</tr>
<td>`author-root-uri`</td>
<td>If this value is provided then the compiler will generate a page for each author containing a list of all their posts. More info [here](/docs/writing-posts.html#multiple_authors).</td>
</tr>
<td>`blog-prefix`</td>
<td>Prepended to all uri's. This must start with a slash.</td>
</tr>
<tr>
<td>`rss-name`</td>
<td>The name of the rss file generated, nil defaults to rss.xml.</td>
</tr>
<tr>
<td>`rss-filters`</td>
<td>Specific tags for which you want to create a separate RSS feed.</td>
</tr>
<tr>
<td>`recent-posts`</td>
<td>The maximum number of recent posts to show in the sidebar.</td>
</tr>
<tr>
<td>`archive-group-format`</td>
<td>Set the date format in which your archive page is organised. "yyyy" organises by year, "yyyy MMMM" organises by year and month; nil defaults to "yyyy MMMM".
<tr>
<td>`post-date-format`</td>
<td>Set the date format that you want to use for the names of your .md files representing your posts; nil defaults to yyyy-MM-dd.</td>
</tr>
<tr>
<td>`sass-src`</td>
<td>Directory containing sass(scss) files to be compiled; nil defaults to "css". Be sure to include this directory in your resources section.</td>
</tr>
<tr>
<td>`sass-dest`</td>
<td>Directory where the compiled sass would be spit out; nil defaults to "css". Be sure to include this directory in your resources section.</td>
</tr>
<tr>
<td>`sass-path`</td>
<td>Path at which the `sass` executable can be found. The default value "sass" works if you have the executable in your path, in that case
nothing needs to be changed. If the executable is not in the
search path or has a different name than please adapt this value.
</td>
</tr>
<tr>
<td>`compass-path`</td>
<td>Path at which the `compass` executable can be found.
Just as with the `sass-path` fhe default value "compass" works
if you have the executable in your path, in that case
nothing needs to be changed. If the executable is not in the
search path or has a different name than please adapt this value.
</td>
</tr>
<tr>
<td>`theme`</td>
<td>Set this to the theme you wish to deliver from the `themes` directory. You can add your own theme to this folder along with the current `blue` and `blue_centered` themes. Must be provided.</td>
</tr>
<tr>
<td>`resources`</td>
<td>A vector of directories/files to be copied over from `templates` to `public` upon compilation.</td>
</tr>
<tr>
<td>`keep-files`</td>
<td>When wiping the `public` folder, keep the listed directories/files; eg. you would want to keep your `.git` folder if you plan on publishing to Github Pages from the `public` folder.</td>
</tr>
<tr>
<td>`disqus?`</td>
<td>Set this to `true` if you want Disqus enabled on your site; nil defaults to `false`.</td>
</tr>
<tr>
<td>`disqus-shortname`</td>
<td>Your Disqus shortname.</td>
</tr>
<tr>
<td>`ignored-files`</td>
<td>Regexes matching files that you want to ignore during compilation. Ex: emacs interlock files.</td>
</tr>
<tr>
<td>`previews?`</td>
<td>Set this to `true` if you would like to display a list of recent posts rather than a full, single post on your home page. Discussed [here](/docs/customizing-the-index.html).</td>
</tr>
<tr>
<td>`post-per-page`</td>
<td>If post previews are enabled then this is the maximum number of previews on a page.</td>
</tr>
<tr>
<td>`blocks-per-preview`</td>
<td>The default number of (html) blocks to display per post preview. This can be overwritten by adding `<!--more-->` to your .md or .asc file to indicate where you'd like to break off your post.</td>
</tr>
<tr>
<td>`clean-urls?`</td>
<td>Set this to `true` to emit html as subdirectories, e.g., `prefix/root/page-name/index.html` instead of `prefix/root/page-name.html`. Links would then end in `/page-name/` instead of `/page-name.html`. Defaults to `true`.
</td>
</tr>
<tr>
<td>`hide-future-posts?`</td>
<td>Set this to `true` to include only current and past blogs in the compiled site. This allows for easy drafting of future articles.</td>
</tr>
</tbody>
</table>

In addition to these default configuration options, you may add your own custom values. For example, if your blog has a subtitle that you'd like to display on your site:

1. Add `:subtitle "My subtitle"` to the config file
2. Inject the value into your templates via Selmer using `{% subtitle %}`
