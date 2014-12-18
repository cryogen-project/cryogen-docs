{:title "Getting Started"
 :layout :page
 :page-index 1
 :section "Getting Started"}

Cryogen aims to be as simple as possible. There's no need to set up a database or jump through hoops just to get a boilerplate template going.

To get started, you'll need to have [Leiningen](http://leiningen.org/) installed. Once you have that ready, here's how to get the base template.

```
~ $ lein new cryogen my-blog
~ $ cd my-blog
~/my-blog $ lein ring server
```

Once the server starts, you can visit your site at `localhost:3000`. The first thing you'll see is a helpful README on what to do next.