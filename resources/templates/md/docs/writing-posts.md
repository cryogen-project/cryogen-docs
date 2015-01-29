{:title "Writing Posts"
 :layout :page
 :page-index 4
 :section "Your Content"}
 
Blogging with Cryogen is part of its core functionality. You can simply maintain a folder of text files containing Markdown content and Cryogen will take care of compiling them into a blog.

## The Posts Folder

All of your blog posts should reside under the `post-root` folder specified in your configuration file. As long as the file contains the proper metadata (discussed later) about the layout of the post followed by valid Markdown content, they will be converted into an HTML page.

## Creating Posts

To create a new blog post, all you need to do is create a new Markdown file under your `post-root` directory. The way you name these files is important. If your specified date format in your configuration file was `dd-MM-yyyy`, Cryogen would require your posts to be named in this format:

```
dd-MM-yyyy-title.md
```

If no date format was specified in the configuration file, it will default to the ISO 8601 format.

```
yyyy-MM-dd-title.md
```

If your title is more than one word long, it must be separated by dashes. For example, the following are valid post file names:
 
```
11-04-2014-welcome-to-my-blog.md
2014-12-01-cryogen-is-greatdocs.md
```

The first example uses a specified `dd-MM-yyyy` date format while the second uses the default format. Do note that you cannot mix date formats in post file names though.

### Post Contents

Every Markdown file representing a post must contain metadata about the title and layout of the post. This is provided as a Clojure map at the beginning of the Markdown file. The following data is required:

  * `:title` - Your post title provided as a string.
  * `:layout` - A keyword corresponding to an HTML file under `html/layouts`.
   
These are some optional keys that you may provide:

  * `:tags` - A vector of strings representing any tags associated with the post.
  * `:toc` - Set this to true if you want a table of contents to be generated from the headers/headings in your post.

The rest of your file should contain valid Markdown content.

eg.

```
{:title "First Post!"
 :layout :post
 :tags  ["tag1" "tag3"]}

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

### Tags

Cryogen will automatically create a page for each unique tag that you've used in your posts.  
  
### Including Images in Posts

You'll probably want to include images in your pages or posts eventually. There are different places where you can store these images.

The common option is to keep them in one folder under the `templates` directory such as `assets` or `img`. Make sure to include the name of this folder in the `resources` key in your config so the images get transfered to the `public` folder whne your site compiles.

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

Normally, you'd want to include images in your posts by referring to the absolute path of the image in your Markdown content. If you were keeping your images under a folder called `img`, you would link to it like so:

```
![Image 1](/img/img01.png)
```

However, if you'd like you add a prefix to your blog such as `/blog`, your path will be like this:

```
![Image 1](/blog/img/img01.png)
```

You can probably see how this would be tedious to maintain if you decided to change your prefix or remove it completely though. Suddenly all your images would be missing from your posts.

So how do you include images in your posts? Just go with the first example provided. Cryogen is smart enough to inject your `blog-prefix` in front of any local images that you include in your posts. Now if your blog prefix was `/blog`, this:
 
```
![Image 1](/img/img01.png)
```

will be compiled into this:

```
<img src="/blog/img/img01.png">
```

### Highlighting Code Snippets

Cryogen uses [highlight.js](https://highlightjs.org/) to support syntax highlighting for code snippets you wish to include in your posts or pages. Code blocks should be wrapped with triple backticks (```)  and highlight.js will automatically detect the language and handle the syntax colours. If you want to specify the language, simply do so after the first triple backtick. 

## Post Archives

Cryogen will automatically generate and update a post archives page for you. If you'd like to change the layout of this page, you can do so by editing the HTML in `templates/html/layouts/archives.html`.
 
