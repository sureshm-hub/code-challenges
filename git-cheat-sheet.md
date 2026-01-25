git untrack previously tracked files:
    echo filename.ext >> .gitignore
    git rm --cached filename.ext   ### Remove the file(s) from Git's index (staging area) but keep the local copy
    git rm -r --cached directory_name
    git commit  & git push

git creating a new repo:
    git init
    git branch -M main
    git commit -m "initial commit"
    git remote add origin https://github.com/<account>/<url>.git
    git push -u origin main