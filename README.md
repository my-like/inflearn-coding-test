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

GitHub CLI 를 활용하면 다음으로 정리할 수 있을 거 같다.. (아직 안 해봄)   
https://cli.github.com/manual/gh_repo_create   

```
# create a remote repository from the current directory
gh repo create inflearn-coding-test --public --source=. --remote=upstream --push
```