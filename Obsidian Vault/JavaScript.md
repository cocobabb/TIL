: 웹 페이지에 동적인 기능을 추가하는 프로그래밍 언어
+ **브라우저에서 실행**되며 **동작(이벤트)에 따라 반응**
+ 클라이언트 측 언어로만 사용되었으나, **node.js의 등장 이후 서버 측 애플리케이션 개발이 가능**해짐

#### Node.js
:  Chrome V8 JavaScript 엔진 위에 구축된 **서버측에서 실행되는 JavaScript환경** . 클라이언트 사이드 뿐만 아니라 **서버 사이드 언어로도 사용이 가능**

#### 특징
+ 동적 타입: 변수에 어떤 데이터 타입이든 할당 가능, 실행 중에 타입 변경 가능(const는 상수이므로 변경 불가능)
+ 객체 기반: 대부분의 데이터는 객체로 표현되며, 객체와 프로토타입을 사용해 상속을 구현
+ **비동기 처리**: **이벤트 루프**와 **콜백 함수**, **Promise**등을 통해 **비동기 작업을 처리**
+ DOM조작 : DOM(Document Object Model)을 통해 HTML 요소 조작 가능


#### 사용
+ **HTML 문서 내에서 script 태그로 사용**하여 직접 작성
```html
<!DOCTYPE html>
<html>
  <head>
    <script>
      console.log('Hello, JavaScript!');
    </script>
  </head>

  <body></body>
</html>
```
+ **Node.js를 설치하면 node 커맨드로 파일을 실행**
	.js 확장자 파일에 JavaScript 코드 작성하고 해당 파일 위치에서 node 커맨드로  실행
	
실행 파일
```Javascript
console.log('Hello, JavaScript World!');
console.log('이 파일은 node 커맨드로 실행');
```


실행 명령어(Terminal 에서 실행)

```	
node 실행 파일명.js
```

실행 결과(Terminal에서 출력됨)
```
Hello, JavaScript World!
이 파일은 node 커맨드로 실행
```



+ **HTML에서 외부 JavaScript 파일 참조**
	: 이와 같은 방법으로 불러 올 때는 웬만하면 **body 태그의 끝 부분에서 참조하여 HTML이 모두 로드된 후 JavaScript를 실행**되게 해야함
	이유: 웹페이지의 html 요소가 세팅되기 전에 JavaScript가 먼저 실행되면 페이지 로딩이 시간이 길어지거나 에러가 날 수가 있기 때문
```html
<!DOCTYPE html>
<html>
  <head>
    <script src="./1-3.js"></script>
    /* script 태그의 주소에 js파일 있는 위치 주소 넣음 */
  </head>

  <body></body>
</html>

```

```html
<!DOCTYPE html>
<html>
  <body>
    <script src="./1-4.js"></script>
    /* script 태그의 주소에 js파일 있는 위치 주소 넣음 */
  </body>
</html>

```