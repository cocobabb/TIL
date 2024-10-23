: 값이나 함수가 접근할 수 있는 범위. 변수의 생명주기를 결정

### 전역 스코프(Global Scope)
+ 어디에서나 접근 가능한 범위
+ **함수나 블록 내부에 선언되지 않은 변수**로, 프로그램이 종료될 때까지 메모리에 유지
```Javascript
var globalVar = '전역 변수';

function printGlobalVar() {
    console.log(globalVar);
}

printGlobalVar(); // 전역 변수
```

### 지역 스코프(Local Scope)
#### 블록 스코프(Block Scope)
: { }로 감싸진 영역. 블록 내부에서 선언된 변수는 **블록 외부에서 접근할 수 없음**

```Javascript
if (true) {
    let blockVar = '블록 변수';
    console.log(blockVar); // 블록 변수
}

console.log(blockVar); // ReferenceError: blockVar is not defined
```


**예외)var 키워드로 선언된 변수는 블록 외부에서 접근 가능**

```Javascript
if (true) {
    var testVar = 'var 키워드 변수';
}

console.log(testVar); // var 키워드 변수
```
#### 함수 스코프(Function Scope)
: **함수 내부에서 선언된 변수는 함수 내부에서만 유효**
```Javascript
function funcScope() {
    let functionVar = '함수 변수';
    console.log(functionVar); // 함수 변수
}

funcScope();

console.log(functionVar); // ReferenceError: functionVar is not defined
```

### 스코프 체인(Scope Chain)
: 스코프가 중첩된 경우 내부 스코프에서 외부 스코프로 범위를 넓혀가며 변수를 검색하는 구조
**가장 가까운 스코프에서 변수를 찾음**

```Javascript
let globalVar = '전역 변수';

function outerFunction() {
    let outerVar = '외부 함수 변수';

    function innerFunction() {
        let innerVar = '내부 함수 변수';
        console.log(innerVar); // 내부 함수 변수
        console.log(outerVar); // 외부 함수 변수
        console.log(globalVar); // 전역 변수
    }
    innerFunction();
}
outerFunction();
```