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

If your title is more than one word long, it must be separated by dashes.

### Post Contents

Every Markdown file representing a post must contain metadata about the title and layout of the post. This is provided as a Clojure map at the beginning of the Markdown file. The following data is required:

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
<td style="width:100px">`date`</td>
<td>The date that your post was written. Must follow the date format specified in `config.edn`. <u>Not</u> optional if you did not include the post date in the file name.</td>
</tr>
<tr>
<td>`author`</td>
<td>The name of the author of the post.</td>
</tr>
<tr>
<td>`tags`</td>
<td>A vector of strings representing any tags associated with the post.</td>
</tr>
<tr>
<td>`toc`</td>
<td>
Set this to true if you want a table of contents to be generated from the headers/headings in your post.
(The default table of contents format is an ordered list. Set this to `:ul` if you want a bulleted list.)
</td>
</tr>
<tr>
<td>`draft?`</td>
<td>
Files that have this key set to `true` will not be included in the compilation process.
</td>
</tr>
<tr>
<td>`klipse`</td>
<td>Set [Klipse](https://github.com/viebel/klipse) configuration for the post.
See [Klipse Integration](klipse.html) for details.</td>
</tr>
<tr>
<td>`layout`</td>
<td>A keyword corresponding to an HTML file under `themes/{theme}/html`.
Defaults to `:post` for posts.</td>
</tr>
</tbody>
</table>

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

### Highlighting Code Snippets

Cryogen uses [highlight.js](https://highlightjs.org/) to support syntax highlighting for code snippets you wish to include in your posts or pages. Code blocks should be wrapped with triple backticks (```)  and highlight.js will automatically detect the language and handle the syntax colours. If you want to specify the language, simply do so after the first triple backtick.

### Disqus Integration

If you wish to enable comments on your posts, create a [disqus](https://disqus.com/) account and [register](https://disqus.com/admin/create/) your blog. `disqus?` should be set to `true` in the config and you must add your `disqus-shortname` as well.

## Post Archives

Cryogen will automatically generate and update a post archives page for you. If you'd like to change the layout of this page, you can do so by editing the HTML in `themes/{theme}/html/archives.html`.
