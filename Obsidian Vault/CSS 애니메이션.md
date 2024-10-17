: css로 동적 효과와 시각 변화를 적용

transition
: CSS 속성의 변화를 부드럽게 전환하는 효과


```css
.box {
    width: 100px;
    height: 100px;
    background-color: blue;
    transition: background-color 1s ease;
}
.box:hover {
    background-color: red;
}
/* 요소에 커서를 올리면(hover) 1초 동안 배경색이 파란색에서 빨간색으로 전환 */
```
