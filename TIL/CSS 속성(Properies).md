
## 텍스트 관련
 + **color : 글자 색상 지정**
 ```css
 p {
    color: blue;
}

h1 {
    color: #ff5733;
}

span {
    color: rgb(255, 99, 71);
}
```
 + **font-size : 글자 크기를 지정**
	[절대 단위]
	 + px : 화면의 물리적 단위
	[상대 단위]
	 + % : 부모 요소의 크기에 대한 비율
	 
	 + em : 현재 글꼴 크기 기준으로 배수
		ex) font-size:2em 은 현재 글꼴 크기의 두배를 의미함
	
	 + rem : 루트 요소(보통 html요소)의 글꼴 크기 기준으로 배수.
		    기본적인 글꼴의 크기는 16px이다.
		    
 ```css
 p {
    font-size: 16px;
}

h1 {
    font-size: 2em;
}

span {
    font-size: 150%;
}
```
 + **font-family** : 글자 글꼴 지정
 + **font-weight** : 글자 굵기 지정(숫자로 지정 시 100~900)
 ```css
 p {
    font-weight: normal;
}

h1 {
    font-weight: bold;
}

span {
    font-weight: 700;
}

```
 + **text-align** : 글자 정렬 방식 지정
 ```css
 p {
    text-align: left;
}

h1 {
    text-align: center;
}

div {
    text-align: right;
}

```
## 너비와 높이 관련
[절대 단위]
 + px : 화면의 물리적 단위
[상대 단위]
+ % : 부모 요소의 크기에 대한 비율
	 
+ em : 현재 글꼴 크기 기준으로 배수
	ex) font-size:2em 은 현재 글꼴 크기의 두배를 의미함
	
+ rem : 루트 요소(보통 html요소)의 글꼴 크기 기준으로 배수. 기본적인 글꼴의 크기는 16px

+ vw : viewport 너비 기준 (*Viewport : 웹 브라우저에서 눈에 보이는 웹페이지 영역*)
	ex) width : 50vw 는 뷰포트 너비의 50%
+ vh : viewport 높이 기준
	ex) width : 50vh 는 뷰포트 높이의 50%
		    
 + **width** : 요소의 너비 지정
 
 + **height** : 요소의 높이 지정
 
 + **min-width & max-width** : 요소의 최소 넓이 & 요소의 최대 넓이
 
 + **min-height & max-height** : 요소의 최소 높이 & 요소의 최대 높이
	
## 배경 관련
+ **background-color** : 요소의 배경 색상 지정
```css
div {
    background-color: lightblue;
}

p {
    background-color: #ffebcd;
}

h1 {
    background-color: rgba(255, 99, 71, 0.5);
    /*rgba()의 마지막 숫자는 투명도를 의미함*/
}

```

+ **background-image** : 요소의 배경에 이미지 설정
```css
div {
    background-image: url('background.jpg');
}

p {
    background-image: url('https://example.com/image.png');
}

h1 {
    background-image: linear-gradient(to right, red, yellow);
    /* 레드에서 옐로우로 색깔로 그라데이션 되게 보여줌*/
}

```
+ **background-repeat** : *배경이미지는 크기의 맞춰 반복되므로 * 반복 방식을 정하거나 딱 맞게 설정해야함*
```css
div {
    background-repeat: no-repeat;
}

p {
    background-repeat: repeat-x;
}

h1 {
    background-repeat: repeat-y;
}

```
## 기타 속성
+ **opacity** : 요소의 투명도를 설정. 0은 완전 투명 ~ 1은 완전 불투명
```css
div {
    opacity: 0.5;
}

p {
    opacity: 0.7;
}

img {
    opacity: 0.3;
}
/*상위 태그에 opacity 속성을 걸면 하위태그까지 영향이 가기 때문에, 배경색을 투명하게 하면서 하위 태그는 영향을 안가게 하고 싶다면 rgba()를 이용할 것*/
```
+ **cursor** : 요소 위 마우스 커서 모양 지정
```css
a {
    cursor: pointer;
}

p {
    cursor: text;
}

div {
    cursor: move;
}
```
+ **visibility** : 요소의 가시성 설정
```css
div {
    visibility: hidden;
    /*요소를 숨김*/
}

p {
    visibility: visible;
    /*요소를 보임*/
}

h1 {
    visibility: collapse;
    /*테이블 요소 숨김*/
}
```
