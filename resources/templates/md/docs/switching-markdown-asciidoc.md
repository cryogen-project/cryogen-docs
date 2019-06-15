{:title "Switching between Markdown and AsciiDoc"
 :layout :page
 :page-index 6
 :section "Your Content"}

 Cryogen comes with [Markdown](https://daringfireball.net/projects/markdown/) support by default and you can only use one or the other.

 If you want to use [AsciiDoc](http://asciidoctor.org/docs/what-is-asciidoc/) instead of Markdown, open the `project.clj` in your created blog and change the line in `:dependencies` that says `cryogen-markdown` to `cryogen-asciidoc`.
 Instead of looking for files ending in `.md` in the `content/md` directory, the compiler will now look for files ending in `.asc` in the `content/asc` directory.
