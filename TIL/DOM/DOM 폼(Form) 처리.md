
### Form의 submit 이벤트
- 사용자가 **입력 폼을 작성하고, 제출(type="submit") 버튼을 클릭**하거나 **Enter 키를 누를 때** 발생하는 이벤트
- `submit` 이벤트는 오직 **`form`** 태그에서만 발생하며 이를 제어할 수 있음
- **필요에 따라 제출 이벤트를 중지**하고, 제출 전에 필요한 작업을 처리 후 제출할 수 있음
		event.preventDefalult() : 폼 제출 이벤트 중지 method
```HTML
<!DOCTYPE html>
<html>
  <body>
    <form id="my-form">
      <label for="name">이름:</label>
      <input type="text" id="name" name="name" required />
      <button type="submit">제출</button>
    </form>

    <script>
      const form = document.querySelector('#my-form');

      form.addEventListener('submit', function (event) {
        event.preventDefault(); // 폼 제출 이벤트 중지
        alert('폼 제출 이벤트 중지');
      });
    </script>
  </body>
</html>
```

### 입력 요소 값 처리
: 사용자가 입력 요소에 작성한 값은 해당 요소의 value 속성을 통해 읽고 쓸 수 있음
```HTML
<!DOCTYPE html>
<html>
  <body>
    <form id="my-form">
      <label for="name">이름:</label>
      <input type="text" id="name" name="name" required />
      <button type="submit">제출</button>
    </form>

    <script>
      const form = document.querySelector('#my-form');
      form.addEventListener('submit', function (event) {
        event.preventDefault();

        const nameInput = document.querySelector('#name');
        alert(`입력 요소에 작성한 값은 ${nameInput.value} 입니다.`);
      });
    </script>
  </body>
</html>

```

### 데이터 유효성 검사(Data validation)
- 사용자가 입력 폼에 작성한 값이 유효한지 검사하는 과정
- 브라우저는 기본적인 유효성 검사(이메일 등)를 하지만 JavaScript로 **추가 유효성 검사**를 수행할 수 있음
```HTML
<!DOCTYPE html>
<html>
  <body>
    <form id="my-form">
      <label for="name">이름</label>
      <input type="text" id="name" name="name" required />
      <button type="submit">제출</button>
    </form>

    <script>
      const form = document.querySelector('#my-form');
      form.addEventListener('submit', function (event) {
        const nameInput = document.querySelector('#name');

        // 이름 길이 유효성 검사
        if (nameInput.value.length < 2) {
          alert('이름이 너무 짧습니다.');

          // 제출 이벤트 중지
          event.preventDefault();
        } else {
          alert('폼을 제출합니다.');
        }
      });
    </script>
  </body>
</html>
```

### 실시간 데이터 처리
- input, change 이벤트 type을 통해 사용자가 입력한 데이터를 실시간 처리 가능
- 사용자의 동작에 반응해 실시간으로 데이터 유효성 검사 가능

`input, textarea, select`
- 사용자가 입력 요소의 값을 변경할 때 마다 발생
- 실시간으로 사용자의 동작을 감지해야 할 때 사용
- checkbox, radio 타입은 지원하지 않음

`change`
- 사용자가 입력을 끝내고, 포커스를 다른 곳으로 이동하거나 엔터키를 입력하면 발생
- 실시간으로 감지가 필요한 경우에는 적합하지 않음

```HTML
<!DOCTYPE html>
<html lang="en">
  <body>
    <label for="text-input">텍스트 입력:</label>
    <input type="text" id="text-input" />
    <div class="output">
      <p>input 이벤트 : <span id="input-output"></span></p>
      <p>change 이벤트 : <span id="change-output"></span></p>
    </div>

    <script>
      const textInput = document.querySelector('#text-input');
      const inputOutput = document.querySelector('#input-output');
      const changeOutput = document.querySelector('#change-output');

      // input 이벤트: 입력 시마다 발생
      textInput.addEventListener('input', () => {
        inputOutput.textContent = textInput.value;
      });

      // change 이벤트: 입력이 완료된 후(포커스가 벗어나면) 발생
      textInput.addEventListener('change', () => {
        changeOutput.textContent = textInput.value;
      });
    </script>
  </body>
</html>

```