### for 반복문
```Javascript

for(초기화; 조건식; 증감식){
	// 실행할 코드
}
```
**초기화** : 반복문 실행될 때 **한번 실행**
**조건식** : 반복 조건을 작성. **true 반복, false종료**
**증감식** : 코드 블럭 **반복이 끝날 때마다 실행**

```JavaScript
for (let i = 0; i < 5; i++) {
  console.log(`현재 숫자: ${i}`);
}
// 현재 숫자: 0
// 현재 숫자: 1
// 현재 숫자: 2
// 현재 숫자: 3
// 현재 숫자: 4

```

### while 반복문
```JavaScript
while (조건식) {
  // 실행할 코드
}

```
: **조건식이 true인 동안 코드 블록 반복** 실행. 반복횟수가 확실히지 않을 때 사용

```JavaScript
let count = 0;
while (count < 5) {
  console.log(`카운트: ${count}`);
  count++;
}
// 카운트: 0
// 카운트: 1
// 카운트: 2
// 카운트: 3
// 카운트: 4

```

### do...while 반복문
```JavaScript
do {
  // 실행할 코드
} while (조건식);

```
+ 코드 블록을 최소 **한번 실행 후 조건식 평가**
+ **조건에 상관 없이 한번은 실행**
```JavaScript
let num = 5;
do {
  console.log(`숫자: ${num}`);
  num++;
} while (num < 5);
// 숫자: 5
```

### for...in 반복문
```JavaScript
for (let key in 객체) {
  // 실행할 코드
}
```
: **열거 가능한 자료형(Enumerable)object를 순회**할 때 사용

```JavaScript
const person = { name: '홍길동', age: 30, city: '서울' };
for (let key in person) {
  console.log(`${key}: ${person[key]}`);
}
// name: 홍길동
// age: 30
// city: 서울

```

### for...of반복문
```JavaScript
for (let value of 반복 가능한 자료형) {
  // 실행할 코드
}
// 반복 가능한 자료형 : String, Array, Map 등
```
: **반복 가능한 자료형(Iterable)의 값을 순회**할 때 사용

```JavaScript
const array = [1, 2, 3, 4, 5];
for (let number of array) {
  console.log(`숫자: ${number}`);
}
// 숫자: 1
// 숫자: 2
// 숫자: 3
// 숫자: 4
// 숫자: 5

```

### 반복문 제어어

#### break
: 반복문 즉시 종료
```JavaScript
for (let i = 0; i < 10; i++) {
  if (i === 5) {
    break;
  }
  console.log(`i의 값: ${i}`);
}
// i의 값: 0
// i의 값: 1
// i의 값: 2
// i의 값: 3
// i의 값: 4

```

#### continue
: 현재 반복을 건너뛰고 다음 반복으로 넘어감
```JavaScript
for (let i = 0; i < 5; i++) {
  if (i === 2) {
    continue;
  }
  console.log(`i의 값: ${i}`);
}
// i의 값: 0
// i의 값: 1
// i의 값: 3
// i의 값: 4

```