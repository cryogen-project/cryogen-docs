{:title "Deploying on Netlify"
 :layout :page
 :page-index 11
 :section "Deployment"}

[Netlify](https://www.netlify.com) provides free hosting of non-commericial static sites and builds automatically from a repository. 

Once Netlify is configured, everytime you push to github your site will be updated. 

## Short instructions

1. In content/config.edn set `:blog-prefix` to `""`.
1. Make sure git is tracking public/.
1. Leave the Netlify build instructions blank.
1. Set Netlify's "Publish directory" to "public".
1. Do "lein run" to generate public/.
1. Push at least the public/ folder, but you can push everything to github and Netlify will only show what's in public/.

## Long instructions

1. Make a Netlify account.
2. Make a github, bitbucket, or gitlab repo.
3. Connect Netlify to your blog repo.
1. In content/config.edn set `:blog-prefix` to `""`
5. Have git track public/ . It may be helpful to edit your .gitignore.
6. set Netlify's "Publish directory" to "public".
7. Leave Netlify's build instructions blank. 
8. Do "lein run" to generate public/.
9. Push at least the public/ folder, but you can push everything to the repo and Netlify will only show what's in public/.

## Troubleshooting

### Home page shows but the links are broken and CSS/Theme doesn't load

You probably did not set `:blog-prefix` to `""`.

If :blog-prefix has been set correctly and you have updated the site using "lein run" then [download Netlify's version of your site.](https://answers.netlify.com/t/can-i-download-my-website/3622) You'll have to figure it out for yourself what isn't working.

### 404 when viewing the homepage

This means Netlify can't find your content. This is probably caused by not setting the "Publish directory" to "public". 

Alternatively, public/ is in your gitignore and you forgot to push public/.
