let nums = [1, 2, 3, 4, 5, 6, 7, 8, 9];
// 구구단 방법1(for문으로 object로 value 뽑아냄)
console.log('--구구단 방법1--');
for (let idx in nums) {
  const num = nums[idx]; //각 스코프 안에 있기 때문에, 각 스코프 안에 상수값이므로 에러 나지 않음
  console.log(`3 * ${num} = ${3 * num}`);
}
console.log('--구구단 방법2--');
// 구구단 방법2(for문으로 value 바로 뽑아냄)
for (let num of nums) {
  console.log(`3 * ${num} = ${3 * num}`);
}
console.log();
let names = ['jun', 'beemo', 'ken', 'lynda'];
console.log();

console.log('--출석 방법1--');
for (i = 0; i < 4; i++) {
  console.log(`${i + 1}번 ${names[i]}`);
}
console.log('--출석 방법2--');
for (let ob in names) {
  console.log(ob);
  // console.log(names[ob]);

  let name = names[ob];
  ob++; // 증감연산자를 쓰면 자동적으로 int형으로 인식됨
  // ob = ob + 1; // ob는 object(String or symbol)이므로 문자열+문자열 형태로 인식됨
  // ob+=1 //위와 같은 이유
  console.log(ob, name);
}

console.log();
names = ['jun', 'beemo', 'ken'];
const ages = [18, 28, 37];
console.log('--나이랑 이름 방법1--');
for (let ob in names) {
  let name = names[ob];
  let age = ages[ob];

  console.log(`${age}살 ${name}`);
}

console.log('--나이랑 이름 방법2--');
for (i = 0; i < 3; i++) {
  console.log(`${ages[i]}살 ${names[i]}`);
}

console.log();
console.log();
//리스트 길이 구하기
console.log('--리스트 길이 구하기--');
names = ['jun', 'beemo', 'ken', 'lynda'];
let length = 0;
for (name in names) {
  length++;
}
console.log(length);

// 리스트 합계 계산
console.log('--리스트 합계 계산--');
nums = [1, 2, 3, 4, 5, 6, 7, 8, 9];
let sum = 0;
for (n in nums) {
  sum += nums[n];
}
console.log(sum);

// 리스트에서 최소값 찾기
nums = [10, 6, 8, 5, 4, 2, 3, 11];
console.log('--리스트에서 최소값 방법1--');
let min = 0;
for (n in nums) {
  n = parseInt(n);
  if (n >= 2) {
    if (min > nums[n + 1]) {
      min = nums[n + 1];
    } else if (min < nums[n + 1]) {
      min = min;
    }
  } else {
    if (nums[n] > nums[n + 1]) {
      min = nums[n + 1];
    } else if (nums[n] < nums[n + 1]) {
      min = nums[n];
    }
  }
}
console.log(min);
console.log('--리스트에서 최소값 방법2--');
min = Infinity; // 첫번째 인덱스와 값 비교하기 위해 무한수 변수 생성
for (n of nums) {
  if (min > n) {
    min = n;
  }
}
console.log(min);

//리스트 순서 뒤집기
console.log('--리스트 순서 뒤집기1--');
nums = [10, 6, 8, 5, 4];
let reverseNum = [];
for (let n in nums) {
  reverseNum.unshift(nums[n]);
}
console.log(reverseNum);

console.log('--리스트 순서 뒤집기2--');
reverseNum = [];
for (let n in nums) {
  // 뒤에 인덱스부터 출력하는 새로운 인덱스를 만들기
  let newIdx = nums.length - 1 - n;

  // 거꾸로 인덱스 넣은 새로운 인덱스로 값 차례로 넣기
  reverseNum.push(nums[newIdx]);
}
console.log(reverseNum);
