console.log("--const newArr1 = [1, 4, 9, 16, 25]만들기--");
const arr1 = [1, 2, 3, 4, 5];

let num = Infinity;
const newArr1 = arr1.map((el) => el * el);
console.log(newArr1);

console.log("--const newArr2 = [1, 2, 3, 4, 5] 만들기--");
const arr2 = ["1", "2", "3", "4", "5"];
const newArr2 = arr2.map((el) => parseInt(el));
console.log(newArr2);

console.log("--const newArr3 = [18, 28, 38] 만들기--");
const arr3 = [
  {
    name: "jun",
    age: 18,
  },
  {
    name: "alex",
    age: 28,
  },
  {
    name: "ken",
    age: 38,
  },
];
const newArr3 = arr3.map((el) => el.age);
console.log(newArr3);

console.log("--짝수이면서 5이상인 숫자만 들어있는 array--");
const arr4 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
const newArr4 = arr4.filter((el) => el % 2 == 0 && el > 5);
console.log(newArr4);

const arr5 = [
  {
    name: "jun",
    age: 18,
  },
  {
    name: "alex",
    age: 28,
  },
  {
    name: "ken",
    age: 38,
  },
  {
    name: "beemo",
    age: 48,
  },
  {
    name: "lynda",
    age: 8,
  },
];

console.log("-- age가 30 이하인 사람들의 정보가 담긴 array--");
const newArr5 = arr5.filter((el) => el.age <= 30);
console.log(newArr5);

// const newArr6 = arr5.filter((el) => el.age <= 30);
console.log("--age가 30 이하인 사람들의 이름이 담긴 array--");
const newArr6 = arr5.filter((el) => el.age <= 30).map((ob) => ob.name);
console.log(newArr6);
// const newArr7 = newArr6.map((el) => el.name);
// console.log(newArr7);
