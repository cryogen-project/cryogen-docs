{:title "Customizing your Index Page"
 :layout :page
 :page-index 7
 :section "Your Content"}

You have several options when choosing what content to display on the home page of your blog.

## The Single Page Option
This option allows you to display a dedicated page on the index of your site. To do so, you must declare one of your pages as the home page by setting the `:home?` flag to `true` in the meta data of the page you wish to use.

## The Single Post Option

This option allows you to display your latest blog post on the index of your site. The prev/next links then allow readers to navigate between blog posts.

(Ex. [yogthos.net](http://yogthos.net/))

This option requires no changes to the default `config.edn` file. Just set the `:previews?` key to `false` and you're good to go.

## Showing a List of Previews

This option will allow you to display a number of "previews" of your blog posts on your index page. Each preview will show the post title followed by a snippet from the post and a link to the full article. Clicking the prev/next links will then allow readers to view the next set of previews.

An example taken from the project owner's blog:

![Preview Example](/img/preview-example.png)

To set up the previews there are three keys that you need to update in `config.edn`.

`:posts-per-page` - Set this to the number of previews that you want to display on your index page.

`:blocks-per-preview` - This is the number of html blocks that will be displayed in each preview by default. For example, if your blog posts consists of an `h2` tag and eight `p` tags then setting the value of this key to `3` will show the `h2` tag and two of the `p` tags in the post snippet.

If you want to override the default snippet length then you can insert a `<!--more-->` marker into your Markdown/AsciiDoc file to indicate where you'd like to break off your snippet.

`:previews?` - This needs to be set to `true`.
