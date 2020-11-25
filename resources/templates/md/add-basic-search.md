{:title "Basic Search with Lunr"
 :layout :page
 :toc true
 :page-index 13
 :section "Additional Resources"}

To enable a search option for your site, you can use [`Lunr`](https://lunrjs.com/), which will create a searchable index without the need of any server-side or external search service. The inspiration to integrate Lunr with Cryogen was the following site [`Lunr-Index-and-Search-for-Static-Sites`](https://github.com/BLE-LTER/Lunr-Index-and-Search-for-Static-Sites), where the source JavaScript files can be found, which are used with slightly modifications here.

A live demo of the result can be found at: [https://blog.stderr.at/](https://blog.stderr.at/)

## Prerequisites
Before we start, Node.js and some modules must be installed on your system:

1. Install [`Node.js`](https://nodejs.org/en/download/)
2. Install lunr: `npm install lunr`
3. Install cheerio: `npm install cheerio`

## Copy build-index.js
As the filename says, this script will create the index file, which will be used to search your page.

> *NOTE*: Everytime when a new post/page is published, the index should be recreated. Therefore, the best option would be to add this to your deployment routine.

Download: [build-index.js](/lunr/build-index.js)

### Most notable lines

The following lines might require attention:

Line 8: The output folder of the html files. In this example only **posts-output** will be indexed (no tags, no pages).
```js
const HTML_FOLDER = "public/posts-output";
```

Line 11: Files to exclude from the index
```js
const EXCLUDE_FILES = ["search.html"];
```

Line 13: The output path and filename for the index. This depends on your actual theme.
```js
const OUTPUT_INDEX = "themes/nucleus/js/index/lunr_index.js";
```

Line 64: This adds "posts-output" to the link, which might be removed depending on you page
```js
        "link": "posts-output/"+file,
```

## Create index file
The index file should be created with any new post or page which is published using the following command:
```bash
node ./build-index.js
```
## Download lunrclient.js
Download and place the file lunrclient.js into the js folder of your theme: [lunrclient.js](/lunr/lunrclient.js)

This script will create the search result page.

## Changes to HTML and CSS
Changes to the actual html/css highly depend on your theme. Therefor only a basic snippets of a possible change of the **base.html** are shown here.

In the `head` tag the JavaScript files must be loaded. First lunr itself, then the indexfile and then the client file:
```html
    <script src="https://unpkg.com/lunr/lunr.js"></script>
    <script src="/js/index/lunr_index.js"></script>
    <script src="/js/lunrclient.js"></script>
```

The search form can look like this:
```html
    <!--- Search from -->
    <form id="lunrSearchForm" name="lunrSearchForm" action="/">
        <input class="search-input" name="q" placeholder="Enter search term" type="text"> 
        <input class="button nopadding" type="submit" value="Search">
    </form>
    <div class="loading" id="loading-div">
        <i class="fa fa-spinner fa-pulse fa-3x fa-fw"></i>
        <span class="sr-only">Loading...</span>
    </div>
```

Last but not least the search result is rendered in the main page (right side, nucleus example theme was used here.)
The script lunrclient.js will replace the elements "resultCount" and "searchResults"
```html
<div id="right" class="clearfix">
  <div class="resultCount" id="resultCount"></div>
  <hr />
  <div id="searchResults">
    {% block content %}
    {% endblock %}
  </div>
```

Tip: If you use the nucleus example template, or any javascript which does a **window.onload** you may want to do the following changes too:

`themes/nucleus/js/scripts.js`
add
```js
/* window.onload function */
function start()
{
  externalLinks();
  startlunr();
}
```

Remove `window.onload = externalLinks`from the line
```js
 function externalLinks() { if (!document.getElementsByTagName) return; var anchors = document.getElementsByTagName("a"); for (var i=0; i<anchors.length; i++) { var anchor = anchors[i]; if (anchor.getAttribute("href") && anchor.getAttribute("rel") == "external") anchor.target = "_blank"; } } window.onload = externalLinks;
```

`themes/nucleus/html/base.html`

Below the line `{% script "js/scripts.js" %}` add:

```html
<script>window.onload = start;</script>
```
