
### 콜백 함수(Callback Function)
: **다른 함수의 인자로 전달**되어 특정 작업이 완료된 후 **실행되는 함수**

+ 즉시 실행되는 되지 않고 **특정 이벤트나 작업이 완료된 후 실행**
+ 비동기 처리 상황에서 순차적인 동작을 보장을 위해 사용

### 고차 함수
: 함수를 인자로 받거나 다른 함수를 반환하는 함수
**Javascript의 함수는 일급 객체라 함수를 값처럼 사용 가능**

### 일급 객체(First-Class Citizen)
: 함수를 다른 함수의 인잘 전달되거나 반환 값처럼 사용할 수 있다는 의미

```Javascript
// 함수를 변수에 할당 가능
const greet = function(name) {
  return `안녕하세요, ${name}님!`;
};

console.log(greet('철수')); // 안녕하세요, 철수님!
```

```Javascript
// 함수를 다른 함수의 인자로 전달 가능
function completeTask() {
    console.log('completeTask 함수 시작');
}

function startTask(callbackFunction) {
    console.log('startTask 함수 시작');
    callbackFunction();
    console.log('startTask 함수 종료');
}

startTask(completeTask);
```


### Array 관련 고차 함수
#### forEach()
: **반환값이 없고** 배열을 순회하면서 원소에 대해 **콜백 함수 실행**

```Javascript
const numbers = [1, 2, 3, 4];

numbers.forEach((num) => {
    console.log(num); // 1, 2, 3, 4
});
```


#### map()
: 배열의 **각 원소에 대해** 콜백 함수의 반환값을 모아 **새로운 배열 반환(return 값 필요)** 
```Javascript
const numbers = [1, 2, 3, 4];

const doubled = numbers.map((num) => {
    return num * 2;
});

console.log(doubled); // [2, 4, 6, 8]
```


#### filter()
: 배열의 각 원소에 대해 **콜백 함수의 반환값이 true인 원소만** 모아 **새로운 배열을 반환(return값 필요)**
```Javascript
const numbers = [1, 2, 3, 4];

const evenNumbers = numbers.filter((num) => {
    return num % 2 === 0;
});

console.log(evenNumbers); // [2, 4]
```


#### reduce()
: 배열의 **원소를 순차적으로 누적하여 하나의 값으로 반환(return값 필요)****
```
Array.reduce((누적값, 배열 원소 값 ) => {함수},누적값 초기값 설정)
```

```Javascript
const numbers = [1, 2, 3, 4];

// accumulator : 누적값
// currentValue : 배열 원소 값
const sum = numbers.reduce((accumulator, currentValue) => {
    
    console.log(accumulator, currentValue);
    // 0 1
    // 1 2
    // 3 3
    // 6 4
    return accumulator + currentValue;
}, 0);

console.log(sum); // 10
```


#### find()
:  배열의 원소 중 콜백 함수의 *반환값이 참(true)인 **첫 번째 원소**를 반환(return값 필요)*
```Javascript
const numbers = [1, 2, 3, 4];

const firstEven = numbers.find((num) => {
    return num % 2 === 0;
});

console.log(firstEven); // 2
```
#### findIndex()
: 배열의 원소 중 콜백 함수의 *반환값이 참(true)인 **첫 번째 원소의 인덱스**를 반환(return값 필요)*
```Javascript
const numbers = [1, 2, 3, 4];

const firstEvenIndex = numbers.findIndex((num) => {
    return num % 2 === 0;
});

console.log(firstEvenIndex); // 1
```