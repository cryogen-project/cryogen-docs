{:title "GitHub Pages"
 :layout :page
 :page-index 6
 :section "Deployment"}
 
[GitHub Pages](https://pages.GitHub.com/) are freely hosted web pages on GitHub's `GitHub.io` domain. Normally, they are powered by [Jekyll](http://jekyllrb.com) but because GitHub Pages supports HTML content, it is possible to host your Cryogen-powered sites as well.

GitHub provides two basic types of hosting: *user/organization pages* and *project pages*. Both of these work by looking at specific branches of your repositories on GitHub. The way to deploy these two types of sites are very similar and only differ in their initial setup.

## Setting up User and Organization Pages

User and organization pages must live in a GitHub repository dedicated to only your site's files. This repository must be named *username*.GitHub.io. Where *username* is your GitHub username or the name of the organization. For example, `lacarmen.github.io`.

Content from the `master` branch of your repository will be used to build and publish your site to your GitHub page.

If you'd like to create a user or organization page with Cryogen, please make sure the `blog-prefix` field in the configuration file is empty.

## Setting up Project Pages

Unlike user/organization pages, project pages are kept in the same repository as the project itself, except the site's content is stored in a specially named `gh-pages` branch. The output will become available under a subpath of your user page domain, such as `lacarmen.github.io/cryogen`.

If you'd like to use Cryogen to create a page for your project, please make sure the `blog-prefix` field in the configuration file matches the name of your project's repository.

### Creating the gh-pages branch

To create the branch for your project page, you must create a new "orphan" branch.

The safest way to do this is to create a fresh clone of your repository

```
$ git clone https://github.com/user/repository.git
# Clone your repository
```

Once you have a fresh repository, you'll need to create the `gh-pages` branch and rid it of all its content:

```
$ cd repository

$ git checkout --orphan gh-pages
# Creates a branch without any parents
# Switched to a new branch 'gh-pages'

$ git rm -rf .
# Remove all files from the old working tree
# rm .gitignore
```

  
## Deploying to GitHub Pages

Once you've set up your repository for the type of GitHub Page that you want, copy over all your files and folders under the root directory of your site - `public` if you're creating a user page; `public/YOUR-PROJECT-REPO-NAME` if you're creating a project page.
 
The last step is to push your content to GitHub. 

```
$ git add *
$ git commit -a -m "Initial page commit"
$ git push origin gh-pages
```

If you make any changes to your site, simply follow this deployment step to update your GitHub Page.