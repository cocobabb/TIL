console.log('--1부터 N까지 출력--');
let N = 5;
console.log(N);
for (let i = 1; i <= N; i++) {
  console.log(i);
}
console.log('--1부터 N까지 출력2--');
N = 5;
console.log(N);
let i = 1;
while (i <= N) {
  console.log(i);
  i++;
}
console.log('--1부터 N까지 합--');
N = 5;
let total = 0;
console.log(N);
for (let i = 1; i <= N; i++) {
  total += i;
}
console.log(total);
console.log('--짝수의 합--');
N = 5;
total = 0;
console.log(N);
for (let i = 1; i <= N; i++) {
  if (i % 2 === 0) {
    total += i;
  }
}
console.log(total);
console.log('--짝수의 개수--');
N = 5;
let cnt;
for (let i = 1; i <= N; i++) {
  if (i % 2 === 0) {
    cnt++;
  }
}
console.log(cnt);
// 배열의 원소를 출력하는 반복문
// - 원소가 짝수라면 원소를 출력하지 않고, 반복문을 즉시 종료
console.log('--반복문 제어--');
let arr = [1, 9, 3, 11, 4, 5, 2, 7];
for (let num of arr) {
  if (num % 2 === 0) break;
  console.log(num);
}
// 아래 객체 정보를 기반으로 생성한 객체 3개를 변수 todos 에 추가
console.log('--객체와 배열1--');
let todos = [];
let ob1 = {
  todoId: 1,
  content: '예습하기',
  isCompleted: false,
};
let ob2 = {
  todoId: 2,
  content: '강의듣기',
  isCompleted: false,
};
let ob3 = {
  todoId: 3,
  content: '복습하기',
  isCompleted: false,
};
todos = [ob1, ob2, ob3];
console.log(todos);

// todos배열에 저장된 객체의 키 content 와 isCompleted 의 값을
// 출력하는 반복문을 작성
console.log('--객체와 배열2--');
for (let ob of todos) {
  console.log(`content: ${ob.content}, isCompleted:${ob.isCompleted}`);
}
console.log('--객체와 배열3--');
// todos배열에 저장된 객체를 순회하는 반복문을 작성
// 키 todoId 의 값이 2 인 객체를 찾아서 출력하는 조건문을 작성
for (let ob of todos) {
  if (ob.todoId === 2) {
    console.log(ob);
  }
}
console.log('--객체와 배열4--');
// 배열에 저장된 객체를 순회하는 반복문을 작성
// 키 todoId 의 값이 2 인 객체의
// 키 isCompleted 의 값을 true 로 수정하는 조건문을 작성
// 변수 todos 를 출력
for (let ob of todos) {
  if (ob.todoId === 2) {
    ob.isCompleted = true;
  }
}
console.log(todos);
