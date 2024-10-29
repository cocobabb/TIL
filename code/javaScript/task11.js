let arr = [1, 3, 5, -3, 9, 10, 23, -6, 44, 22, -10, 5, 20];
console.log('--3가지 방법으로 배열의 원소를 출력--');
for (let idx in arr) {
  console.log(arr[idx]);
}
console.log();
for (let i = 0; i < arr.length; i++) {
  console.log(arr[i]);
}
console.log();
arr.forEach((el) => {
  console.log(el);
});

console.log('--배열의 원소를 거꾸로 출력--');
while (arr.length !== 0) {
  let out = arr.pop();
  console.log(out);
}
arr = [1, 3, 5, -3, 9, 10, 23, -6, 44, 22, -10, 5, 20];
console.log('--배열의 원소 중 양수만 출력--');
for (num of arr) {
  if (num > 0) {
    console.log(num);
  }
}

console.log(
  '--배열의 원소 중 양수이면서 짝수인 원소만 모아서 새로운 배열을 만들어서 출력--'
);
const newArr = arr.filter((el) => el > 0 && el % 2 == 0);
console.log(newArr);

console.log('--배열의 모든 원소를 곱한 값을 출력--');
const Num = arr.reduce((acc, cur) => (acc = acc * cur));
console.log(Num);

console.log('--배열의 원소 중 마지막으로 나온 홀수의 값을 출력--');
let last = 0;
arr.forEach((el) => {
  if (el % 2) {
    last = el;
  }
});
console.log(last);
