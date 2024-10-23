: display 속성 값 중 하나로 **2차원 레이아웃 시스템**으로 **요소들을 row(행)과 column(열)을 기준으로 배치**

##### 부모요소
+ **display: grid**
+ **grid-template-columns** : 그리드 컨테이너에서 **열 크기 설정**
+ **grid-template-rows** : 그리드 컨테이너에서 **행의 크기를 설정**
+ **grid-gap** : 그리드 **아이템 사이의 간격 설정**

##### 자식요소
 + grid-column-start
 + grid-column-end
 ```css
 .item {
  grid-column-start: 1; 
  /* 자식 요소가 그리드 컨테이너의 첫 번째 열에서 시작한다. */
  grid-column-end: 4;
  /* 자식 요소가 그리드 컨테이너의 네 번째 열에서 끝난다. */
  
  /* 실제로 차지하는 공간은 3칸 */
}
```
+ grid-column
	: 열의 시작과 끝을 설정
```css
.item {
  grid-column: 1 / 3; 
  /* 첫 번째 열에서 시작해서 두 번째 열까지 차지 */
  /* 실제로 차지하는 공간은 2개*/
}
```
+ grid-row-start
+ grid-row-end
```css
.item{
	grid-row-start: 1; 
	/* 자식 요소가 그리드 컨테이너의 첫 번째 행에서 시작한다. */
	grid-row-end: 4;
	/* 자식 요소가 그리드 컨테이너의 네 번째 행에서 끝난다. */
  
	/* 실제로 차지하는 공간은 3칸 */
}
```
+ grid-row
	: 행의 시작과 끝을 설정
```css
.item {
  grid-row: 1 / 4; 
  /* 첫 번째 행부터 시작해서 세 번째 행까지 차지 */
}
```

+ span 
	: 시작과 끝을 설정할 필요 없이 span으로도 크기 설정 가능
```css
.item {
  grid-column: span 2 
  /* 2개의 열을 차지 */
  
  grid-column: span 2 
  /* 2개의 열을 차지 */
}
```
+ grid-area
	: 그리드 아이템이 **특정 영역 차지**하도록 설정. 행과 열의 시작 및 끝을 한번에 지정 가능
		grid-row-start, grid-column-start, grid-row-end, grid-column-end 순으로 지정
```css
.item {
  grid-area: 1 / 1 / 3 / 3; 
  /* 1번째 행 1번째 열에서 시작해 3번째 행과 3번째 열까지 차지 */
}
```

+ **justify-self**
	: 그리드 아이템을 수평 정렬
```css
.item {
	justify-self: start; /* 수평 왼쪽 정렬 */
	justify-self: end; /* 수평 오른쪽 정렬 */
	justify-self: center; /* 수평 중앙 정렬 */
}
```
+ **align-self**
	: 그리드 아이템을 수직 정렬
```css
.item {
	align-self: start; /* 수직 위쪽 정렬 */
	align-self: end; /* 수직 아래쪽 정렬 */
	align-self: center; /* 수직 중앙 정렬 */
}
```