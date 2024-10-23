
### flex box
: display 속성 값 중 하나로 레이아웃을 유연하게 구현하기 위한 CSS 레이아웃 모델

+ flex container
	: 레이아웃이 적용되는 **부모 요소** 
	자식요소들을 변환해 배치하는 영역
+ flex Items
	: 컨테이너 내부에 있는 **자식 요소**
	레이아웃에 따라 배치 되는 대상


### flex-direction
: 플렉스 아이템 배치될 방향 설정
+ **row(기본값) : 왼쪽>오른쪽 수평 배치**
+ **row-reverse : 오른쪽 > 왼쪽 수평 배치**
+ **column : 위 > 아래 수직 배치**
+ **column-reverse : 아래 > 위 수직 배치**


### justify-content
: main-axis 따라 플렉스 아이템 정렬(세로축 정렬) 
+ **flex-start : 시작점에서 정렬**
+ **flex-end : 끝점에서 정렬**
+ **center : 가운데 정렬**
+ **space-between : 동일한 간격 주기(양끝에 여백x)**
+ **space-around : 동일한 간격 주기. (양끝에 여백o)**

### align-items
: cross-axis을 따라 플렉스 아이템 정렬(가로축 정렬)
+ **flex-start : 시작점에서 정렬**
+ **flex-end : 끝점에서 정렬**
+ **center : 가운데 정렬**
+ **baseline : 텍스트 기준선에 맞춰 정렬**

### flex-wrapj
: 아이템이 한 줄에 다 들어가지 않을 때 어떻게 처리할지 결정
+ **nowrap(기본 값) : 줄바꿈 없음**
+ **wrap : 여러 줄 배치**
+ **wrap-reverse : 역순으로 줄바꿈**

### flex-grow
: 남은 공간을 얼마나 채울지 결정. 기본값 0. 배수로 공간을 차지

### flex-shrink
: 공간이 부족할 때 아이템이 얼마나 줄어들지 결정. 기본값 1이며 0으로 설정하면 아이템 줄어들지 않음

### flex-basis
: 아이템 기본 크기 설정(최소 너비 높이 설정 가능)