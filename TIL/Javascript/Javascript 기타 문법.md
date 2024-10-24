
### 펼침 연산자(Spread Operator) : ...
+ 배열이나 객체의 내용을 펼쳐서 새로운 배열 또는 객체 생성
+ **개별적인 값으로 분리**
```Javascript
let arr1 = [1, 2, 3];
let arr2 = [...arr1, 4, 5, 6]; // arr1의 값을 분리해서 삽입

console.log(arr2); // [1, 2, 3, 4, 5, 6]
```

```Javascript
let obj1 = { name: '홍길동', age: 25 };
let obj2 = { ...obj1, job: '개발자' }; // 객체의 속성을 분리하여 삽입

console.log(obj2); // { name: '홍길동', age: 25, job: '개발자' }
```

### 구조 분해 할당(Destructuring Assignment)

+ 배열이나 객체의 값을 개별 변수로 **간편하게 분해하여 할당**하는 문법
+ 변수를 선언할 때 구조에 맞추어 **배열이나 객체의 값을 자동으로 분리**해주는 역할

##### 배열의 구조 분해 할당
```Javascript
// 배열의 원소를 변수에 할당
const fruits = ['사과', '바나나', '딸기'];

const [first, second, third] = fruits;

console.log(first); // '사과'
console.log(second); // '바나나'
console.log(third); // '딸기'
```

```Javascript
// 필요한 원소만 할당 가능
const numbers = [1, 2, 3, 4, 5];

const [, second, , fourth] = numbers;

console.log(second); // 2
console.log(fourth); // 4
```

```Javascript
const numbers = [1, 2, 3, 4, 5];

const [first, second, ...rest] = numbers; 
// ...로 남은 원소를 하나의 변수에 모두 할당

console.log(first); // 1
console.log(second); // 2
console.log(rest); // [3, 4, 5 ]
```



##### 객체의 구조 분해 할당

```Javascript
// 객체의 key와 동일한 변수에 value 할당됨
const person = {
    name: '홍길동',
    age: 30,
    job: '개발자',
};

const { name, job, age } = person;

console.log(name); // '홍길동'
console.log(age); // 30
console.log(job); // '개발자'
```

```Javascript
// 객체 속성을 다른 이름 변수로 할당 
const person = {
    name: '홍길동',
    age: 30,
};

const { name: fullName, age: years } = person;

console.log(fullName); // '홍길동'
console.log(years); // 30
```

### 단축 프로퍼티(Property value shorthand)
```Javascript
// key, value가 변수의 이름과 동일하면 변수명만 명시 가능
const name = 'jun';
const age = 25;

const person1 = {
    name: name,
    age: age
};

const person2 = {
    name,  // name: name과 동일
    age    // age: age와 동일
};
```

### 옵셔널 체이닝 : ?
+ 중첩된 객체의 **깊은 속성에 접근할 때 안전하게** 존재 여부를 **확인**하는 문법
+ 존재하지 않는 속성에 접근할 때 발생하는 **오류를 방지** 가능
+ **존재하지 않는 속성에 접근하면 오류 대신`undefined` 를 반환** 

```Javascript
// 객체의 속성에 접근할 때 안접하게 값을 확인
const user = {
    name: '홍길동',
    address: {
        city: '서울',
    },
};

console.log(user?.name); // 홍길동
console.log(user?.address?.city); // 서울
console.log(user?.phone?.number); // undefined (속성이 없지만 오류 발생 X)
```

```Javascript
// 배열의 원소에 접근할 때 안접하게 값을 확인
const users = [{ name: '철수' }, { name: '영희' }];

console.log(users?.[0]?.name); // 철수
console.log(users?.[1]?.name); // 영희
console.log(users?.[2]?.name); // undefined (배열 원소가 없지만 오류 발생 X)

```

```Javascript
// 객체의 메서드에 접근할 때 안접하게 값을 확인
const user = {
    greet() {
        return '안녕하세요!';
    },
};

console.log(user.greet?.()); // 안녕하세요!
console.log(user.sayHello?.()); // undefined (메서드가 없지만 오류 발생 X)
```

### Nullish 병합 연산자 : ??
+ 값이 `null` 또는 `undefined` 일 때 **기본값을 설정하는 연산자**
+ OR 논리 연산자 `||` 와 비슷하지만 `||` 는 `false`인 값을 기본값으로 대체하지만 Nullish 연산자는 **오직 `null` 과 `undefined` 만 대체**한다.

```Javascript
let username = null;
let defaultName = '익명';

let name = username ?? defaultName; // username은 null 이므로 기본값 적용
console.log(name); // 익명

```

```Javascript
// || 와의 차이
let number = 0;
let defaultNumber = 10;

let resultOr = number || defaultNumber; // 0은 false로 평가되어 기본값 적용 O 
console.log(resultOr); // 10

let resultNullish = number ?? defaultNumber; // 0은 nullish가 아니므로 기본값 적용 X
console.log(resultNullish); // 0
```

### 파일 참조 속성
#### defer
- 파일을 **비동기적으로 다운로드**하고, **HTML 문서 해석이 끝난 후** 실행
- **DOM이 모두 준비된 후** 스크립트가 실행되므로, DOM 조작에 유용
```HTML
<script src="app.js" defer></script>
```

#### async
- JavaScript 파일을 **비동기적으로** 다운로드하여 **다운로드가 완료되는 즉시 실행**
- HTML 해석과 JavaScript 실행이 동시에 진행되므로, 페이지 로딩 속도가 빠르지만, **실행 순서가 보장되지 않음**

```HTML
<script src="app.js" async></script>
```