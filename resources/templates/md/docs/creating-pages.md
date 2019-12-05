{:title "Creating Pages"
 :layout :page
 :page-index 5
 :section "Your Content"
 :toc true}

Creating pages is not much different from writing posts. You're still required to include the map representing the metadata and the page must be written in valid Markdown.

## The Pages Folder

Similar to your posts, all of your pages should reside under the `page-root` folder specified in your configuration file. Again, as long as the file contains the proper metadata followed by valid Markdown content, they will be converted into an HTML page.

## Creating Pages

To create a new page, just make a new Markdown/AsciiDoc file under your `page-root`. You don't need to include a date in the file name or in the metadata like you did a post but words should still be dash-separated and the file must have a `.md` or `.asc` extension. For example:

```
about.md
my-projects.md
contact-me.asc
```

### Page Contents

The following information is mandatory in your page metadata.

<table class="table table-bordered">
<thead>
<tr>
<th>Key</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr>
<td>`title`</td>
<td>Your post title provided as a string.</td>
</tr>
<tr>
<td>`page-index`</td>
<td>Because pages can be linked up with previous/next links, this is how they get sorted.</td>
</tr>
</tbody>
</table>

These are some optional keys that you may provide:

<table class="table table-bordered">
<thead>
<tr>
<th>Key</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr>
<td>`navbar?`</td>
<td>Set this to `true` if you want the link to this page to appear in the navbar. Set it to `false` or leave out the key if you want it in the sidebar.</td>
</tr>
<tr>
<td>`home?`</td>
<td>Set this to `true` if you want to use this page as your index rather than a blog post or list of previews. Only one page may have this flag set to `true`. This page will not be part of your `navbar-pages` or `sidebar-pages` collection. The `:layout` key will be respected. `:previews?` must be set to `false` in the `config.edn`.</td>
</tr>
<tr>
<td>`klipse`</td>
<td>Set [Klipse](https://github.com/viebel/klipse) configuration for the post.
See [Klipse Integration](klipse.html) for details.</td>
</tr>
<tr>
<td>`layout`</td>
<td>A keyword corresponding to an HTML file under `themes/{theme}/html`.
Defaults to `:page`.</td>
<td>`description`</td>
<td>Provide a custom description for the post (available as `{{post.description}}` in the templates) instead of the one created automatically from the post's preview. Set it to `false` to disable description for the page. (`post.description` will thus be nil.)</td>
</tr>
</tbody>
</table>

For example:

```
{:title      "Check out this page!"
 :page-index 0
 :navbar?    false
 :home?      false}
```

### Images in Your Pages

You can include images in your pages in the same way you include images in your blog posts. Please refer to the "Including Images in Posts" and "Images in Markdown" sections of the [Writing Posts](/docs/writing-posts.html) page.

### Highlighting Code Snippets

Want to show off your code in a page? It works the same way as it does in posts. Just wrap your code block in triple backticks and highlight.js will take care of the rest.
