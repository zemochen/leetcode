#create a new repository on the command line
touch README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/zemochen/leetcode.git
git push -u origin master

#push an existing repository from the command line
git remote add origin https://github.com/zemochen/leetcode.git
git push -u origin master