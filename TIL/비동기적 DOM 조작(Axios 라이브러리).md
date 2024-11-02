### Axios
: node.js와 브라우저를 위한 Promise 기반 HTTP 클라이언트 라이브러리. 서버 사이드에서는 native node.js의 `http`모듈을 사용하고, 클라이언트(브라우저)에서는 XMLHttpRequests를 사용
[Axios 사용법](https://axios-http.com/kr/docs/intro)
- **`Promise` 기반의 HTTP 통신 라이브러리**
- `fetch()`와 사용법이 비슷하며 **JSON데이터를 기본적으로 처리해줌**

#### GET 메서드 : `axios.get(url)`
```HTML
<!DOCTYPE html>
<html>
  <head>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
  </head>
  <body>
    <script>
      async function readTodo(todoId) {
        try {
          // 요청 URL
          const url = `https://jsonplaceholder.typicode.com/todos/${todoId}`;

          // GET 요청 & 응답
          // axios.get(url)
          const response = await axios.get(url);
          /* JSON 데이터를 기본적으로 해줘서 더 간단하게 표현가능
	          const response = await fetch(url)
	          const data = await reponse.json();
          */
          
          console.log(response.data);
        } catch (error) {
          console.error('오류 발생:', error);
        }
      }
      const todoId = 1;
      readTodo(todoId);
    </script>
  </body>
</html>

```

#### POST 메서드: `axios.post(url, data)`
```HTML
<!DOCTYPE html>
<html>
  <head>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
  </head>
  <body>
    <script>
      async function createTodo(newTodo) {
        try {
          // 요청 URL
          const url = 'https://jsonplaceholder.typicode.com/todos';

          // POST 요청 & 응답
          const response = await axios.post(url, newTodo);

		/* JSON 데이터를 기본적으로 해줘서 더 간단하게 표현가능
		const response = await fetch(url,
		 {
			method: 'POST',
			headers:{
				'Content-Type':'application/json',
			},
			body: JSON.stringyfy(newTodo)
		});
		*/

          // 생성된 할 일 데이터 확인
          console.log('생성된 할 일:', response.data);
        } catch (error) {
          console.error('오류 발생:', error);
        }
      }

      // 전송할 새로운 데이터
      const newTodo = {
        title: '새로운 할 일',
        completed: false,
        userId: 1,
      };

      // 함수 실행
      createTodo(newTodo);
    </script>
  </body>
</html>
```

[기타 요청을 만드는데 사용하는 config 옵션들](https://axios-http.com/kr/docs/req_config)

#### Axios를 이용한 비동기적  DOM 조작
: 버튼을 클릭하면 서버에 요청을 하고, 받은 데이터를 기반으로 새로운 DOM을 생성함
```HTMl
<!DOCTYPE html>
<html>
  <head>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
  </head>
  <body>
    <div id="container">
      <button id="button">데이터 요청</button>
      <p>할 일 목록</p>
    </div>

    <script>
      // button 태그 및 div 태그 선택
      const button = document.querySelector('#button');
      const container = document.querySelector('#container');

      // 비동기 데이터 요청 함수
      async function getData(todoId) {
        try {
          // 데이터 요청 및 결과 저장
          const response = await axios.get(
            `https://jsonplaceholder.typicode.com/todos/${todoId}`
          );

          // 새로운 DOM 생성 및 텍스트 설정
          const pTag = document.createElement('p');
          pTag.textContent = `할 일 : ${response.data.title}`;

          // 기존 div 태그의 자식 태그로 추가
          container.appendChild(pTag);
        } catch (error) {
          console.error('오류 발생:', error);
        }
      }

      // todo 데이터 id
      let todoId = 1;

      // 버튼에 click 이벤트 핸들러 등록
      button.addEventListener('click', function () {
        // 데이터 요청 함수 실행
        getData(todoId);

        // 다음 todo 데이터 요청을 위한 연산
        todoId = todoId + 1;
      });
    </script>
  </body>
</html>
```