
#### 변수
: 데이터를 저장(할당)하기 위한 **메모리 공간**에 붙여진 이름

#### 변수 선언
+ **var**
	+ 변수 중복 선언 가능
	+ **Hoisting이 발생**
		: 변수와 함수 선언이 그들이 포함된 스코프의 최상단으로 끌어올려진 것처럼 동작하는 JavaScript 엔진 특성. var로 선언된 변수는 선언 전 접근 가능하지만 undefined가 뜸
		이러한 이유들로 **최신 JavaScript에서는 권장하지 않음**
		
```Javascript
console.log(name); // undefined (호이스팅 발생)

var name = '철수';

console.log(name); // 철수
```

+ **let**
	+ **중복 선언 불가능**
	+ **선언 이전에 변수에 접근하면 ReferenceError 발생**
	+ **변수 선언과 값 할당 분리 가능**
	+ 블록 스코프 가짐
```Javascript
let name = '철수';

let name = '영희'; // 변수 name은 이미 선언했기 때문에 다시 선언할 수 없다.
```

```Javascript
let name;
name = '철수'; // 변수 선언과 값 할당을 분리할 수 있다.

console.log(name); // 철수
```

#### 상수 선언
+ **const**
	+ **상수**(변경할 수 없는 변수)로 값 변경 불가능
	+ **변수 선언과 함께 값 할당 필수**
	+ 블록 스코프


#### Template Literals
: **문자열을 백틱으로 감싸**고 **문자열 내 변수 삽입**할 수 있는 문자열 표현 방식.

```Javascript
let name = '철수';
let message = `안녕하세요 ${name}라고 합니다`;
// 삽입하고 싶은 위치에 ${변수}를 작성

console.log(message);
```

