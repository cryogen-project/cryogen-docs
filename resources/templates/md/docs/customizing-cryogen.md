{:title "Customizing/Extending Cryogen"
 :layout :page
 :toc true
 :page-index 12
 :section "Additional Resources"}

If the malleability provided by the [configuration](configuration.html) and templates isn't enough for your needs, here are your options.

### Extra parameters for your Selmer templates

You can invoke [`cryogen-core.compiler/compile-assets-timed`](https://github.com/cryogen-project/cryogen-core/blob/master/src/cryogen_core/compiler.clj) with a custom `config` that:

1. Can override any settings from `config.edn`
2. Add any additional parameters that will be made available to your pages (ex.: `{{my-custom-key}}`)
3. Provide under `:extend-params-fn` a function of the signature `(fn [params site-data] params)`
   that can leverage all the available `params` (the data eventually passed to Selmer) and the
   provided `site-data` to derive modified `params`. See the code for the available data.

### Extra pages / posts

You can leverage the functions in `cryogen-core.compiler` and write your own, invoking them from your `cryogen.core/-main` and `cryogen.server/init`, to generate additional pages and posts in the same way as `compile-assets-timed` does.

### Customizing the code

You can copy the `cryogen-core.compiler` namespace directly into your project (where it will override the one from the cryogen-core.jar) and modify it to your liking. It is not very long or complicated and is quite easy to modify. That is [what we did for this site](https://github.com/cryogen-project/cryogen-docs/blob/fd601c857cc88f7cb633a41c47b4c692e1522ed8/src/cryogen/compiler.clj) (although it uses a much older version of cryogen-core, you may still use the same strategy today).
