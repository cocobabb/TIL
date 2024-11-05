
### JSX
: **함수명은 Pascal case**를 따르며 기본으로 Javascript 코드의 규칙을 가지고  **HTML Element 형태의 반환값**을 가지고 있는 것 

```Javascript
function App() {
  return (
    <h1>제목</h1>
    <p>내용</p>
  );
}
export default App;

// Error : Adjacent JSX element must be wrapped in an enclosing tag. Did you want a JSX fragment<>...</>?
```
**JSX 엘리먼트는 반드시 단 하나의 엘리먼트로 감싸진 구조로 반환되어야 함**
(두개 이상의 엘리먼트가 반환될 수 없음)



```Javascript
function App() {
  return (
    <div>
      <h1>제목</h1>
      <p>내용</p>
    </div>
  );
}

export default App;
```

만약 JSX 구조상의 이유로만 tag로 묶는 거라면 아래와 같이 `fragment`만을 사용해 작성 가능

```Javascript
function App() {
  return (
    <>
      <h1>제목</h1>
      <p>내용</p>
    </>
  );
}

export default App;

```

### 기타 주의해야 할 규칙
#### - closing tag가 없는 tag
: HTML에서는 정상 동작하지만, **React에서는 다음과 같이 명시적으로 닫아주어야 함**

```Javascript
function App() {
  return (
    <div>
      <h1>제목</h1>
      <img
        src="https://i.imgur.com/yXOvdOSs.jpg"
        alt="Hedy Lamarr"
        className="photo"
      /> {/* "/"를 활용해서 태그를 닫는다. */}
    </div>
  );
}

export default App;

```
#### - Camel case
: 변수명, 속성값 등에 첫 문자는 소문자, 다음단어의 첫문자는 대문자로 작성하는 규칙(Javascript 기반이라 dash를 연산자로 인식하여 쓸 수 없음)

#### - 예약어 사용x
- img tag의 class속성 >> className
- label tag의 for 속성 >> htmlFor
```Javascript
//JSX
<img
  src="https://i.imgur.com/yXOvdOSs.jpg"
  alt="Hedy Lamarr"
  className="photo"
/>
```

```Javascript
//JSX
<input type="radio" id="html" value="HTML">  <label htmlFor="html">HTML</label><br> 
  
<input type="radio" id="css" value="CSS">  
<label htmlFor="css">CSS</label><br>  

<input type="radio" id="javascript"value="JavaScript">  
<label htmlFor="javascript">JavaScript</label>
```
#### - 그 외
- `checked`, `selected` 등의 단일 속성만 있어도 되는 attribute들은 `checked={true}`와 같이 값을 명시해야 함