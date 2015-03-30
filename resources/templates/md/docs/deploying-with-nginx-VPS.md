{:title "Nginx auf einem VPS"
 :layout :page
 :page-index 7
 :section "Ins Netz stellen"}
 
Ein Virtueller Privater Server wie von [DigitalOcean](https://www.digitalocean.com/) ist ein exzellenter Weg, Ihre seite mit statischen Inhalt f&uumlr ca. $5 pro Monat zu hosten. Here ist ein schnelle &Uumlbersicht, wie Sie Ihre Seite mit [Nginx](http://wiki.nginx.org/) auf einem VPS mit Ubuntu serven.

## Nginx einrichten

Das erste, was Sie tun m&uumlssen, ist Nginx zu installieren, falls es nicht schon auf Ihrem Server ist.

```
$ sudo apt-get install nginx
```

Danach erstellen Sie ein Verzeichnis f&uumlr den Inhalt Ihrer Seite und stellen Sie es auf public. In diesem F&uumlhrer gehen wir davon aus, dass wir ein Nutzer namens `deploy` mit sudo-Privilegien nutzen. 

```
$ mkdir ~/site
$ chmod 755 ~/site
```
Danach machen Sie ein Backup der Standardeinstellung in /etc/nginx/sites-available/default und ersetzen Sie es mit Folgendem:

### Konfiguration f&uumlr Seiten ohne blog-prefix

```
server {
 listen 80;

 root /home/deploy/site;
 index index.html index.htm;

 server_name IHREDOMAINE.DE www.IHREDOMAINE.DE;

 access_log /var/log/nginx/access.log;
 error_log /var/log/nginx/error.log;

 location / {
   default_type "text/html";
   alias /home/deploy/site/;
   try_files $uri.html $uri $uri/ =404;
   error_page    404 = /404.html;
 }
}
```

Ersetzen Sie einfach `IHREDOMAINE.DE` mit der Seite in der Konfiguration und stellen Sie sicher, dass der statische Inhalt im Verzeichnis `/home/deploy/site/` erreichbar ist. Zu guter Letzt, kopieren Sie Ihre eigene error-Seite zu `/home/deploy/site/404.html`.

### Einstellungen f&uumlr Seiten mit blog-prefix

Wenn Sie ein `blog-prefix` in Ihrer Cryogen-Konfiguration eingetragen haben, m&uumlssen Sie dies in der nginx-Konfiguration auch tun.

```
server{
 listen 80;

 root /home/deploy/site;
 index index.html index.htm;
 error_page    404 = /404.html;

 server_name IHREDOMAIN.DE www.IHREDOMAIN.DE;

 access_log /var/log/nginx/access.log;
 error_log /var/log/nginx/error.log;

 location / {
   default_type "text/html";
   try_files $uri.html $uri $uri/ =404;
 }

 location /BLOG-PREFIX/ {
   alias /home/deploy/site/BLOG-PREFIX/;
 }
}
```

Ersetzen Sie einfach `IHREDOMAINE.DE` mit der Seite in der Konfiguration und stellen Sie sicher, dass der statische Inhalt im Verzeichnis `/home/deploy/site/BLOG-PREFIX` erreichbar ist. Zu guter Letzt, kopieren Sie Ihre eigene error-Seite zu `/home/deploy/site/404.html`.

Wenn Sie ihre nginx-Konfiguration ge&aumlndert haben, starten Sie nginx neu.

```
$ sudo service nginx restart
```

## Seite publizieren

Wenn Ihr Server bereit ist, Ihre Seite bereitzustellen, m&uumlssen Sie Ihre Seite auf Ihren Server laden, damit Sie erreichbar wird. Sie k&oumlnnen dies mit einem FTP-Programm wie [FileZilla](https://filezilla-project.org/) oder dem `scp`-Kommando aus dem Terminal tun.

Wenn Sie Ihre Seite &aumlndern wollen oder neue Seiten hinzuf&uumlgen wollen, nachdem alles l&aumluft, &uumlbertragen Sie einfach den Inhalt, den Cryogen generiert, noch einmal.