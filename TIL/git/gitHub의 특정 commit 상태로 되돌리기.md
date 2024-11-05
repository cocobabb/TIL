
git restore {폴더명 또는 파일명}
git restore .  
: 가장 최근 commit으로 돌아감

git reflog
: commit, checkout, reset 등의 활동에 대한 이전 기록들 볼 수 있음

git reset --hard  {commit주소}
:  과거 해당 커밋 상태로 돌아감
- git log --oneline에서 해당 commit 주소 확인(주소는 4번째 자리까지 해도 인식됨)
- 해당 명령어 실행 전 git add가 먼저 선행되어야 함

git stash
: 변경 사항을 임시저장

git stash pop
: 가장 최근에 임시저장한 변경 사항 삭제하면서 불러 오는 것

git stash list
: git stash 의 저장된 목록들을 호출

git stash apply {인덱스}
: list 출력 시 보이는 인덱스로 임시저장 된 stash를 삭제하지 않고 불러 올 수 있음

git stash drop {인덱스}
: list 출력 시 보이는 인덱스로 임시저장된 stash 삭제(삭제하면 stash의 인덱스는 당겨짐)