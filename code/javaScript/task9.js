// 더하기 함수
console.log('--더하기 함수--');
function add(x1, x2) {
  console.log(x1);
  console.log(x2);

  let add = x1 + x2;
  return add;
}
let a = 1;
let b = 2;
console.log(add(a, b));

// 크기 비교 함수
console.log('--크기 비교 함수--');
let compare = function (x1, x2) {
  let compare;
  if (x1 > x2) {
    compare = console.log(`x1: ${x1}`);
  } else if (x1 < x2) {
    compare = console.log(`x2: ${x2}`);
  } else if (x1 === x2) {
    compare = console.log(null);
  }
  return compare;
};
a = 3;
b = 3;
console.log(a);
console.log(b);
compare(a, b);

console.log('--양수, 음수, 0--');
// - 아래와 같은 기능을 수행하는 함수 `determine` 를 정의한다.
//     - 1개의 매개변수 `x` 를 입력 받는다.
//     - `x` 가 어떤 수 인지 판별하는 조건문을 작성한다.
//         - 양수라면 `1` 을 반환한다.
//         - 음수라면 `-1` 을 반환한다.
//         - 0이라면 `0` 을 반환한다.
// - 임의의 변수를 선언하고, 숫자형 값을 할당한다.
// - 변수를 출력한다.
// - 함수 `determine` 를 호출해서 변수가 어떤 수 인지 구하고, 출력한다.
const determine = (x) => {
  if (x > 0) {
    return 1;
  } else if (x < 0) {
    return -1;
  } else if (x === 0) {
    return 0;
  }
};
a = 0;
console.log(determine(a));
console.log('--가장 큰 값--');

// - 배열에서 가장 큰 값을 찾는 함수 `maxNumber` 를 정의한다.
//     - 1개의 매개변수 `arr` 를 입력 받는다.
//     - 가장 큰 값을 저장할 변수 `max` 를 선언하고, `-Infinity` 를 할당한다.
//     - 변수 `arr` 를 순회하는 반복문을 작성한다.
//         - 원소가 `max` 보다 크면 `max` 를 갱신한다.
//     - 변수 `max` 를 반환한다.
// - 임의의 변수를 선언하고 숫자형 값 5개를 저장한 배열을 생성해서 할당한다.
// - 변수를 출력한다.
// - 함수 `maxNumber` 를 호출해서 배열에서 가장 큰 수를 구하고, 출력한다.
const maxNumber = (arr) => {
  let max = -Infinity;
  for (let v of arr) {
    if (v > max) {
      max = v;
    }
  }
  return max;
};
const arr = [1, 2, 3, 4, 5];
console.log(arr);
console.log(maxNumber(arr));

console.log('--가장 작은 값--');
const minNumber = (arr) => {
  let min = Infinity;
  for (let v of arr) {
    if (v < min) {
      min = v;
    }
  }
  return min;
};
const minArr = [1, 2, 3, 4, 5];
console.log(minArr);
console.log(minNumber(minArr));

console.log('--짝수--');
// - 배열에서 짝수인 값을 찾는 함수 `evenNumber` 를 정의한다.
//     - 1개의 매개변수 `arr` 를 입력 받는다.
//     - 변수 `new_arr` 를 선언하고, 빈 배열을 할당한다.
//     - 변수 `arr` 를 순회하는 반복문을 작성한다.
//         - 원소가 짝수면 변수 `new_arr` 에 추가한다.
//     - 변수 `new_arr` 를 반환한다.
// - 임의의 변수를 선언하고 숫자형 값 5개를 저장한 배열을 생성해서 할당한다.
// - 변수를 출력한다.
// - 함수 `evenNumber` 를 호출해서 짝수만 저장된 배열을 구하고, 출력한다.
const evenNumber = function (arr) {
  new_arr = [];
  for (let v of arr) {
    if (v % 2 === 0) {
      new_arr.push(v);
    }
  }
  return new_arr;
};
const evenArr = [1, 2, 3, 4, 5];
console.log(evenArr);
console.log(evenNumber(evenArr));
