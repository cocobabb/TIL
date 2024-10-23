: 화면 크기, 장치의 특성에 따라 css 스타일 적용. 반응형 웹 디자인 구현 시 사용.

```css

@media (min-width: 600px) {
  body {
    background-color: lightblue;
    /*
    화면 너비가 600px 이상일 때 적용되는 스타일 
    600미만은 하얀색 배경이다가 600이상부터 lightblue로 바뀜
    */
  }
}
```

```css
@media (orientation: landscape) {
  body {
    background-color: lightyellow;
    /*
    화면 너비가 높이보다 클 때 적용
    화면의 높이가 너비보다 클 때 배경색 lightyellow로 바뀜
    */
  }
}
```

```css
@media (orientation: portrait) {
  body {
    background-color: lightpink;
    /*
    화면 높이가 너비보다 클 때를 적용
    너비가 높이 보다 클 때 배경색 lightpink로 바뀜
    */
  }
}
```

```css
@media (min-width: 800px) and (orientation: landscape) {
  body {
    background-color: lightblue;
    font-size: 20px;
    /*
    가로 방향, 너비가 800px 이상일 때 적용
    */
  }
}
```
```css
@media (max-width: 600px) and (orientation: portrait) {
  body {
    background-color: lightcoral;
    font-size: 16px;
    /*
    세로 방향, 너비가 600px 이하일 때 적용
    */
  }
}

```
