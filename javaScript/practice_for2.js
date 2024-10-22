// 1. 40 이하의 3의 배수를 출력하시오(3단의 확장).

// 1 ~ 100 중에 7의 배수의 개수를 출력하세요.
console.log('--7의배수의 갯수(1~100)--');
let cnt = 0; // 7의 갯수
for (let i = 1; i <= 100; i++) {
  if (i % 7) continue;
  cnt++;
}
console.log(cnt);

// 원소가  1, 4, 5, 7인 경우를 제외하고 출력하세요
const arr = [1, 2, 4, 3, 3, 5, 5, 6, 9, 7];
console.log('--원소가  1, 4, 5, 7인 경우를 제외하고 출력1--');
const arr2 = [1, 4, 5, 7];
for (let num of arr) {
  let matchChecking = false;

  for (let num2 of arr2) {
    if (num2 === num) {
      matchChecking = true;
      break; // arr 원소와 arr2 원소가 일치하면 비교하는 for문 끝내기
    }
  }
  if (matchChecking) continue; // arr 원소와 arr2 원소가 일치하면 다음 arr 다음 원소로 넘겨줘
  console.log(num);
}
console.log('--원소가  1, 4, 5, 7인 경우를 제외하고 출력2--');
let setNum = new Set([1, 4, 5, 7]); //해당 원소가 들어있는 set을 생성
for (let num of arr) {
  if (setNum.has(num)) continue;

  console.log(num);
}
// 1 ~ 9 까지의 자연수 중 제곱한 수가
// 10 이상 50 이하인 자연수의 리스트를 출력해보세요.
console.log('--제곱한 수가 10 이상 50 이하인 자연수의 리스트를 출력--');
nnArr = [];
for (let num = 1; num <= 9; num++) {
  let nn = num ** 2;

  if (nn >= 10 && nn <= 50) {
    nnArr.push(num);
  }
}
console.log(nnArr);

//  두개의 숫자에 대해. 두 수 사이에 속한 모든 정수의 합을 구하시오.
//  (ex. 2와 5를 입력받는다면 2 + 3 + 4 + 5 = 14)
console.log('--두 수 사이 수들의 합--');
let num1 = 2;
let num2 = 2;
if (num1 > num2) {
  let tmp = num1;
  num1 = num2;
  num2 = tmp;
}
let sum = 0;
for (let i = num1; i <= num2; i++) {
  sum += i;
}
console.log(sum);

// 2의 배수 혹은 3의 배수를 제외하고 1~30까지 숫자를 출력하시오
console.log('-- 2의 배수 혹은 3의 배수를 제외하고 1~30까지 숫자를 출력1--');
for (let num = 1; num <= 30; num++) {
  if (num % 2 != 0 && num % 3 != 0) {
    console.log(num);
  }
}
console.log('-- 2의 배수 혹은 3의 배수를 제외하고 1~30까지 숫자를 출력2--');
for (let num = 1; num <= 30; num++) {
  if (num % 2 === 0 || num % 3 === 0) continue;
  console.log(num);
}
console.log('-- 2의 배수 혹은 3의 배수를 제외하고 1~30까지 숫자를 출력3--');
for (let num = 1; num <= 30; num++) {
  if (!(num % 2)) continue;
  if (!(num % 3)) continue;
  console.log(num);
}
console.log('-- 2의 배수 혹은 3의 배수를 제외하고 1~30까지 숫자를 출력4--');
for (let num = 1; num <= 30; num++) {
  if (!(num % 2) || !(num % 3)) continue;
  console.log(num);
}
// 자연수 n이 주어졌을 때, n이 소수인지 판단
console.log('--n이 소수인지 판단--');
// 중요 포인트: n과 1이 아닌 어떠한 수로 나눠진다면 그것은 소수가 아니다
const n = 1;
let prime = true;
for (let num = 2; num < n; num++) {
  if (n % num === 0) {
    prime = false;
    break;
  }
}
console.log(n, prime);
let people = [
  {
    name: 'jun',
    age: 15,
    gender: 'M',
  },
  {
    name: 'ken',
    age: 26,
    gender: 'F',
  },
  {
    name: 'alex',
    age: 37,
    gender: null,
  },
];
// - 사람에 대한 정보를 각각 출력하시오(형식은 자유롭게)
console.log('--사람의 대한 정보 각각 출력--');
for (let p of people) {
  console.log(p);
}
// - 이름이 alex인 사람에 대한 정보를 출력하시오
console.log('--alex인 사람에 대한 정보를 출력--');
for (let p in people) {
  let person = people[p];
  if (person.name === 'alex') {
    console.log(person);
    break;
  }
}
// - 이름이 alex인 사람의 나이를 출력하시오
console.log('--alex인 사람의 나이를 출력 출력--');
for (let person of people) {
  if (person.name === 'alex') {
    console.log(person.age);
  }
}

// - 이름을 활용하여 각 사람의 데이터에 쉽게 접근할 수 있도록
//  people 변수를 수정하시오.
let modifyPeople = {};
// let jun = {};
// let ken = {};
// let alex = {};

for (person of people) {
  modifyPeople[person.name] = person;
}
// modifyPeople['jun'] = person; // 객체에 키값 할당해서 값 넣는 법
// modifyPeople = { jun, ken, alex };
console.log(modifyPeople);
