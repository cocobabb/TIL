 git init
 : git으로 관리 시작. 관리하고 싶은 폴더위치에서 최초 1회만 실행
 
git add
: 변경 사항을 staging area(*임시저장공간*) 에 올림
: git add 파일명
: git add .
	현재 폴더 전체 add

git diff head
: add후 변경 사항 추적

git commit -m '메세지'
: 메세지와 함께 임시 저장 공간에 있던 사항들 완전히 저장

git log
: 커밋 기록 확인
git --oneline
: 커밋 기록 한줄만 보기
git -n
: 커밋 기록 n개만 보기

git status
: 파일 상태 확인 (*변경사항이나 저장했는지 확인 할 수 있음)


## git_branch

branch
: 하나의 프로젝트에 대한 개별 작업 공간

git branch
: 현재 가지고 있는 branch  확인

git branch 브랜치명명
:  새로운 branch 생성

git switch branch
: 다른 branch로 이동

git switch -c 브랜치명
: 새로운 브랜치 생성하여 바로 이동

git log --oneline --graph --all
: 모든 브랜치의 로그를 그림으로 확인하고 싶을 때

git merge 합칠 브랜치명
: 주체가 되는 branch에서 분리된 branch를 합침

vim 편집기 >> :wq 입력하여 저장 & 종료

git branch -d 브랜치명
: 해당 브랜치 삭제

3-Way-Merge
:  2개의 브랜치들의 변경 사항들을 하나로 병합하는 것


Fast- Forward
:  2개의 브랜치를 병합할 때 하나의 브랜치에서만 변경 사항이 있고 다른  브랜치에서 변동 사항이 없는데 merge할 경우 발생하는 현상
:  브랜치의 변경 사항이  다른 브랜치로 병합 되기 보단 이동의 느낌?


