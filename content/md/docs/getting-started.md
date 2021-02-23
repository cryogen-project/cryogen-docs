{:title "Getting Started"
 :layout :page
 :page-index 1
 :section "Getting Started"}

Cryogen aims to be as simple as possible. There's no need to set up a database or jump through hoops just to get a boilerplate template going.

To get started, you'll need to have either [Leiningen](http://leiningen.org/) or [Clojure CLI](https://clojure.org/guides/deps_and_cli) with [clj-new](https://github.com/seancorfield/clj-new/). Once you have that ready, here's how to get the base template.

```
# Leiningen:
~ $ lein new cryogen my-blog
~ $ cd my-blog
~/my-blog $ lein serve

# Clojure CLI:
~ $ clojure -X:new :template cryogen :name me.my-blog
~ $ cd me.my-blog
~/my-blog $ clojure -X:serve
```

Once the server starts, you can visit your site at `localhost:3000`. The first thing you'll see is a helpful README on what to do next.
