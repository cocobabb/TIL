//  10미만의 2의 배수 출력하기
let num = 2;
console.log('--방법1--');
while (num < 10) {
  console.log(num);
  num += 2;
}

num = 2;
console.log('--방법2--');
while (true) {
  console.log(num);
  num += 2;

  // 10일 때 멈추기
  if (num === 10) {
    break; // 반복문 끝내는 제어어
  }
}

// arr가 텅 빌 때까지 el 출력
console.log('--배열의 요소가 텅 빌 때까지 하나씩 출력--');
const arr = [2, 3, 5, 1, 3];
// 앞에나 뒤에서 하나씩 el를 제거
// 하는 것을 반복

while (arr.length !== 0) {
  let el = arr.pop();
  console.log(el);
}
while (arr.length) {
  //arr.length === 0 >> false 처리됨
  let el = arr.pop();
  console.log(el);
}
