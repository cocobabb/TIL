// 변수 arr 을 선언하고, 배열에 값을 할당
let arr = [1, 3, 5, -3, 9, 10, 23, -6, 44, 22, -10, 5, 20];

// 배열 함수 forEach() 를 활용하여 배열에서 양수만 출력
console.log('-- 양수만 출력--');
arr.forEach((num) => {
  if (num > 0) console.log(num);
});

// 배열 함수 map() 를 활용하여
// 각 원소에 곱하기 2를 한 값을 모은 새로운 배열을 만들고 출력
console.log('-- 2를 한 값을 모은 새로운 배열(map 활용)--');
let newArr = arr.map((num) => num * 2);
console.log(newArr);

// 배열 함수 filter() 를 활용하여
// 양수이면서 홀수인 원소만 모은 새로운 배열을 만들고 출력
console.log('--양수이면서 홀수인 원소만 모은 새로운 배열(filter 활용)--');
newArr = arr.filter((num) => {
  if (num > 0 && num % 2 !== 0) {
    return num;
  }
});
console.log(newArr);

console.log('--첫 번째 5 찾기 위치 찾기(findIndex 활용)--');
// 배열 함수 findIndex() 를 활용하여
//  첫 번째로 나오는 5의 위치(index)를 출력
let idx = arr.findIndex((num) => {
  if (num === 5) {
    return num;
  }
});
console.log(idx);

let todos = [
  {
    todoId: 1,
    content: '예습하기',
    isCompleted: false,
  },
  {
    todoId: 2,
    content: '강의듣기',
    isCompleted: false,
  },
  {
    todoId: 3,
    content: '복습하기',
    isCompleted: false,
  },
];

console.log('--배열 내 객체를 하나씩 출력--');
todos.forEach((ob) => {
  console.log(ob);
});

console.log('--배열 내 객체 중 isCompleted 가 true 인 객체만 출력--');
todos = [
  {
    todoId: 1,
    content: '예습하기',
    isCompleted: false,
  },
  {
    todoId: 2,
    content: '강의듣기',
    isCompleted: true,
  },
  {
    todoId: 3,
    content: '복습하기',
    isCompleted: true,
  },
];
todos.forEach((ob) => {
  if (ob.isCompleted === true) {
    console.log(ob);
  }
});

let matrix = [
  [4, 2],
  [3, 2],
  [5, 7],
  [10, 1],
];
console.log('--내부 배열의 두 번째 원소만 출력--');
matrix.forEach((arr) => console.log(arr[1]));
console.log('--내부 배열의 두 번째 원소만 모아 배열 만들기1--');
newArr = [];
matrix.forEach((arr) => newArr.push(arr[1]));
console.log(newArr);

console.log('--내부 배열의 두 번째 원소만 모아 배열 만들기2--');
newArr = matrix.map((arr) => arr[1]);
console.log(newArr);

console.log(
  '--내부 배열의 원소 합이 짝수인 배열만 모아서 새로운 이차원 배열을 생성 & 출력1--'
);
let new2Arr = matrix.filter((arr) => {
  let elSum = 0;
  arr.forEach((el) => {
    elSum += el;
  });
  if (elSum % 2 === 0) {
    return arr;
  }
});
console.log(new2Arr);

console.log(
  '--내부 배열의 원소 합이 짝수인 배열만 모아서 새로운 이차원 배열을 생성 & 출력2--'
);
new2Arr = matrix.filter((arr) => {
  if ((arr[0] + arr[1]) % 2 === 0) {
    return arr;
  }
});
console.log(new2Arr);

console.log(
  '--내부 배열의 원소 합이 짝수인 배열만 모아서 새로운 이차원 배열을 생성 & 출력3--'
);
new2Arr = matrix.filter((arr) => (arr[0] + arr[1]) % 2 === 0);
console.log(new2Arr);
