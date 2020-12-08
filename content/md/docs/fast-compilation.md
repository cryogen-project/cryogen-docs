{:title "Fast Compilation"
 :layout :page
 :toc true
 :page-index 14
 :section "Additional Resources"}

As of Cryogen 0.4.0 [there is support for fast but partial compilation](https://github.com/cryogen-project/cryogen-core/pull/149). It is intended to be used when you work on a blog post or page and want to see it quickly, without re-compiling the whole site.

**BEWARE**: This feature is only intended for "development," make sure to make a full build (f.ex. via `lein run`) before publishing your site.

## Limitations

The difference from a full compilation is that the output directory is not wiped out and that only the changed markup file plus all non-page/post output files are compiled. If you change any other file, such as inside the template, a full compilation runs.

The downsides are that the previous and next links on neighboring posts will not be updated and that all derived pages such as the index, tag pages, archives, site map, and RSS will only know about this changed post/page. Thus the blog is in an inconsistent state, until a full compilation is performed.

_(NOTE: To support a consistent incremental compilation: instead of simply filtering out unchanged files, we would need "read in" all to have the metadata but skip markup processing and output for the unchanged ones + update the neighboring posts.)_

## How to enable

To enable the partial, fast compilation, use the `*-fast` variants of the serve commands:

```
lein serve-fast
clojure -X:serve-fast
```

or, in your blog's `src/cryogen/server.clj`, replace the calls to `(start-watcher! dir ignored-files compile-assets-timed)` with `(start-watcher-for-changes! dir ignored-files compile-assets-timed {})` (notice the different function and an extra argument).
