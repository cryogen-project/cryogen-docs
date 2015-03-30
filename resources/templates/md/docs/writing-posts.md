{:title "Posts schreiben"
 :layout :page
 :page-index 4
 :section "Ihr Inhalt"}
 
Bloggen ist eine zentrale Funktion von Cryogen. Sie k&oumlnnen einfach einen Ordner mit Textdateien in Markdown erstellen und Cryogen erstellt daraus automatisch Ihr Blog.

## Der Post-Ordner

Alle Blog-Posts sollten unter dem `post-root`-Ordner gespeichert werden, das Sie in der Konfigurationsdatei angegeben haben. Solange die Datei valide Metadaten (siehe unten) &uumlber das Layout des Posts und danach g&uumlltiges Markdown enth&aumllt, wird sie in eine HTML-Datei konvertiert.

## Posts erstellen

Um einen neuen Post zu erstellen, m&uumlssen Sie nur eine neue Markdown-Datei unter Ihrem `post-root`-Verzeichnis erstellen. Der Name dieser Dateien ist wichtig. Wenn Ihr spezifiertes Datumsformat in der Konfiguration `tt-MM-jjjj` ist, erfordert Cryogen, dass Ihre Datein in diesem Format benannt werden:

```
tt-MM-jjjj-Titel.md
```

Wenn in der Konfigurationsdatei kein Datumsformat spezifiziert wurde, ist der Standard das ISO 8601 Format.

```
jjjj-MM-tt-Titel.md
```

Wenn Ihr Titel l&aumlnger als ein Wort ist, muss er mit Trennstrichen separiert werden. Die folgenden Namen sind beispielsweise valide Postnamen:
 
```
11-04-2014-willkommen-zu-meinem-Blog.md
2014-12-01-Cryogen-ist-toll.md
```

Das erste Beispiel nutzt ein `tt-MM-jjjj`-Format, w&aumlhrend das zweite Beispiel das Standardformat benutzt. Bitte beachten Sie jedoch, dass Sie in Ihren Dateien Datumsformate nicht mischen k&oumlnnen.

### Post-Inhalt

Jede Markdown-Datei muss Metadaten &uumlber den Titel und das Layout des Posts enthalten. Dies wird durch eine Clojure-map am Anfang der Datei repr&aumlsentiert. Die folgenden Daten sind n&oumltig:

  * `:title` - Ihr Post-Titel als String.
  * `:layout` - Ein Schl&uumlsselwort, das mit einer HTML-Datei im Ordner `html/layouts` &uumlbereinstimmt.
   
Es gibt einige optionale Schl&uumlsselworte, die Sie nutzen k&oumlnnen:

  * `:tags` - Ein Vektor mit Strings, die alle Tags repr&aumlsentieren, die Sie mit dem Post verbinden wollen.
  * `:toc` - Setzen Sie dies auf true, wenn Sie wollen, dass ein Inhaltsverzeichnis aus den &Uumlberschriften des Posts erzeugt wird.

Der Rest der Datei sollte valides Markdown enthalten.

Zum Beipiel:

```
{:title "Erster Post!"
 :layout :post
 :tags  ["tag1" "tag3"]}

 ## Hallo Welt

Die ist mein erster Post!

 Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 Nunc sodales pharetra massa, eget fringilla ex ornare et.
 Nunc mattis diam ac urna finibus sodales. Etiam sed ipsum
 et purus commodo bibendum. Cras libero magna, fringilla
 tristique quam sagittis, volutpat auctor mi. Aliquam luctus,
 nulla et vestibulum finibus, nibh justo semper tortor, nec
 vestibulum tortor est nec nisi.
```

### Tags

Cryogen wird automatisch eine Seite f&uumlr jedes spezifische Tag erstellen, das Sie in Ihren Posts benutzt haben.
  
### Bilder in Posts

Sie wollen wahrscheinlich irgendwann Bilder in Ihren Seiten oder Posts einf&uumlgen. Es gibt verschiedene Orte, wo Sie diese speichern k&oumlnnen.

Die gebr&aumluchliche Option ist ein Ordner im `templates`-Verzeichnis, zum Beispiel `assets` or `bilder`. Stellen Sie sicher, dass dieser Ordner im `resources`-Schl&uumlssel in Ihrer Konfigurationsdatei eingetragen ist, so dass die Bilder in den `public`-Ordner kopiert werden, wenn Ihre Seite kompiliert.

Die andere Option ist es, die Bilder mit den Markdown-Datein zu speichern. Die bedeutet, dass Sie alle Posts, die Bilder beinhalten, in einem separaten Ordner unter Ihrem `post-root`-Verzeichnis speichern. Zum Beispiel:

```
 md
 |---posts
     |---2014-07-13-Spanien.md
     |---tauchen
         |---2014-12-05-Tunesien.md
         |---Koralle.jpg
         |---Delphin.jpg
```

Wenn Sie Ihre Posts auf diese Weise organisieren wollen, bedenken Sie bitte, dass die Bilder unter dem spezifischen Posts-Ordner in das `public/img` kopiert werden, wenn Ihre Seite kompiliert wird. Daher linken Sie bitte auf Ihre Bilder, wie es unten beschrieben ist.

### Bilder und Markdown

Im Normalfall w&uumlrden Sie Ihre Bilder in Ihren Blogposts mit einem absoluten Pfad einschlie&szligen. Wenn Sie Ihre Bilder in einem Ordner `img` haben, w&uumlrden Sie so darauf verlinken:

```
![Bild 1](/img/img01.png)
```

Wenn Sie allerdings ein Blog-Prefix benutzen wollen, beispielsweise `/blog`, dann sieht Ihr Pfad so aus:

```
![Bild 1](/blog/img/img01.png)
```

Sie sehen, wie dies problematisch werden kann, wenn Sie das Prefix &aumlndern oder komplett entfernen. Auf einmal fehlen alle Bilder in Ihren Posts.

Wie schlie&szligen Sie also Bilder in Ihren Posts ein? Nehmen Sie einfach das erste Beispiel. Cryogen ist intelligent genug, das `blog-prefix` automatisch einzuf&uumlgen. Wenn Ihr Prefix `/blog` ist, wird dieser Link:
 
```
![Bild 1](/img/img01.png)
```

in diesen kompiliert:

```
<img src="/blog/img/img01.png">
```

### Code-Snippets hervorheben

Cryogen benutzt [highlight.js](https://highlightjs.org/), um Syntax-Hervorhebung f&uumlr Code-Snippets in Ihren Seiten und Posts zu unterst&uumltzen. Code-Blocks sollten in dreifachen Backticks eingeschlossen werden (```) und highlight.js bestimmt automatisch die Sprache und setzt die Syntax-Farben. Wenn Sie die Sprache spezifizieren m&oumlchten, tun Sie das einfach direkt hinter dem ersten dreifachen Backtick.

## Post-Archiv

Cryogen generiert automatisch eine aktuelle Archiv-Seite f&uumlr Sie. Wenn Sie das Layout der Seite &aumlndern wollen, k&oumlnnen Sie dies tun, indem Sie das HTML in `templates/html/layouts/archives.html` &aumlndern.
 
