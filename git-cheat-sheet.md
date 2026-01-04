git untrack previously tracked files:
    echo filename.ext >> .gitignore
    git rm --cached filename.ext   ### Remove the file(s) from Git's index (staging area) but keep the local copy
    git rm -r --cached directory_name
    git commit  & git push

common git tasks:
    git creating a new repo
    
