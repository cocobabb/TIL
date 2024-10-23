
참조 자료형
: 데이터가 메모리에 직접 저장(원시 자료형)되는 것이 아니라, **메모리 주소를 참조하여 값에 접근함**

### 배열(Array)
: 0개 이상의 값을 순차적으로 저장하는 자료형 
+ **값 추가와 제거 자유로움**
+ **자료형 구분 없이 저장 가능**
+ 각 원소 위치를 나타내는 인덱스로 원소에 접근 가능 대괄호를 사용하여 접근함
+ 인덱스 0부터 시작
```Javascript
let fruits = ['사과', 1, '딸기'];

console.log(fruits); // [ '사과', 1, '딸기' ]

console.log(typeof fruits[0]); // string

console.log(typeof fruits[1]); // number
```
### 배열 메서드

+ **push()**
	: 배열의 **끝에 원소 추가**
```Javascript
let numbers = [1, 2, '3'];
numbers.push(4);
console.log(numbers); // [ 1, 2, '3', 4 ]
```


+ **pop()**
	: 배열의 **마지막 원소 제거하고 반환**
```Javascript
let numbers = [1, 2, '3'];
let pop_number = numbers.pop();

console.log(numbers); // [ 1, 2 ]
console.log(pop_number); // 3
```


+ **unshift()**
	: 배열의 **앞에 원소를 추가**
```Javascript
let numbers = [1, 2, '3'];
numbers.unshift('0');
console.log(numbers); // [ '0', 1, 2, '3' ]
```


+ **shift()**
	 : 배열의 **첫번째 원소 제거하고 반환**
```Javascript
let numbers = [1, 2, '3'];
let number = numbers.shift();

console.log(numbers); // [ 2, '3' ]
console.log(number); // 1
```


+ **slice(start, end)**
	 : 인덱스 **start위치부터 end-1 위치까지** 잘라서 **새로운 배열 반환**
```Javascript
let numbers = [1, 2, '3'];
let slice_numbers = numbers.slice(0, 2);

console.log(slice_numbers); // [ 1, 2 ]
```

### 객체(Object)
: key와 value의 쌍을 가진 속성(property)으로 이루어진 자료형
**각 속성은 key를 통해 접근 가능**

```Javascript
// person은 3개의 속성을 가진다.
let person = {
  name: '홍길동',
  age: 30,
  job: '개발자',
};

// 마침표(.) key를 활용한 value 접근
console.log(person.name); // 홍길동

// 대괄호 key를 활용한 value 접근
console.log(person['job']); // 개발자

// key를 활용한 value 접근 후 value 수정
person.age = 40;

console.log(person); // { name: '홍길동', age: 40, job: '개발자' }

```

### 집합(Set)
: 중복되지 않는 값들의 모음을 저장하는 자료형.
**중복 값은 제거**되며, 값의 **순서는 보장되지 않음**

```Javascript
let uniqueValues = new Set([1, 2, 2, 3]);
console.log(uniqueValues); // Set { 1, 2, 3 }
```

### Set 메서드
+ add()
	: Set에 새로운 값을 추가
	
```Javascript
let uniqueValues = new Set([1, 2, 2, 3]);

uniqueValues.add(4);
uniqueValues.add(3);
//순서는 어떻게 될지 알 수 없음

console.log(uniqueValues); // Set(4) { 1, 2, 3, 4 }
```


+ has()
	: Set에 특정 값이 존재하는지 확인
	
```Javascript
let uniqueValues = new Set([1, 2, 2, 3]);

console.log(uniqueValues.has(2)); // true
console.log(uniqueValues.has(4)); // false
```


+ delete()
	: Set에서 특정 원소 제거
```Javascript
let uniqueValues = new Set([1, 2, 2, 3]);
console.log(uniqueValues); // Set(2) { 1, 2, 3 } 중복값 자동으로 제거됨. size:3

uniqueValues.delete(2);

console.log(uniqueValues); // Set(2) { 1, 3 }
uniqueValues.delete(2); // 이미 제거 된 요소 제거해도 오류가 발생하지 않는다.
```

### JSON(JavaScript Object Notation)
: Javascript 객체 표기법을 기반으로 한 데이터 형식
기존에 많이 활용되던 XML 보다 형식이 간결하고 대부분의 프로그래밍 언어에서 사용 가능

### JSON 구조
+ key-value 쌍으로 데이터 표현
+ **중괄호 객체, 대괄호는 배열을 나타냄**
### JSON 지원 자료형
+ String
+ Number
+ Boolean
+ Array
+ Object
+ null

```JSON
{
// 하나의 Object에 다수의 속성을 저장한 JSON

    "name": "홍길동", // 문자열(String)
    "age": 30, // 숫자(Number)
    "isStudent": false, // 불리언(Boolean)
    "courses": ["수학", "영어", "과학"], // 배열(Array)
    "address": {
        "city": "서울",
        "zipcode": "10001"
    }, // 객체(Object)
    "graduationYear": null // null
}
```

```JSON
[
// 하나의 Array에 공통 속성을 가진 다수의 Object 저장한 JSON
    {
        "name": "김철수",
        "age": 30,
        "city": "서울"
    },
    {
        "name": "박영희",
        "age": 25,
        "city": "부산"
    },
    {
        "name": "이민수",
        "age": 35,
        "city": "대구"
    },
    {
        "name": "최은영",
        "age": 28,
        "city": "인천"
    }
]
```
