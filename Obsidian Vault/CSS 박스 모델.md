![[Pasted image 20241015204308.png]]
 + content : 텍스트나 이미지가 들어가는 실제 공간
 + padding : 콘텐츠와 테두리 사이의 공간으로 요소 내부의 여백과 관련
 + border : 요소의 테두리
 + margin : 요소 바깥 공간으로 다른 요소들간의 간격 설정과 관련

### box-sizing
: 요소 크기 설정 시 패딩과 테두리를 포함할지 여부 설정
```css
.box1{
	box-size: content-box;
	/*콘텐츠 영역만*/
}
.box2{
	box-size: border-box;
	/*크기에 패딩과 테두리 포함*/
}
```
