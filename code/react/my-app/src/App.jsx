// 함수 안에 html 구조가 들어간 형태: jsx
// jsx를 통해 컴포넌트를 만들 수 있음
function Profile() {
  return <div>my image</div>;
}

function App() {
  return (
    <div>
      Haha
      <Profile></Profile>
    </div>
  );
}
export default App;
