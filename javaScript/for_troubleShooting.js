// for(변수 in 객체){} 문의 변수가 object(Strin 또는 Symbol타입) 타입으로 인해서 일어나는 상황

const arr = ['a', 'b', 'c'];

for (let index in arr) {
  console.log(index);
  console.log(typeof index); //for문의 index객체 type String
  index = index + 1; // String + int = String >> '0' + 1 = '01'
  console.log(index); //'01'

  index++;
}
console.log();

let idx = '1';
console.log(++idx); // 문자열을 변수에 넣고 증감연산자를 사용하면 자동으로 int형으로 변환된다.

// 객체의 키와 값을 출력하는 반복문 작성
let person = {
  name: '홍길동',
  age: 30,
  job: '개발자',
};

for (let info in person) {
  console.log(`${info}, ${person[info]}`);
}

// for(let info of person){} // person객체는 iterator 을 가지고 있지않아 of를 쓸 수 없다.
// for문의 of는 iterator을 가진 객체(String, Array, Map)의 value를 가져오는 것이기 때문에

let a = Object.values(person); // 객체의 값만을 배열로 돌려줌
console.log(typeof a); // type 확인결과 : object
console.log(a instanceof Array); // a의 타입과 오른쪽의 객체와 타입이 같은지 boolean 형태로 반환됨

Object.keys(person); // 객체의 키값만을 배열로 돌려줌

// 리스트 순서 뒤집기
console.log('--리스트 순서 뒤집기3--');
let nums = [10, 6, 8, 5, 4];
console.log(nums[-1]);
console.log(nums[1]);
reverseNum = [];

for (let n in nums) {
  n = parseInt(n);
  console.log(n);
  console.log(nums[-n - 1]); // JavaScript는 배열의 역순 인덱스를 지원하지 않으므로 nums배열의 값을 찾아올 수 없음
  console.log('----------');
  reverseNum.push(nums[-n - 1]);
  console.log(reverseNum);
}
console.log(reverseNum);
