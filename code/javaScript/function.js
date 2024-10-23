// 2를 곱하는 함수
console.log('-- 2를 곱하는 함수--');
function x2(num) {
  return num * 2;
}
let a = 5;
let b = x2(a);
console.log(b);
// 소수를 판별하는 함수
console.log('-- 소수를 판별하는 함수--');
function checkPrime(num) {
  let prime = true;
  for (let i = 2; i < num; i++) {
    if (num % i === 0) {
      prime = false;
      return prime;
    }
  }
  return prime;
}
let c = 8;
let d = checkPrime(c);
console.log(d);

// 구구단 중 n단을 return하는 함수
console.log('-- 구구단 중 n단을 return하는 함수--');
function nDan(num) {
  let nDan = [];
  for (let i = 1; i <= 9; i++) {
    nDan.push(num * i);
  }
  return nDan;
}
// 구구단 중 몇단까지 보여줄지 return 하는 함수
console.log('-- 구구단 중 n단을 return하는 함수--');
function show_nDan(dan) {
  let show_dan = [];
  for (let i = 1; i <= dan; i++) {
    show_dan.push(nDan(i));
  }
  return show_dan;
}

a = 5;
console.log(nDan(a));
console.log(show_nDan(a));
