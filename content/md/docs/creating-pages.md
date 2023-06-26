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

You may include an [EDN](https://github.com/edn-format/edn)-formatted map of metadata at the start of your page file. If you do include such a map, the following information is mandatory:

| Key          | Description                                                                           |
|--------------|---------------------------------------------------------------------------------------|
| `title`      | Your post title provided as a string.                                                 |
| `page-index` | Because pages can be linked up with previous/next links, this is how they get sorted. |
{.table .table-bordered}


These are some optional keys that you may provide:

| Key           | Description                                                                                                                                                                                                                                                                                                                               |
|---------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `navbar?`     | Set this to `true` if you want the link to this page to appear in the navbar. Set it to `false` or leave out the key if you want it in the sidebar.                                                                                                                                                                                       |
| `home?`       | Set this to `true` if you want to use this page as your index rather than a blog post or list of previews. Only one page may have this flag set to `true`. This page will not be part of your `navbar-pages` or `sidebar-pages` collection. The `:layout` key will be respected. `:previews?` must be set to `false` in the `config.edn`. |
| `toc`         | Set this to true if you want a table of contents to be generated from the headers/headings in your post. (The default table of contents format is an ordered list. Set this to `:ul` if you want a bulleted list.)                                                                                                                        |
| `toc-class`   | Specify the class that you want attached to the root element of your TOC (either `ul` or `li`). If this is not provided then the compiler will look for the class in `config.edn`. If neither are provided then `"toc"` is used.                                                                                                          |
| `klipse`      | Set [Klipse](https://github.com/viebel/klipse) configuration for the post. See [Klipse Integration](klipse.html) for details.                                                                                                                                                                                                             |
| `layout`      | A keyword corresponding to an HTML file under `themes/{theme}/html`. Defaults to `:page`.                                                                                                                                                                                                                                                 |
| `description` | Provide a custom description for the page (available as `{{page.description}}` in the templates) instead of the one created automatically from the post's preview. Set it to `false` to disable description for the page. (`page.description` will thus be nil.)                                                                          |
| `image`       | Path to an image illustrating the page, *or* a map with the keys as documented below; in either case, used to provide the metadata to allow social media platforms to construct a rich Open Graph banner for a link to your post. |
{.table .table-bordered}

For example:

```
{:title      "Check out this page!"
 :page-index 0
 :navbar?    false
 :home?      false}
```

If you include a map rather than a path as the value of `:image`, it should have keys as follows:

| Key                         | Description                                                                                                                                                           |
|-----------------------------|---------------------------------------------------------------------------|
| {style="width:100px"} `alt` | a description of the image intended to describe it to users with visual impairments. |
| `height` | the height of the image in pixels as a number. |
| `path` | the path to the image. |
| `type` | the [MIME type](https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types) of the image, as a string; typically one of "image/gif", "image/jpeg", or "image/png". |
| `width` | the width of the image in pixels as a number. |
{.table .table-bordered}

If you don't include a map of metadata at the head of your post, an attempt will be made to construct such a map. Fields will be constructed as follows:

| Key                         | Derivation                                                                                                                                                           |
|-----------------------------|---------------------------------------------------------------------------|
| {style="width:100px"} `author` | will be inferred from the owner of the file. This will be passed to an appropriate operating system mechanism to retrieve the real name associated with that user account, if any. |
| `description` | will be taken from the first normal paragraph of the text. |
| `image` | will be taken from the first image linked in the text, if any. |
| `title` | will be taken from the first top level heading in the text, or, failing that, from the name of the file with the date part (if any) and extension removed. |
{.table .table-bordered}

There are clearly, then, fields which are not currently inferred; these are:

1. `:home?`;
2. `:klipse` &mdash; which could be inferred and may be in the future but is not now;
3. `:layout`;
4. `:navbar?`;
5. `:page-index` &mdash; this is not currently inferred but clearly should be;
6. `:toc` &mdash; this again could be inferred but is not currently.

If you wish to use any of these fields you **must** embed metadata in your file; and, curently, you cannot use both embedded and inferred metadata: if a metadata map is found, no metadata will be inferred.

### Images in Your Pages

You can include images in your pages in the same way you include images in your blog posts. Please refer to the "Including Images in Posts" and "Images in Markdown" sections of the [Writing Posts](/docs/writing-posts.html) page.

### Linking to other Posts or Pages

You can link to other pages or posts on your site in [the same way you include these links in your blog posts](/docs/writing-posts.html#linking_to_other_posts_or_pages).

### Highlighting Code Snippets

Want to show off your code in a page? It works the same way as it does in posts. Just wrap your code block in triple backticks and highlight.js will take care of the rest.
