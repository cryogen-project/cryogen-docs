{:title "Konfiguration"
 :layout :post
 :page-index 3
 :section "Anfangen"}
 
Cryogen bietet Ihnen flexible Konfigurationsoptionen. Die Konfiguration Ihrer Seite ist unter `templates/config.edn` und enth&aumllt folgende Variablen als Standard:
 
```
{:site-title       "Mein Tolles Blog"
 :author           "Bob Bobbert"
 :description      "Mein Blog ist gro&szligartig"
 :site-url         "http://blog-toll.de/"
 :post-root        "posts"
 :tag-root         "tags"
 :page-root        "seiten"
 :blog-prefix      "/blog"
 :recent-posts     5
 :post-date-format "jjjj-MM-tt"
 :rss-name         "feed.xml"
 :rss-filters      ["cryogen"]
 :sass-src         nil
 :sass-dest        nil
 :resources        ["css" "js" "img"]
 :keep-files       [".git"] 
 :disqus?          false
 :disqus-shortname ""
 :ignored-files    [#"\.#.*" #".*\.swp$"]}
```

## Ihre Optionen

<table class="table table-bordered">
<thead>
<tr>
<th>Name</th>
<th>Beschreibung</th>
</tr>
</thead>
<tbody>
<tr>
<td>`site-title`</td>
<td>Der Titel Ihrer Seite</td>
</tr>
<tr>
<td>`author`</td>
<td>Das sind Sie!</td>
</tr>
<tr>
<td>`description`</td>
<td>Eine Kurzbeschreibung Ihrer Seite</td>
</tr>
<tr>
<td>`site-url`</td>
<td>Die root-URL Ihrer Seite. Alle Einstellungen bisher werden f&uumlr Ihre sitemap und den RSS-Feed benutzt.</td>
</tr>
<tr>
<td>`post-root`</td>
<td>Der Ordner, in dem der Kompilierer nach Blog-Posts sucht. Dieser String wird vor allen Post-URLs einef&uumlgt. Muss vorgegeben werden.
</td>
</tr>
<tr>
<td>`tag-root`</td>
<td>Dieser String wird vor allen Tag-Seiten eingef&uumlgt. Muss vorgegeben werden.</td>
</tr>
<tr>
<td>`page-root`</td>
<td>Der Ordner, in dem der Kompilierer nach Ihren Seiten sucht. Dieser Wert wird vor alle Seiten-URLs eingef&uumlgr. Muss vorgegeben werden.
</td>
</tr>
<tr>
<td>`blog-prefix`</td>
<td>Wird vor allen URLs eingef&uumlgt. Muss mit einem Slash (Schr&aumlgstrich) anfangen.</td>
</tr>
<tr>
<td>`recent-posts`</td>
<td>Das Maximum von neuen Posts, die in der Seitenleiste angezeigt werden.</td>
</tr>
<tr>
<td>`post-date-format`</td>
<td>Legen Sie das Datumsformat fest, das Sie f&uumlr die Namen Ihrer .md Dateien benutzen wollen, die Ihre Posts repr&aumlsentieren. nil setzt den Wert zu jjjj-MM-tt.</td>
</tr>
<tr>
<td>`rss-name`</td>
<td>Der Name der RSS-Datei, die generiert wird. nil setzt den Wert zu rss.xml.</td>
</tr>
<tr>
<td>`rss-filters`</td>
<td>Spezifische Tags, f&uumlr die Sie einen separaten RSS-Feed generieren wollen.</td>
</tr>
<tr>
<td>`sass-src`</td>
<td>Verzeichnis, das sass(scss)-Dateien enth&aumlt, die kompiliert werden sollen; nil setzt den Wert zu "css". Denken Sie daran, dieses Verzeichnis in den resources-Schl&uumlssel einzutragen.</td>
</tr>
<tr>
<td>`sass-dest`</td>
<td>Verzeichnis f&uumlr kompilierte sass-Dateien. nil setzt den Wert zu "css". Denken Sie daran, dieses Verzeichnis in den resources-Schl&uumlssel einzutragen.</td>
</tr>
<tr>
<td>`resources`</td>
<td>Ein Vektor mit Verzeichnissen/Dateien, die beim Kompilieren von `template` nach `public` kopiert werden sollen.</td>
</tr>
<tr>
<td>`keep-files`</td>
<td>Wenn der `public` gel&oumlscht wird, behalte die hier eingetragenen Verzeichnisse/Dateien. Zum Beispiel wollten Sie Ihren `.git` Ordner behalten, wenn Sie vorhaben, von Ihrem `public` Ordner auf GitHub-Seiten publizieren wollen.</td>
</tr>
<tr>
<td>`disqus?`</td>
<td>Setzen Sie dies auf `true` um Disqus auf Ihrer Seite zu aktivieren; nil setzt den Wert zu `false`.</td>
</tr>
<tr>
<td>`disqus-shortname`</td>
<td>Ihr Disqus Kurzname</td>
</tr>
<tr>
<td>`ignored-files`</td>
<td>Regul&aumlre Ausdr&uumlcke f&uumlr Dateien, die Sie w&aumlhrend des Kompilierens ignorieren wollen. Bsp: emacs interlock Dateien.</td>
</tr>
<tr>
</tr>
</tbody>
</table>
