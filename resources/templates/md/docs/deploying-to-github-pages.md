{:title "GitHub-Seiten"
 :layout :page
 :page-index 6
 :section "Ins Netz stellen"}
 
[GitHub-Seiten (Englisch)](https://pages.GitHub.com/) sind kostenlose Webseiten, die auf GitHubs `GitHub.io` Domain gehostet werden. Normalerweise werden sie mit [Jekyll (Englisch)](http://jekyllrb.com) betrieben, aber weil GitHub-Seiten HTML unterst&uumltzt, ist es m&oumlglich, auch Cryogen-generierte Seiten zu hosten.

GitHub bietet zwei unterschiedliche Arten von Hosting:
*Nutzer/Organisation-Seiten* und *Projektseiten*. Beide schauen an bestimmten Zweigen Ihres Projektarchivs (repository). Die Einrichtung unterscheidet sich nur in der Anfangseinstellung.

## Nutzer- und Organisationsseiten einrichten

Nutzer- und Organisationsseiten m&uumlssen in einem dedizierten GitHub-Archiv liegen, in dem nur die Dateien Ihrer Seite sind. Dieses Archiv muss den Namen *Benutzername*.GitHub.io. haben. *Benutzername* ist Ihr GitHub Benutzername oder der Name der Organisation. Als Beispiel: `lacarmen.GitHub.io`.

Die Dateien aus dem `master`-Zweig Ihres Archivs wird genutzt, um Ihre Seite zu generieren und auf GitHub zu publizieren.

Wenn Sie eine Nutzer- oder Organisationsseite mit Cryogen generieren wollen, stellen Sie bitte sicher, dass die das Feld `blog-prefix` in der Konfigurationsdatei leer ist.

## Projektseiten einrichten

Anders als Nutzer- und Organisationsseiten liegen Projektseiten im gleichen Archiv wie das Projekt selbst, nur der Inhalt der Seite ist in einem speziell benannten `gh-pages`-Zweig. Der Output wird unter einem Teilpfad Ihrer Nutzerseite erreichbar sein. Zum Beispiel: `lacarmen.GitHub.io/cryogen`.

Das Cryogen-Archiv ist ein gutes Beispiel f&uumlr eine solche Struktur. Der [Hauptzweig](https://GitHub.com/lacarmen/cryogen/tree/master) enth&aumllt die Vorlage lein-template f&uumlr Cryogen und die Webseite, die Sie im Moment sehen, ist im [gh-pages Zweig](https://GitHub.com/lacarmen/cryogen/tree/gh-pages) im gleichen Archiv.

Wenn Sie Cryogen benutzen m&oumlchten, um eine Seite f&uumlr Ihr Projekt zu gestalten, stellen Sie bitte sicher, dass das Feld `blog-prefix`in der Konfigurationsdatei mit dem Namen Ihres Projektarchivs &uumlbereinstimmt.

### Den Zweig gh-pages erstellen

Um den Zweig f&uumlr Ihre erste Projektseite zu erstellen, m&uumlssen Sie einen neuen "orphan" Zweig erstellen.

Der sicherste Weg, dies zu tun, ist es, einen neuen Klon Ihres Archivs zu kreieren

```
$ git clone https://GitHub.com/user/repository.git
# Clone your repository
```

Wenn Sie ein neues Archiv haben, m&uumlssen Sie den Zweig `gh-pages` erstellen und alle Inhalte l&oumlschen:

```
$ cd repository

$ git checkout --orphan gh-pages
# Creates a branch without any parents
# Switched to a new branch 'gh-pages'

$ git rm -rf .
# Remove all files from the old working tree
# rm .gitignore
```

  
## Auf GitHub-Seiten publizieren

Wenn Sie Ihr GitHub-Archiv f&uumlr die Art von Seite vorbereitet haben, die Sie erstellen m&oumlchten, &uumlbertragen Sie alle Ihre Dateien und Ordner unter dem root-Verzeichnis Ihrer seite - `public` f&uumlr eine Nutzerseite; `public/IHR-PROJEKT-REPO-NAME` f&uumlr eine Projektseite.
 
Der letzte Schritt ist es, den Inhalt auf GitHub zu pushen.

```
$ git add *
$ git commit -a -m "Initial page commit"
$ git push origin gh-pages
```

Wenn Sie &Aumlnderungen an Ihrer Seite vornehmen, folgen Sie einfach diesen Schritten, um Ihre GitHub-Seite zu aktualisieren.