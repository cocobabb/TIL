// 원소를 출력하는 반복문을 작성
console.log('--반복문 이용하여 원소출력--');
let arr = [1, 2, 3, 4, 5];

for (let i of arr) {
  console.log(i);
}
console.log();

// 원소의 제곱을 출력하는 반복문 작성
console.log('--원소의 제곱을 출력하는 반복문--');
for (let i of arr) {
  console.log(i * i);
}
console.log();

// 원소가 짝수면 출력하는 조건문과 반복문을 작성
console.log('--원소가 짝수면 출력하는 조건문과 반복문--');
for (let i of arr) {
  if (i % 2 === 0) {
    console.log(i);
  }
}
console.log();

// 객체의 키와 값을 출력하는 반복문 작성
let person = {
  name: '홍길동',
  age: 30,
  job: '개발자',
};

for (let info in person) {
  console.log(`${info}, ${person[info]}`);
}

