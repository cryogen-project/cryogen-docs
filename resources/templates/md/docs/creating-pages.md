{:title "Seiten erstellen"
 :layout :page
 :page-index 5
 :section "Ihr Inhalt"}
 
Sie erstellen Seiten auf einem &aumlhnlichen Weg, wie Sie Posts erzeugen. Sie m&uumlssen immer noch eine map einf&uumlgen, die die Metadaten enth&aumlt, und die Seite muss in g&uumltigem Markdown geschrieben sein.

## Der Seiten-Ordner

&Aumlnhlich wie f&uumlr Posts werden alle Ihre Seiten in dem `page-root`-Ordner angelegt, den Sie in Ihrer Konfiguration festgelegt haben. So lange die Datei g&uumltiges Markdown enth&aumlt, wird sie in eine HTML-Seite umgewandelt.

## Seiten erstellen

Um eine neue Seite zu erstellen, kreieren Sie einfach eine neue Markdown-Datei unter dem Verzeichnis `page-root`. Anders als bei Posts m&uumlssen Sie diesmal kein Datum in den Dateinamen einf&uumlgen. Worte sollten immer noch mit Bindestrichen getrennt werden und m&uumlssen auf `.md` enden. Beispiel:

```
hallo.md
meine-projekte.md
```

### Seiteninhalt

Die folgenden Informationen m&uumlssen in Ihren Seiten-Metadaten enthalten sein:

  * `:title` - Ein String mit dem Seitennamen.
  * `:layout` - Ein Schl&uumlsselwort, das den Namen der HTML-Datei darstellt, die Sie f&uumlr Ihr Layout nutzen wollen.
  * `:page-index` - Seiten k&oumlnnen mit vor/zur&uumlck-Links vernetzt werden, und so werden sie sortiert.
  * `:navbar?` - Setzen Sie dies auf true wenn Sie einen Link zu dieser Seite im Men&uuml wollen. Setzen Sie es auf false wenn Sie den Link in der Seitenleiste wollen.

Zum Beispiel:

```
{:title "Was f&uumlr eine Seite!"
 :layout :post
 :page-index 0
 :navbar? false}
```

### Bilder auf Ihren Seiten

Sie k&oumlnnen Bilder in Ihren Seiten auf dem gleichen Weg einf&uumlgen, auf dem Sie Bilder in Ihren Blog-Posts eingef&uumlgt haben. Btte lesen Sie dazu die Sektionen "Bilder in Ihren Blog-Posts" und "Bilder in Markdown" auf der Seite [Posts erstellen](/docs/writing-posts.html).

### Code hervorheben

Wollen Sie Ihren Code hervorheben? Es funktioniert genauso wie bei Posts. Einfach den Code mit dreifachen Backticks umschlie&szligen und highlight.js erledigt den Rest.zligen und highlight.js erledigt den Rest.