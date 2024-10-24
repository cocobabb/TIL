
: 일반적으로 오류(예외)가 발생하면 프로그램이 종료되지만 **예외처리를 통해 프로그램 종료 대신 적절한 대처 시행**

```Javascript
try {
  // 오류가 발생할 가능성이 있는 코드
} catch (error) {
  // 오류가 발생했을 때 실행되는 코드
} finally {
  // 오류 발생과 상관없이 무조건 실행되는 코드
}
```
### 예외 강제 발생시키기
+ **`throw` 키워드**를 사용해 예외 강제로 발생 가능
+ **사용자가 정의한 예외를 만들 때 활용**

```Javascript
// 예외 객체 Error에 throw 키워드를 사용해 예외 강제 발생
function plusone(num) {
    if (typeof num !== 'number') {
        throw new Error('숫자가 아닙니다.');
    }
    console.log(num + 1);
}

try {
    plusone('문자열'); // Error 발생
} catch (error) {
    console.error(error.message); // 숫자가 아닙니다.
}
```

















