+ 재사용 가능한 코드 블록 
+ 코드의 중복 줄이고 유지보수성 높임
+ 함수 내부 코드 착성 하는 것을 정의(define)
+ 정의한 함수를 실행 하는 것을 호출(call)
```Javascript
function 함수이름(매개변수) {
    // 실행할 코드
    return 반환값;
}
```
**매개변수(Parameter)** : 함수가 필요로 하는 입력값
**return** : 함수의 결과를 반환하면서 함수를 종료 시킴
**인자(argument)** : 함수를 호출할 때 실제로 전달하는 값

```Javascript
// 매개변수에 기본 값 설정하는 법
function greet(name = "Guest") {
    console.log(`안녕하세요, ${name}님!`);
}

greet(); // 안녕하세요, ${Guest}님!
```

```Javascript
// 여러 개의 인수를 배열로 받을 수 있는 방법
function greetAll(...names) {
    for (name of names){
        console.log(`안녕하세요, ${name}님!`);
    }
}
greet("철수", "영희"); 
```

```Javascript
function greet(name) {
    console.log(`안녕하세요, ${name}님!`);
}
// 함수의 매개변수의 가변 길이 이상의 인자를 지원함
greet("철수", "영희"); // 오류 없이 실행 but, 철수만 출력
```
### 함수의 종류

+ #### 함수 선언식(Function Declarations)
	: function 키워드를 사용하여 함수 선언하는 방식. **Hoisting이 발생할 수 있음**
```Javascript
function greet(name) {
    return `안녕하세요, ${name}님!`;
}

console.log(greet('철수')); // 안녕하세요, 철수님!
```
**Hoisting** : 변수와 함수 선언이 그들이 포함된 스코프의 최상단으로
		끌어올려진 것처럼 동작하는 JavaScript 엔진 특성. 
```Javascript
// Hoisting 발생
console.log(add(2, 3)); // 5

function add(a, b) {
    return a + b;
}
```



+ #### 함수 표현식(Function Expression)
	: 함수를 변수에 할당하는 방식(let, const 이용). **익명 함수(Anonymous Function)를 사용하며 Hoisting이 되지 않고 선언 이후에만 호출됨**
```Javascript
const multiply = function(a, b) {
    return a * b;
};

console.log(multiply(2, 3)); // 6

```



+ #### 화살표 함수(Arrow Function)
	: **function키워드 대신 =>를 사용**. **this에 대한 바인딩이 없어**, 코드가 예측 가능하여 이 방식이 주로 선호됨
	
```Javascript
const add = (a, b) => {
    return a + b;
};

console.log(add(5, 7)); // 12
```

```Javascript
const add = (a, b) => a * b; // 한 줄로 작성 시 return 생략 가능

console.log(add(5, 7)); // 35
```

### 메서드(Method)
: **객체 내부에 정의된 함수**. 객체의 동작을 추가하는 역할

```Javascript
const person = {
    name: '철수',
    greet: function () {
        console.log('안녕하세요. 반갑습니다.');
    },
};

person.greet(); // 안녕하세요. 반갑습니다.
```

```Javascript
const person = {
    name: '철수',
    greet() {
        console.log('안녕하세요. 반갑습니다.'); // function 없이 축약하여 사용 가능
    },
};

person.greet(); // 안녕하세요. 반갑습니다.
```
