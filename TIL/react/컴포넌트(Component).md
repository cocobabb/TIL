: 재사용이 가능한 UI 요소. 코드를 하나의 부품처럼 사용하는 것을 의미

```Javascript
import "./App.css";
// App.jsx
function Profile() {
  return <img src="https://i.imgur.com/MK3eW3Am.jpg" alt="Katherine Johnson" />;
}

function App() {
  return (
    <div className="App">
      <h1>My First Component</h1>
      <Profile />
      <Profile />
      <Profile />
    </div>
  );
}

export default App;
```
 **생성한 profile라는 함수는 `JSX`요소를 반환. 이러한 함수를 리액트에서는 컴포넌트라 정의함**