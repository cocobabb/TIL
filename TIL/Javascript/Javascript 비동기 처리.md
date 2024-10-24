#### 동기적(Synchronous) 구조
: 코드가 **실행이 끝나면 다음 코드가 실행**되는 구조

#### 비동기적(ASynchronous) 구조
: 코드가 **실행되는 동안 다른 코드가 실행**되는 구조


#### Javascript
+ **싱글 스레드** 기반 동기적 처리
	single thread : 한번에 하나의 작업만 처리하는 구조
+ 여러 작업 동시에 처리할 수 없음
+ 위와 같은 이유로 **네트워크 요청 같은** 시간이 
	**오래 걸리는 작업은 비동기**로 처리

### 콜백 지옥
: **비동기 작업을 처리하는 콜백 함수가 중첩**되어 
코드의 가독성이 떨어지는 상태
```Javascript
asyncTask1(function(result1) {
    asyncTask2(result1, function(result2) {
        asyncTask3(result2, function(result3) {
            asyncTask4(result3, function(result4) {
                console.log(result4);
            });
        });
    });
});
```
### Promise
: 비동기 작업에 대한 성공과 실패를 처리하는 문법으로
콜백 지옥을 방지하기 위한 방법 중 하나

1. `new Promise()`로 Promise 객체 생성
2.  `Promise()`에 두 함수(resolve, reject)를 인자를 전달 받음
	+ **`resolve`** : 비동기 작업이 성공했을 때 호출되는 함수.
	+ **`reject`** : 비동기 작업이 실패했을 때 호출되는 함수
3. 
+ **`then()`** : `resolve(값)` 함수가 호출되었을 때 실행할 코드. 값을 인자로 받음
- **`catch()`** : `reject(값)` 함수가 호출되었을 때 실행할 코드. 값을 인자로 받음
- **`finally()`** : 성공 여부에 상관없이 작업이 완료된 후 실행할 코드

```Javascript
const newPromise = new Promise((resolve, reject) => {
  const flag = true;

  if (flag === true) {
    resolve('작업 성공');
  } else {
    reject('작업 실패');
  }
});

newPromise
  .then((result) => {
    console.log(result);
  })
  .catch((error) => {
    console.error(error);
  })
  .finally(() => {
    console.log('작업 완료');
  });

```

##### fetch(url)
: 네트워크 요청을 처리하는 비동기 함수. `Promise`를 반환
```Javascript
const url = 'https://jsonplaceholder.typicode.com/todos/1';

const data = fetch(url)
    .then((response) => {
        // 네트워크 요청 결과 데이터를 JSON 구조로 변환 후 반환
        return response.json();
    })
    .then((json) => {
        // JSON 구조로 변환된 데이터 처리
        console.log(json);
    })
    .catch((error) => {
        console.log(error);
    });

// { userId: 1, id: 1, title: 'delectus aut autem', completed: false }
```

##### async / await
: `Promise` 를 더 쉽고 직관적으로 사용할 수 있는 키워드
```Javascript
async function newPromise() {
    const flag = true;

    if (flag == true) {
        return '작업 성공'; // Promise 객체를 반환한다.
    }
}

// newPromise() 함수는 Promise를 반환하기 때문에 then() 메서드를 사용할 수 있다.
newPromise().then((result) => {
    console.log(result);
});
```
 - async 키워드
	 : 함수 앞에 붙을 수 있으며 **해당 함수의 반환값은 Promise** 가 됨
- await 키워드
	: **`async` 함수 안**에서 사용하고 비동기 작업이 끝날 때까지
	 함수 동작을 멈추고, **비동기 작업의 완료를 기다림**
 -  예외 처리 .catch() 가 필요할 때에는 try...catch 문을 사용
 
```Javascript
async function fetchUrl(url) {
    try {
        const response = await fetch(url);
        const data = await response.json();

        console.log(data);
    } catch (error) {
        // 비동기 처리 중 오류 발생 시 실행
        console.error('오류 발생');
        console.error(error);
    }
}
const url = 'https://undefined.com/';

fetchUrl(url);
```

### 비동기 처리 메커니즘

#### JavaSciprt 런타임 환경

- JavaScript 코드가 실행되는 아래 환경으로 구성 되어있다.
    - **콜 스택(Call Stack)**
    - **콜백 큐(Callback Queue)** 또는 **이벤트 큐(Event Queue)** 또는 **테스크 큐(Task Queue)**
    - **이벤트 루프(Event Loop)**
    - **Web APIs**
    
- 콜 스택
    - 호출된 함수가 동기적으로 실행되는 메모리 공간
    - 하나만 존재하기 때문에 한 번에 하나의 작업만 처리할 수 있다.

- 콜백 큐
    - 비동기 작업(타이머, 네트워크 요청 등)이 완료된 후 **실행을 기다리는 콜백 함수가 저장**되는 메모리 공간
    - **콜 스택이 비어있을 때** 이벤트 큐에 있는 콜백 함수가 **콜 스택으로 이동 후 실행**된다.

- 이벤트 루프
    - 콜백 큐에 있는 **함수를 콜 스택으로 이동**시키는 작업을 한다.
    - 위 작업을 지속적으로 수행해서 비동기 작업을 처리한다.

- Web APIs
    - 웹 브라우저(Chrome, Edge 등)에 의해 처리되는 비동기 작업 도구가 모여있다.
    - 콜백 함수를 **비동기로 처리 하고**, 처리가 끝나면 콜백 함수를 **이벤트 큐로 전달**한다.
    - **멀티 스레드 환경**이기 때문에 백그라운드에서 콜백 함수를 비동기로 처리할 수 있다. 
	    멀티 스레드(multi thread)
	     :한 번에 여러개(multi**)**의 작업을 처리하는 구조
    - **실질적으로 콜백 함수의 비동기 작업을 처리**하는 파트이다.
    - 기능 예시
        - Fetch : 네트워크 요청 처리
        - Geolocation API : 위치 정보 처리
        - setTimeout : 일정 시간 후 콜백 함수 실행
        - setInterval : 일정 시간 마다 콜백 함수 실행
    

   