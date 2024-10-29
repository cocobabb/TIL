
#### **document.querySelector(선택자)**
- **CSS 선택자**를 이용하여 **첫 번째 일치하는 요소 노드를 반환**
- **단일 요소**를 선택할 때 사용되며, 문서의 어떤 위치에 있든 **첫 번째로 일치하는 요소**를 찾음
```HTML
<!DOCTYPE html>
<html>
  <body>
    <div class="container">
      <p id="first">첫 번째 문단</p>
      <p class="second">두 번째 문단</p>
    </div>
    <script>
      const firstParagraph = document.querySelector('#first');
      console.log(firstParagraph.textContent); // 첫 번째 문단

      const secondParagraph = document.querySelector('.second');
      console.log(secondParagraph.textContent); // 두 번째 문단
    </script>
  </body>
</html>

```

#### **document.querySelectorAll(선택자)**
- **CSS 선택자**를 이용하여 **일치하는 모든 요소 노드를 저장한 `NodeList`를 반환**
- **`NodeList`는 배열**이기 때문에 `for...of`** 또는 배열 함수를 사용하여 반복할 수 있음

```HTML
<!DOCTYPE html>
<html>
  <body>
    <div class="container">
      <p id="first">첫 번째 문단</p>
      <p class="second">두 번째 문단</p>
    </div>
    <script>
      const paragraphs = document.querySelectorAll('p');
      paragraphs.forEach((p, index) => {
        console.log(`문단 ${index + 1}: ${p.textContent}`);
      });
      // 문단 1: 첫 번째 문단
      // 문단 2: 두 번째 문단
    </script>
  </body>
</html>

```

#### **요소.textContent  = '텍스트 내용'**
- 속성을 사용하여 요소의 **텍스트 내용을 읽거나 변경**할 수 있다.
- 요소 내부의 모든 텍스트를 **단순한 문자열**로 취급
-  자식 노드가 있을 때 텍스트를 읽으면 **자식 노드의 텍스트도 읽어와
	텍스트를 수정하면 자식 노드가 모두 제거**됨
```HTML
<!DOCTYPE html>
<html>
  <body>
    <h1>원래 제목</h1>
    <script>
      const heading = document.querySelector('h1');
      console.log(heading.textContent); // 원래 제목

      heading.textContent = '새로운 제목';
      console.log(heading.textContent); // 새로운 제목
    </script>
  </body>
</html>

```

#### **요소.getAttribute()** 
메서드를 사용하여 요소의 특정 **속성 값을 읽을 수 있음**
#### **요소.setAttribute()** 
- 메서드를 사용하여 요소의 특정 **속성 값을 조작**
- **속성에 직접 접근해서** 속성을 조작할 수도 있다.

```HTML
<!DOCTYPE html>
<html>
  <body>
    <a id="link" href="https://www.example.com">Example</a>
    <script>
      // 요소 선택
      const link = document.querySelector('#link');

      // 속성 값 읽기
      console.log(link.getAttribute('href')); // https://www.example.com

      // 속성 값 변경하기
      link.setAttribute('href', 'https://www.newsite.com');
      console.log(link.getAttribute('href')); // https://www.newsite.com

      // 속성 직접 접근
      console.log(link.href); // https://www.newsite.com

      link.href = 'https://www.another.com';
      console.log(link.href); // https://www.another.com

      // id 조작 및 접근
      link.id = 'new-link';
      console.log(link.id); // new-link

      // class 조작 및 접근
      link.className = 'link a-tag';
      console.log(link.className); // link a-tag
    </script>
  </body>
</html>

```


#### **요소.classList** 
: **요소의 클래스 목록을 배열 처럼** 관리할 수 있는 속성

- **.add()** : 요소의 클래스 **목록에 새로운 클래스 추가**
- **.remove()** : 요소의 클래스 **목록에서 클래스 제거**
- **.toggle()** : 요소의 클래스 **목록에 클래스가 없으면 추가, 있으면 제거**
- **.contains()** : 요소의 클래스 **포함 여부 확인하여 boolean 값 반환**


#### **요소.style.스타일속성 = '속성 값'** 
: 요소의 **인라인 스타일을 관리**할 수 있는 속성.
```Javascript
// css에서 background-color: red 표현
// Javascript 이용시 아래와 같이 표현
el.style.backgroundColor = 'red'
```