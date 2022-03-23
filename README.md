# Inflearn coding test
프로그래머스 방식이 좋아서 그냥 `main`함수에다가 테스트 케이스 작성하면서 솔루션 작성중.   
시작일 : 2022.03.23

#### 로컬에서 만든 깃 프로젝트 github에 올리기
GitHub CLI 를 설치하여 인증은 끝난 상태이다.   
https://docs.github.com/en/get-started/using-git/about-git#example-start-a-new-repository-and-publish-it-to-github   


아래 명령어를 정리하면 다음과 같다.   
1. GitHub.com 에서 empty Repository를 미리 만든다. (initialize 하지 않음)
2. 로컬에서 git init 을 하고 첫 번째 커밋을 한다.
3. 로컬 git repo를 remote에 push한다.
4. upstream 으로 설정한다.

```
# create a new directory, and initialize it with git-specific functions
git init my-repo

# change into the `my-repo` directory
cd my-repo

# create the first file in the project
touch README.md

# git isn't aware of the file, stage it
git add README.md

# take a snapshot of the staging area
git commit -m "add README to initial commit"

# provide the path for the repository you created on github
git remote add origin https://github.com/YOUR-USERNAME/YOUR-REPOSITORY-NAME.git

# push changes to github
git push --set-upstream origin main
```

GitHub CLI 를 활용하면 다음으로 정리할 수 있을 거 같다.
1. Local에서 git init 을 실행해서 repository를 만들어 놓음.
2. gh repo create 명령어로 GitHub 내에서 빈 Repository를 생성하고 remote 설정 및 push까지 함.
https://cli.github.com/manual/gh_repo_create   

```
# create a remote repository from the current directory
gh repo create inflearn-coding-test --public --source=. --remote=origin --push
```


처음에 실수로 --push 플래그를 빼먹었더니 push 되지 않았다.   
그래서 GitHub에 생성된 repository를 지우고 다시 실행했더니   
`unable to add remote "origin"` 이라는 에러 메세지가 뜨면서 안 됐다.   
왜 그런가 했더니 remote 설정이 이미 되어있어서였다.   
`git remote -v` 명령어로 확인하면 된다.
그래서 `git remote remove origin` 으로 기존에 존재하는 remote 설정을 지우고 다시 시도함.   
... 그냥 `--remote` 옵션을 빼도 되지 않았을까 싶네... (어차피 있으니까)   