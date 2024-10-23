: 웹 페이지의 스타일(디자인)을 정의하는 언어. 아래와 같은 3가지 방법으로 사용되며 주로 리팩토링이 쉽게 마지막 방법을 주로 이용한다.
	cascading : 구조 또는 컨텐츠에 적용되는 스타일에 우선 순위를 결정하는 방식으로
				하나의 요소에 여러 스타일이 적용되면 우선 순위에 따라 적용되는 스타일 결정함

+ 인라인 스타일(Inline style)
```html
<h1 style="color: red;">제목</h1>
```
+ 내부 스타일 시트(Internal Style Sheet)
```html
    <style>

      h1{

        color: red;

      }

    </style>
```
+ 외부 스타일 시트(External Style Sheet)
	html파일
```html
    <head>

      <link rel="stylesheet" href="style.css">

    </head>

    <body>

      <h1>제목</h1>

    </body>
```
	style.css 파일
```css
h1{
	color: red; 
}	
```

# 브라우저 개발자 도구
![[image.png]]1. Inspector
	: html 요소를 선택할 수 있음
2.Style
	: 요소에 적용된 CSS 확인 가능
	: 개발자 도구 내부에서 Style 변경 가능 (실제로 파일이 바뀌지는 않음)
3.computed
	: 요소에 최종적으로 적용된 CSS 확인 가능


# CSS 선택자

+ 전체 선택자 :문서 내 모든 요소 선택
```css
*{
	margin: 0;
	padding: 0;
}
```
+ tag 선택자 :문서 내 특정 태그를 가진 모든 요소 선택
```css
p{
	color: blue;
	font-size: 20px;
}
```
+ class 선택자 :문서 내 특정 class를 가진 모든 요소 선택.  마침표(.)를 사용해서 정의
```css
.example{
	color: green;
	font-weight: 900;
}
```
+ id 선택자 :고유한 id값을 가진 요소 하나를 선택. 해시(#)를 사용해서 정의
```css
#head{
	color: skyblue;
}
```
+ 자식 선택자 :특정 부모 요소 바로 아래 하위요소 선택
```css
div>p{
	color: brown;
	font-size: 12px;
}
```
+ 자손 선택자 :특정 부모 요소의 모든 하위 요소 선택
```css
div span{
	color:purple;
	font-style: italic;
}
```
+ 그룹화 선택자 :여러 선택자에 동일한 스타일을 적용할 때 사용. 여러 선택자를 쉼표(,)로 정의
```css
h2,
h3,
h4{
	color: red;
}
```

**한 tag가 여러개의 class를 가질 수 있다. 각 class 이름은 띄어쓰기로 구분된다.**
```html
<h1 class="cls1 cls2">제목</h1>
```
