### event 종류
	마우스 이벤트
	- click
	- dblclick
	- mousemove
	- mouseover
	- mouseout
	
	
	키보드 이벤트
	- keydown
	- keyup
	- keypress
	
	
	입력 이벤트
	-  input
	
	
	폼 이벤트
	- submit
	- focus
	- blur


### 이벤트 핸들러(Event Handler)
- 특정 **이벤트가 발생했을 때 실행되는 함수**이다.
- **하나의 이벤트 핸들러만 등록 가능**
- 인라인 속성을 통해 등록할 수 있지만 권장하지 않음
```HTML
<!DOCTYPE html>
<html>
  <body>
	<!--인라인 속성을 통한 이벤트 핸들러-->
    <button onclick="alert('버튼 이벤트 핸들러')">클릭</button>
  </body>
</html>
```

```HTML
<!DOCTYPE html>
<html>
  <body>
    <button id="my-button">클릭</button>
	<!-- JavaScript을 통한 이벤트 핸들러 -->
    <script>
      const button = document.querySelector('#my-button');
      button.onclick = function () {
        alert('버튼 이벤트 핸들러');
      };
    </script>
  </body>
</html>
```

### ### 이벤트 리스너(Event Listener)
##### addEventListener()** 
: **메서드를 사용하여** 요소에 **이벤트 핸들러를 등록**하는 방법
- addEventListener('type', handler, useCapture)
    - type : 이벤트의 종류를 지정한다.
    - handler : type에 해당하는 이벤트가 발생했을 때 실행할 함수를 지정한다.
    - useCapture : 이벤트 캡쳐링을 발생시킬지 여부를 판단하며, 기본은 false(버블링 발생)
- 여러 개의 이벤트 핸들러를 추가하거나 삭제 가능

```HTML
<!DOCTYPE html>
<html>
  <body>
    <button id="my-button">클릭</button>
    <script>
      const button = document.querySelector('#my-button');

      button.addEventListener('click', function () {
        alert('이벤트 리스너로 등록된 클릭 이벤트 1');
      });

      button.addEventListener('click', () => {
        alert('이벤트 리스너로 등록된 클릭 이벤트 2');
      });
    </script>
  </body>
</html>
```

### 이벤트 버블링(Event Bubbling)
: 이벤트가 발생했을 때 **해당 요소의 부모 요소로 전파되는 현상**

```HTML
<!DOCTYPE html>
<html>
  <body>
    <div id="parent">
      부모 div
      <button id="child">자식 button</button>
    </div>

    <script>
      // 부모 요소에 이벤트 핸들러 등록
      document.querySelector('#parent').addEventListener('click', function () {
        alert('부모 div 클릭');
      });
	
      // 자식 요소에 이벤트 핸들러 등록
      // 자식 요소 이벤트를 실행하면 부모요소 이벤트도 같이 실행됨
      document.querySelector('#child').addEventListener('click', function () {
        alert('자식 button 클릭');
      });
    </script>
  </body>
</html>
```

### event.stopPropagation()
: 메서드를 사용하여 이벤트 전파(event bubbling)를 차단

```HTML
<!DOCTYPE html>
<html>
  <body>
    <div id="parent">
      부모 div
      <button id="child">자식 button</button>
    </div>

    <script>
      document.querySelector('#parent').addEventListener('click', function () {
        alert('부모 div 클릭');
      });

      document.querySelector('#child').addEventListener('click', function () {
        alert('자식 button 클릭');
        event.stopPropagation(); // 이벤트 전파를 차단 >> 부모요소 이벤트 발생x
      });
    </script>
  </body>
</html>
```

### 이벤트 캡처링(Event Capturing)
: 이벤트 버블링과 반대로 **자식 요소로 이벤트가 전파되는 현상**
**웹 브라우저는 이벤트 캡처링을 먼저 실행하고, 이후 버블링을 실행**
```HTML
<!DOCTYPE html>
<html>
  <body>
    <div id="parent">
      부모 div
      <button id="child">자식 button</button>
    </div>

    <script>
      // 부모 요소에 이벤트 핸들러 등록
      document.querySelector('#parent').addEventListener(
        'click',
        function () {
          alert('부모 div 클릭');
        },
        true // true를 전달하여 캡처링 단계에서 이벤트 처리
      );

      // 자식 요소에 이벤트 핸들러 등록
      document.querySelector('#child').addEventListener('click', function () {
        alert('자식 button 클릭');
      });
    </script>
  </body>
</html>

```


### 매개변수 event
: 이벤트 핸들러 함수에서 매개변수 event 를 통해 **이벤트에 대한 정보를 얻을 수 있음**
이벤트가 발생한 요소, 이벤트 종류 등의 정보를 포함

- event.target :  속성에 이벤트가 발생한 요소 정보가 저장
```HTML
<!DOCTYPE html>
<html>
  <body>
    <button id="my-button" name="my-button">클릭</button>

    <script>
      const button = document.querySelector('#my-button');

      button.addEventListener('click', function (event) {
        alert(`클릭한 요소의 id : ${event.target.id}`);
        alert(`발생한 이벤트 : ${event.type}`);
      });
    </script>
  </body>
</html>

```
- event.currentTarget  : 속성에 이벤트리스너가 붙은 요소 정보가 저장
```HTML
<!DOCTYPE html>
<html>
  <body>
    <div id="parent">
      부모 div
      <button id="child">자식 button</button>
    </div>

    <script>
      document.querySelector('#parent').addEventListener('click', function (e) {
        alert(`부모 div 클릭 / target : ${e.target.textContent} / currentTarget : ${e.currentTarget.textContent}`);
      });

      document.querySelector('#child').addEventListener('click', function (e) {
        alert(`자식 div 클릭 / target : ${e.target.textContent} / currentTarget : ${e.currentTarget.textContent}`);

      });
    </script>
  </body>
</html>

```