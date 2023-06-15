{:title "Writing Posts"
 :layout :page
 :page-index 4
 :section "Your Content"
 :toc true}

Blogging with Cryogen is part of its core functionality. You can simply maintain a folder of text files containing Markdown/AsciiDoc content and Cryogen will take care of compiling them into a blog.

## The Posts Folder

All of your blog posts should reside under the `post-root` folder specified in your configuration file. As long as the file contains the proper metadata (discussed later) about the layout of the post followed by valid Markdown/AsciiDoc content, they will be converted into an HTML page.

## Creating Posts

To create a new blog post, all you need to do is create a new Markdown or AsciiDoc file (depending on what you're using - you can only choose one) under your `post-root` directory. If you are using Markdown then the files should reside under `content/md/{post-root}`. If you are using AsciiDoc then the files should reside under `content/asc/{post-root}`. You must add a date to your post in one of two ways.

The first option is to specify the date of the post right in the name of the Markdown file. The way you name these files is important. The date format in your file name must match the date format specified in your `config.edn` file.

For example, if your specified date format in your configuration file was `dd-MM-yyyy`, Cryogen would require your posts to be named in this format:

```
dd-MM-yyyy-title.md
```

If no date format was specified in the configuration file, the default is the ISO 8601 format (yyyy-MM-dd).

Alternatively, you can leave the date out of the post name and specify it in the metadata of the file under the `:date` key. The date format must also match the format specified in your `config.edn` file in this case.

Finally, if you don't have embedded metadata in your post, the date will be taken from the file creation date of your post's markdown file.

If your title is more than one word long, it must be separated by dashes.

### Post Contents

Every Markdown file representing a post may contain metadata about the title and layout of the post. This is provided as a Clojure map at the beginning of the Markdown file. If you do provide such a map, the following data is required:

| Key     | Description                           |
|---------|---------------------------------------|
| `title` | Your post title provided as a string. |
{.table .table-bordered}

These are some optional keys that you may provide:

| Key                         | Description                                                                                                                                                                                                                                                      |
|-----------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| {style="width:100px"}`date` | The date that your post was written. Must follow the date format specified in `config.edn`. <u>Not</u> optional if you did not include the post date in the file name.                                                                                           |
| `author`                    | The name of the author of the post.                                                                                                                                                                                                                              |
| `tags`                      | A vector of strings representing any tags associated with the post.                                                                                                                                                                                              |
| `toc`                       | Set this to true if you want a table of contents to be generated from the headers/headings in your post. (The default table of contents format is an ordered list. Set this to `:ul` if you want a bulleted list.)                                               |
| `toc-class`                 | Specify the class that you want attached to the root element of your TOC (either `ul` or `li`). If this is not provided then the compiler will look for the class in `config.edn`. If neither are provided then `"toc"` is used.                                 |
| `draft?`                    | Files that have this key set to `true` will not be included in the compilation process.                                                                                                                                                                          |
| `klipse`                    | Set [Klipse](https://github.com/viebel/klipse) configuration for the post. See [Klipse Integration](klipse.html) for details.                                                                                                                                    |
| `layout`                    | A keyword corresponding to an HTML file under `themes/{theme}/html`. Defaults to `:post` for posts.                                                                                                                                                              |
| `description`               | Provide a custom description for the post (available as `{{post.description}}` in the templates) instead of the one created automatically from the post's preview. Set it to `false` to disable description for the page. (`post.description` will thus be nil.) |
| `image`                     | Path to an image illustrating the page, *or* a map with the keys as documented below; in either case, used to provide the metadata to allow social media platforms to construct a rich Open Graph banner for a link to your post. |
{.table .table-bordered}

If you include a map rather than a path as the value of `:image`, it should have keys as follows:

| Key                         | Description                                                                                                                                                           |
|-----------------------------|---------------------------------------------------------------------------|
| {style="width:100px"} `alt` | a description of the image intended to describe it to users with visual impairments. |
| `height` | the height of the image in pixels as a number. |
| `path` | the path to the image. |
| `type` | the [MIME type](https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types) of the image, as a string; typically one of `"image/gif"`, `"image/jpeg"`, or `"image/png"`. |
| `width` | the width of the image in pixels as a number. |
{.table .table-bordered}

The rest of your file should contain valid Markdown content. For example:

```
{:title  "First Post!"
 :layout :post
 :date   "2016-01-01"
 :tags   ["tag1" "tag3"]
 :author "Jane Doe"}

 ## Hello World

 This is my first post!

 Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 Nunc sodales pharetra massa, eget fringilla ex ornare et.
 Nunc mattis diam ac urna finibus sodales. Etiam sed ipsum
 et purus commodo bibendum. Cras libero magna, fringilla
 tristique quam sagittis, volutpat auctor mi. Aliquam luctus,
 nulla et vestibulum finibus, nibh justo semper tortor, nec
 vestibulum tortor est nec nisi.
```

### Multiple Authors

You can specify the author for a particular post by including the `:author` key in the post metadata as shown above. If you happen to have multiple authors writing on your blog and want to generate a page with posts filtered by author you should provide the `:author-root-uri` value in the `config.edn` file. The compiler will use the `themes/{theme}/html/author.html` layout and will generate a page with the same name as the author. For post without author the global `:author` value from `config.edn` will be used.

### Tags

Cryogen will automatically create a page for each unique tag that you've used in your posts.

### Posts without embedded metadata

If you don't include a map of metadata at the head of your post, an attempt will be made to construct such a map. Fields will be constructed as follows:

| Key                         | Derivation                                                                                                                                                           |
|-----------------------------|---------------------------------------------------------------------------|
| {style="width:100px"} `author` | will be inferred from the owner of the file. This will be passed to an appropriate operating system mechanism to retrieve the real name associated with that user account, if any. |
| `date` | will be taken from the name of the file, if you've used a name as suggested above, or, failing that, from the creation date of the file. |
| `description` | will be taken from the first normal paragraph of the text. |
| `image` | will be taken from the first image linked in the text, if any. |
| `tags` | will be taken from a contatenation of the text of all paragraphs which start with the emboldened string 'Tags:' (i.e., in Markdown, `**Tags:**`), considered as comma-separated values. |
| `title` | will be taken from the first top level heading in the text, or, failing that, from the name of the file with the date part (if any) and extension removed. |
{.table .table-bordered}

There are clearly, then, fields which are not currently inferred; these are:

1. `:draft?`;
2. `:klipse` &mdash; which could be inferred and may be in the future but is not now;
3. `:layout`;
4. `:toc` &mdash; this again could be inferred but is not currently.

If you wish to use any of these fields you **must** embed metadata in your file; and, curently, you cannot use both embedded and inferred metadata: if a metadata map is found, no metadata will be inferred.

### Including Images in Posts

You'll probably want to include images in your pages or posts eventually. There are different places where you can store these images.

The common option is to keep them in one folder under the `content` directory such as `assets` or `img`. Make sure to include the name of this folder in the `:resources` key in your config so the images get transfered to the `public` folder when your site compiles.

The other option is to keep them alongside your Markdown files. This means you would have to save your posts that contain images in a separate folder under your `post-root`. For example:

```
 md
 |---posts
     |---2014-07-13-spain.md
     |---diving
         |---2014-12-05-egypt.md
         |---turtle.jpg
         |---dolphin.jpg
```

If you'd like to organize your posts in this fashion, please keep in mind that the images under the specific post folder will be copied over to `public/img` when your site gets compiled so please link to these images in the same fashion described below.

### Images and Markdown

All images should be included in your Markdown content in the following format. (If `img` were a folder that you created under `content`.)

```
![Image 1](/img/img01.png)
```

If you have a prefix such as `/blog` specified in your `config.edn` Cryogen will prepend it to any local images that you include in your posts. So this

```
![Image 1](/img/img01.png)
```

will be compiled into this:

```
<img src="/blog/img/img01.png">
```

### Linking to other Posts or Pages

If you include local links to your other pages or posts, Cryogen will preprend your blog prefix the same way it does with images. So this

```
[Check out my bio](/pages/about-me)
```

will be compiled into this

```
<a href="/blog/pages/about-me">Check out my bio</a>
```

### Highlighting Code Snippets

Cryogen uses [highlight.js](https://highlightjs.org/) to support syntax highlighting for code snippets you wish to include in your posts or pages. Code blocks should be wrapped with triple backticks (```)  and highlight.js will automatically detect the language and handle the syntax colours. If you want to specify the language, simply do so after the first triple backtick.

### Disqus Integration

If you wish to enable comments on your posts, create a [disqus](https://disqus.com/) account and [register](https://disqus.com/admin/create/) your blog. `disqus?` should be set to `true` in the config and you must add your `disqus-shortname` as well.

## Post Archives

Cryogen will automatically generate and update a post archives page for you. If you'd like to change the layout of this page, you can do so by editing the HTML in `themes/{theme}/html/archives.html`.
