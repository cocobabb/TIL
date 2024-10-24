// strNumbers => numNumbers로 바꾸어 새로운 변수에 할당
const strNumbers = ['1', '2', '3', '4'];
let numNumbers = [];

function changeInt(str) {
  str = parseInt(str);
  return str;
}
console.log('--for문 통해 변환--');
for (let strNum of strNumbers) {
  numNumbers.push(changeInt(strNum));
}
console.log(strNumbers);
console.log(numNumbers);

console.log('--map 통해 변환--');
// map 적용한 객체의 요소에 대해 콜백 함수를 시행하고 반환값을 모아 배열을 만듦
numNumbers = strNumbers.map((str) => parseInt(str));
console.log(strNumbers);
console.log(numNumbers);

console.log('--가장 작은 값 reduce 통해 계산하기1--');
// reduce는 적용한 객체의 요소를 가져와
// 처음에는 초기값과 연산 후 값을 반환하고
// 2번째부터는 반환된 값과 다음 요소값을 연산하여 값을 반환
// 위와 같은 과정을 요소가 없을 때까지 반복
const numbers = [5, 8, 2, 5, 9, 4];
const minValue = numbers.reduce((acc, cur) => {
  if (acc < cur) {
    cur = acc;
  }
  return cur;
});
console.log(minValue);
console.log('--가장 작은 값 reduce 통해 계산하기2--');
const minValue2 = numbers.reduce(
  (acc, cur) => (acc > cur ? cur : acc),
  Infinity
);
console.log(minValue);

console.log('--filter를 통해 소수만 모아보기--');
// filter를 적용한 객체의 요소에 대해 콜백 함수의 반환값이 true인 요소만 모아 배열 만듦
const nums = [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13];
const primeArr = nums.filter((num) => {
  let isPrime = true;
  for (let i = 2; i < num; i++) {
    if (num % i === 0) {
      isPrime = false;
      return isPrime;
    }
  }
  return isPrime;
});
console.log(primeArr);
