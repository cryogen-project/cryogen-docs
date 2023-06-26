{:title "Getting Started"
 :layout :page
 :page-index 1
 :section "Getting Started"}

Cryogen aims to be as simple as possible. There's no need to set up a database or jump through hoops just to get a boilerplate template going.

To get started, you'll need to have either
[Leiningen](http://leiningen.org/) or [Clojure
CLI](https://clojure.org/guides/deps_and_cli)
with [clj-new as a
tool](https://github.com/seancorfield/clj-new#installation-as-a-tool).
Once you have that ready, here's how to get the base template.

```
# Clj-new
~ $ clojure -Ttools install com.github.seancorfield/clj-new '{:git/tag "v1.2.362"}' :as clj-new
```

```
# Leiningen:
~ $ lein new cryogen my-blog
~ $ cd my-blog

# start continuous build that watches for changes
~/my-blog $ lein serve # or lein serve:fast 

# build for deployment
~ $ lein run

# Clojure CLI (after installing clj-new as a tool - see link above)):
~ $ clojure -Tclj-new create :template cryogen :name me.my-blog
~ $ cd me.my-blog

# start continuous build that watches for changes
~/my-blog $ clojure -X:serve # or clojure -X:serve:fast

# build for deployment
~ $ clojure -M:build
```

Once the server starts, you can visit your site at `localhost:3000`<sup>*</sup>. The first thing you'll see is a helpful README on what to do next.

<sup>*</sup>) You can override the default port by setting the env variable PORT: `env PORT=8080 lein serve`
