{:title "Verzeichnisstruktur"
 :layout :page
 :page-index 2
 :section "Anfangen"}
 
Eine Cryogen-Seite hat normalerweise folgende Struktur:
(Neue Dateien k&oumlnnen in der Zukunft dazu kommen)

```
mein-blog
 |---resources
 |   |---public
 |   |---templates
 |   |   |---css
 |   |   |   |---screen.css
 |   |   |---html
 |   |   |   |---layouts
 |   |   |       |---archives.html
 |   |   |       |---base.html
 |   |   |       |---home.html
 |   |   |       |---page.html
 |   |   |       |---post.html
 |   |   |       |---tag.html
 |   |   |---js
 |   |   |   |---highlight.pack.js
 |   |   |---md
 |   |   |   |---pages
 |   |   |   |   |---about.md
 |   |   |   |   |---another-page.md
 |   |   |   |---posts
 |   |   |       |---10-03-2014-first-post.md
 |   |   |       |---11-04-2014-second-post.md
 |   |   |       |---13-11-2014-docs.md
 |   |   |---404.html
 |   |   |---config.edn
 |---src
 |   |---cryogen
 |   |   |---server.clj
 |---project.clj
```

<table class="table table-bordered">
<thead>
<tr>
<th>Name</th>
<th>Beschreibung</th>
</tr>
</thead>
<tbody>
<tr>
<td>`resources`</td>
<td>Hier speichern Sie den Inhalt Ihrer Seite und die Konfiguration. Es ist aufgeteilt in die Ordner `templates` und `public`.</td>
</tr>
<tr>
<td>`public`</td>
<td>Hier speichert Cryogen Ihre Seite, wenn diese fertig kompiliert ist.</td>
</tr>
<tr>
<td>`templates`</td>
<td>Der Ordner, in dem alle Ihre HTML-Vorlagen und Markdown-Dateien sind.</td>
</tr>
<tr>
<td>`css`</td>
<td>Erkl&aumlrt sich von selbst. Legen Sie hier Ihre CSS-Dateien an.</td>
</tr>
<tr>
<td>`html/layouts`</td>
<td>Dies sind die Vorlagen, in die Sie Ihre Posts und Seiten einf&uumlgen. Layouts werden per Post ausgew&aumlhlt und der Inhalt wird per [Selmer](https://github.com/yogthos/selmer) eingef&uumlgt.
</td>
</tr>
<tr>
<td>`js`</td>
<td>Erkl&aumlrt sich auch von selbst.</td>
</tr>
<tr>
<td>`md`</td>
<td>Speichern Sie Ihre Markdown-Dateien hier.
</td>
</tr>
<tr>
<td>`pages`</td>
<td>Der root-Ordner f&uumlr alle Ihre Mardown-Seiten. Der Name des Ordners kann in der Datei `config.edn` ge&aumlndert werden.</td>
</tr>
<tr>
<td>`posts`</td>
<td>Der root-Ordner f&uumlr Ihre Posts in Markdown. Der Name des Ordners kann in der Datei `config.edn` ge&aumlndert werden.</td>
</tr>
<tr>
<td>`404.html`</td>
<td>Die Standard 404-Error-Seite.</td>
</tr>
<tr>
<td>`config.edn`</td>
<td>Konfigurationsdatei f&uumlr Ihre Seite.</td>
</tr>
<tr>
<td>`src/cryogen`</td>
<td>Enth&aumllt den Server.</td>
</tr>
<tr>
<td>`project.clj`</td>
<td>Eine typische Projekt-Datei f&uumlr ein Clojure-Projekt.</td>
</tr>
</tbody>
</table>