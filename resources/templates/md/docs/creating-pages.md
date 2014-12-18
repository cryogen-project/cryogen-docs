{:title "Creating Pages"
 :layout :page
 :page-index 5
 :section "Your Content"}
 
Creating pages is not much different from writing posts. You're still required to include the map representing the metadata and the page must be written in valid Markdown. Like blog post, the `title` and `layout` keys are required.

## Metadata

The following information is mandatory in your pages

  * `title` - A string representation of your page title.
  * `layout` - A keyword representing the name of the HTML file that you want to use as your page layout.
  * `page-index` - Because pages can be linked up with previous/next links, this is how they get sorted.