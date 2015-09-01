{:title "Configuration"
 :layout :post
 :page-index 3
 :section "Getting Started"}
 
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
 :rss-name         "feed.xml"
 :rss-filters      ["cryogen"]
 :recent-posts     3
 :post-date-format "yyyy-MM-dd"
 :sass-src         nil
 :sass-dest        nil
 :theme            "blue"
 :resources        ["img"]
 :keep-files       [".git"] 
 :disqus?          false
 :disqus-shortname ""
 :ignored-files    [#"\.#.*" #".*\.swp$"]
 :posts-per-page 5
 :blocks-per-preview 2
 :previews? false}
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
<td>`site-title`</td>
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
<td>Your site's root url. All of the above values are used when generating your sitemap and RSS feed.</td>
</tr>
<tr>
<td>`post-root`</td>
<td>The folder where the compiler will look for blog posts. This value is prepended to all post uri's. Must
be provided.
</td>
</tr>
<tr>
<td>`tag-root`</td>
<td>This value is prepended to all tag page uri's. Must be provided.</td>
</tr>
<tr>
<td>`page-root`</td>
<td>The folder where the compiler will look for your custom pages. This value is prepended to all page
uri's. Must be provided.
</td>
</tr>
<tr>
<td>`blog-prefix`</td>
<td>Prepended to all uri's. This must start with a slash.</td>
</tr>
<tr>
<td>`rss-name`</td>
<td>The name of the rss file generated, nil defaults to rss.xml.</td>
</tr>
<tr>
<td>`rss-filters`</td>
<td>Specific tags for which you want to create a separate RSS feed for</td>
</tr>
<tr>
<td>`recent-posts`</td>
<td>The maximum number of recent posts to show in the sidebar.</td>
</tr>
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
<td>Your Disqus shortname</td>
</tr>
<tr>
<td>`ignored-files`</td>
<td>Regexes matching files that you want to ignore during compilation. Ex: emacs interlock files.</td>
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
<td>`previews?`</td>
<td>Set this to `true` if you would like to display a list of recent posts rather than a full, single post on your home page.</td>
</tr>
<tr>
</tr>
</tbody>
</table>

In addition to these default configuration options, you may add your own custom values. For example, if your blog has a subtitle that you'd like to display on your site:

1. Add `:subtitle "My subtitle"` to the config file
2. Inject the value into your templates via Selmer using `{% subtitle %}`
