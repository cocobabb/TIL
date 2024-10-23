let let_variable = 'Hello World';
const const_variable = 'Hello World';
console.log('let_variable: ' + let_variable);
console.log('const_variable: ' + const_variable);
console.log();

const number_variable = 1;
const string_variable = '1';
console.log('number_variable type: ' + typeof number_variable);
console.log('string_variable type: ' + typeof string_variable);
console.log();

let variable = '상수형 변수에는 재할당 할 수 없다.';
variable = '재할당';
console.log(variable);
console.log();

const name = '정우영';
const hello = `안녕하세요.${name} 입니다.`;
console.log(hello);
console.log();

let number1 = 100;
let number2 = 200;
console.log(`덧셈: ${number1 + number2}`);
console.log(`뺄셈: ${number1 - number2}`);
console.log(`곱셈: ${number1 * number2}`);
console.log(`나눗셈: ${number1 / number2}`);

// ,(콤마 연산자) :  콘솔 연산자로 각 인자가 콤마로 구분되고
// 문자열의 경우 - 각각의 인자의 사이에 공백이 하나 추가되어 하나의 문자열로 합쳐짐
// 숫자의 경우 - template literals와 달리 합쳐져도 그대로 number 타입을 유지함
console.log('덧셈:', number1 + number2);
console.log('뺄셈:', number1 - number2);
console.log('곱셈:', number1 * number2);
console.log('나눗셈:', number1 / number2);
console.log();

number1 = 8;
number2 = 3;
console.log(`number1을 2로 나눈 나머지: ${number1 % 2}`);
console.log('number2을 2로 나눈 나머지:', number2 % 2);
console.log();

const number_arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
console.log(number_arr[0]);
console.log(number_arr[2]);
console.log(number_arr[8]);
console.log(number_arr[9]);
console.log();

const arr = [];
arr.push(10);
arr.push(20);
arr.push(30);
arr.push(40);
arr.push(50);
console.log();

let todo = {
  userId: 1,
  id: 1,
  title: 'delectus aut autem',
  completed: false,
};
console.log(todo.userId);
console.log(todo.id);
console.log(todo.title);
console.log(todo.completed);
console.log();

const person = {
  name: '정우영',
  age: 20,
  city: '서울',
  location: '성동',
  language: 'HTML,CSS,JavaScript',
};
console.log(person);
