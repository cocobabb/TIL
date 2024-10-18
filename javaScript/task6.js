let number_1 = 5;
console.log(number_1);
if (number_1 < 10) {
  console.log(`number_1은 ${10}보다 작다`);
} else {
  console.log(number_1);
}
console.log();

number_1 = 6;
console.log(number_1);
if (number_1 % 2 == 0) {
  console.log('짝수');
} else {
  console.log(number_1);
}
console.log();

const variable = 5;
console.log(variable);
if (typeof variable === 'number') {
  console.log('숫자형');
}
console.log();

number_1 = 7;
console.log(number_1);
if (number_1 < 10) {
  console.log('number_1은 10보다 작다.');
} else if (number_1 > 10) {
  console.log('number_1은 10보다 크다.');
} else {
  console.log(number_1);
}
console.log();

const score = 70;
if (score >= 60) {
  console.log(score);
  console.log('합격');
} else if (score < 60) {
  console.log(score);
  console.log('불합격');
}
console.log();

number_1 = 5;
console.log(number_1);
if (number_1 < 10) {
  console.log(number_1);
  console.log('number_1은 10보다 작다.');
} else if (number_1 > 10) {
  console.log(number_1);
  console.log('number_1은 10보다 크다.');
} else if (number_1 === 10) {
  console.log(number_1);
  console.log('number_1은 10이다.');
}
console.log();

number_1 = 6;
console.log(number_1);
if (typeof number_1 === 'number') {
  if (number_1 < 10) {
    console.log(number_1);
    console.log('number_1은 10보다 작다.');
  } else if (number_1 > 10) {
    console.log(number_1);
    console.log('number_1은 10보다 크다.');
  } else if (number_1 === 10) {
    console.log(number_1);
    console.log('number_1은 10이다.');
  }
} else {
  console.log('숫자가 아니다.');
}
console.log();

number_1 = 7;
console.log(number_1);
if (number_1 === 0) {
  console.log(number_1);
  console.log('영');
} else if (number_1 % 2 === 0) {
  console.log(number_1);
  console.log('짝수');
} else if (number_1 % 2 != 0) {
  console.log(number_1);
  console.log('홀수');
}
console.log();

let username = 'monkey';
let password = 'monkey1234';
if (username === 'monkey' && password === 'monkey1234') {
  console.log(username);
  console.log(password);
  console.log('로그인 성공');
} else if (username != 'monkey' && password != 'monkey1234') {
  console.log(username);
  console.log(password);
  console.log('로그인 실패');
}
console.log();

number_1 = 6;
let number_2 = 4;
console.log(number_1);
console.log(number_2);

if (number_1 === number_2) {
  console.log(number_1);
  console.log(number_2);
  console.log('같다');
} else {
  console.log(number_1);
  console.log(number_2);
  console.log('같지 않다');
}
console.log();

number_1 = 62;
if (number_1 % 2 === 0 && number_1 % 3 === 0) {
  console.log(number_1);
  console.log('6의 배수');
} else if (number_1 % 2 === 0 && number_1 % 3 != 0) {
  console.log(number_1);
  console.log('2의 배수');
} else if (number_1 % 2 != 0 && number_1 % 3 === 0) {
  console.log(number_1);
  console.log('3의 배수');
} else {
  console.log('2의 배수도 아니고, 3의 배수도 아니다');
}
