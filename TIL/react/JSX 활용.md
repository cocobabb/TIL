
### 문자열 전달
: 문자열을 JSX에 전달하기 위해 "" 또는 '' 로 묶어야함

```Javascript
function App() {
  return (
    <img
      className="avatar"
      src="https://i.imgur.com/7vQD0fPs.jpg"
      alt="Gregorio Y. Zara"
    />
  );
}

export default App;

```
### {} 중괄호
: JSX에서 {}는 Javascript 를 직접 적용한다는 의미

```Javascript
// JSX
function App() {
  const name = 'Gregorio Y. Zara';
  return (
    <h1>{name}'s To Do List</h1>
  );
}
export default App;

```

```Javascript
// JSX
function App() {
  const grade = 80;
  return (
    <h1>
      I got {grade} on this exam, and I got
      {grade > 60 ? " pass" : " fail"}
    </h1>
  );
}

export default App;

```

```Javascript
const today = new Date();

//Javascript 함수
function formatDate(date) {
  return new Intl.DateTimeFormat(
    'en-US',
    { weekday: 'long' }
  ).format(date);
}
//JSX의 컴포넌트
function App() {
  return (
    <h1>To Do List for {formatDate(today)}</h1>
  );
}

export default App;
//다음과 같이 함수를 호출하의 데이터에 Object Accessors(.)을 통해 접근 가능
```

### 이중 중괄호 {{}}
: JSX에서 Javascript의 객체를 적용할 때 사용

```Javascript
function App() {
  return (
    <ul
      style={{
        backgroundColor: "black",
        color: "pink",
      }}
    >
      <li>Improve the videophone</li>
      <li>Prepare aeronautics lectures</li>
      <li>Work on the alcohol-fuelled engine</li>
    </ul>
  );
}

export default App;

```