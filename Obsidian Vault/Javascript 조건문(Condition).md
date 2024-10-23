
+ if 
	: 조건식이 참(true)일 때 코드 블록을 실행
+ else 
	:조건식이 거짓(false)일 때 코드 블록을 실행
+ else if 
	:조건식을 위에서 하나씩 평가하며 **참인 조건식이 있다면 다른 조건식은 평가하지 않음**
+ **삼항 연산자**
	: **조건식 결과에 따라 값을 선택**
	**{ 조건식 } ? { 참일 때 값 또는 표현식 } : { 거짓일 때 값 또는 표현식 };**
```Javascript
let x = 7;

let result = x % 2 === 0 ? '짝수' : '홀수';
console.log(`${x}는 ${result}입니다.`);
// 조건식 결과가 true면 짝수 false면 홀수 출력됨
```
+ **switch**
	: 표현식을 각 case 값과 비교하여 일치하는 case코드를 실행
		+ **break** : 해당 명령어를 만나면 switch문 빠져나감. 없으면 순차적으로 다음 case 실행됨
		+ default : 표현식과 상관없이 switch문에서 기본적으로 실행되는 코드
```Javascript
switch (표현식) {
  case 값1:
    // 코드
    break;
  case 값2:
    // 코드
    break;
  default:
    // 기본 코드
}
```
