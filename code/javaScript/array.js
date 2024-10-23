const { sum } = require('lodash');

const nums = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9],
];
//  1~9 순서대로 출력
console.log('--1~9 순서대로 출력1--');
for (let i = 0; i < nums.length; i++) {
  for (let j = 0; j < nums[i].length; j++) {
    console.log(nums[i][j]);
  }
}
console.log('--1~9 순서대로 출력2--');
for (let arr1 of nums) {
  for (let arr2 of arr1) {
    console.log(arr2);
  }
}
console.log('--1~9 순서대로 출력3--');
for (let i in nums) {
  for (let j in nums[i]) {
    console.log(nums[i][j]);
  }
}

// 행들의 합의 값으로 리스트를 만드세요
console.log('-- 행들의 합의 값으로 리스트1--');
let columSum = 0;
let sumList = [];
for (let arr1 of nums) {
  columSum = 0;
  for (let columEl of arr1) {
    columSum += columEl;
  }
  sumList.push(columSum);
}
console.log(sumList);
console.log('-- 행들의 합의 값으로 리스트2--');
columSum = 0;
sumList = [];

for (let i = 0; i < nums.length; i++) {
  columSum = 0;
  for (let j = 0; j < nums[i].length; j++) {
    columSum += nums[i][j];
  }
  sumList.push(columSum);
}
console.log(sumList);

// 모든 원소들의 합
console.log('-- 모든 원소들의 합1--');
let elSum = 0;
sumList = [];
for (let i = 0; i < nums.length; i++) {
  for (let j = 0; j < nums[i].length; j++) {
    elSum += nums[i][j];
    sumList.push(elSum);
  }
}
console.log(elSum);

// 열들의 합의 값으로 리스트
console.log('--열들의 합의 값으로 리스트--');
let rowSum = 0;
sumList = [];
// 중요 포인트 : 같은 열끼리 묶으면 *뒤에 인덱스끼리 같고* 앞에 인덱스 1씩 증가
// nums[0][0]
// nums[0][1]
// nums[0][2]
// nums[1][0]
// nums[1][1]
// nums[1][2]
// nums[2][0]
// nums[2][1]
// nums[2][2]

// nums[0][0]
// nums[1][0]
// nums[2][0]

// nums[0][1]
// nums[1][1]
// nums[2][1]

// nums[0][2]
// nums[1][2]
// nums[2][2]

for (let j = 0; j < nums[0].length; j++) {
  rowSum = 0;
  for (let i in nums) {
    rowSum += nums[i][j];
  }
  sumList.push(rowSum);
}
console.log(sumList);

// 구구단이 들어있는 2차원 배열
// n*m 단이 들어있는 2차원 배열을 만드시오.
console.log('--구구단이 들어있는 2차원 배열--');
const n = 3;
const m = 4;
let gugudan = [];

for (let i = 1; i <= n; i++) {
  let columdan = [];
  // console.log(`i:${i}`);
  for (let j = 1; j <= m; j++) {
    // console.log(`j: ${j}`);
    columdan.push(i * j);
  }
  gugudan.push(columdan);
}
console.log(gugudan);

