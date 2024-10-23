// nums가 다음과 같을 때, 구구단 3단을 출력
console.log('--구구단1(while)--');
let nums = [1, 2, 3, 4, 5, 6, 7, 8, 9];
let i = 1;
while (i <= nums.length) {
  console.log(`3 * ${i} = ${3 * i}`); // 변수 문자열로 출력
  console.log('3 *', i, '=', 3 * i); // 변수 숫자형으로 출력
  i++;
}
console.log('--구구단2(for)--');
nums = [1, 2, 3, 4, 5, 6, 7, 8, 9];
for (let i = 1; i <= nums.length; i++) {
  console.log('3 *', i, '=', 3 * i); // 변수 숫자형으로 출력
}

// 출석번호를 포함하여 '1번 jun', ..., '4번 lynda'의 형태로 출석
console.log('--출석1(while)--');
let names = ['jun', 'beemo', 'ken', 'lynda'];
let num = 0;
while (num < names.length) {
  console.log(`${num + 1}번 ${names[num]}`); // 변수 문자열로 출력
  console.log(num + 1, '번', names[num]); // 변수 숫자형으로 출력
  num++;
}
console.log('--출석2(for)--');
names = ['jun', 'beemo', 'ken', 'lynda'];
for (let num = 0; num < names.length; num++) {
  console.log(num + 1, '번', names[num]); // 변수 숫자형으로 출력
}
// "00살 이름" 형태로 출력
console.log('--00살 이름--');
names = ['jun', 'beemo', 'ken'];
const ages = [18, 28, 37];
let idx = 0;
while (true) {
  console.log(`${ages[idx]}살 ${names[idx]}`); // 변수 문자열로 출력
  console.log(ages[idx], '살', names[idx]); // 변수 숫자형으로 출력
  idx++;
  if (idx >= names.length) break;
}
''
// 주어진 리스트의 합계를 계산
nums = [1, 2, 3, 4, 5, 6, 7, 8, 9];
console.log('-리스트 합계--');
let sum = 0;
let n = 0;
while (true) {
  if (n >= nums.length) break;
  sum += nums[n];
  n++;
}
console.log(sum);
