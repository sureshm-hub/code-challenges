# git untrack previously tracked files:
    echo filename.ext >> .gitignore
    git rm --cached filename.ext   ### Remove the file(s) from Git's index (staging area) but keep the local copy
    git rm -r --cached directory_name
    git commit  & git push

# git creating a new repo:
    git init
    git branch -M main
    git commit -m "initial commit"
    git remote add origin https://github.com/<account>/<url>.git
    git push -u origin main

# git clean up unwanted files in repo:

    A) Add them to .gitignore
        Edit/create .gitignore and add patterns (examples):
        # Java
        target/
        *.class
        
        # Node
        node_modules/
        dist/
        
        # IDE
        .idea/
        *.iml
        
        # OS
        .DS_Store

    B) Remove them from git tracking (does not delete locally)
        git rm -r --cached .
        git add .
        git commit -m "Remove unwanted files and apply .gitignore"
        git push