{:title "Switching between Markdown and AsciiDoc"
 :layout :page
 :page-index 6
 :section "Your Content"}

 Cryogen comes with [Markdown](https://daringfireball.net/projects/markdown/) support by default and you can only use one or the other.

 If you want to use [AsciiDoc](http://asciidoctor.org/docs/what-is-asciidoc/) instead of Markdown, open the `project.clj` in your created blog and change the line in `:dependencies` that says `cryogen-flexmark` to `cryogen-asciidoc`.
 Instead of looking for files ending in `.md` in the `content/md` directory, the compiler will now look in the `content/asc` directory for files ending in `.adoc`. (For backwards compatibility, it actually also looks for `.ad`, `.asciidoc`, and `.asc`. But only `.adoc` is the official file extension, and newer features such as xref only work with that.)

If you want to configure Cryogen's use of AsciiDoc or create AsciiDoc
extensions, see the repository for [cryogen-asciidoc](https://github.com/cryogen-project/cryogen-asciidoc).
