import Button from "./Button";

function App() {
  function clickEl() {
    alert("버튼 클릭");
  }

  function changeWhite(e) {
    e.target.style.backgroundColor = "white";
  }

  function getMoney(num) {
    alert(num + `${num}억원을 얻었습니다`);
  }
  return (
    <>
      <button onClick={clickEl}>버튼입니다</button>
      <div
        onMouseOver={(e) => (e.target.style.backgroundColor = "black")}
        onMouseOut={changeWhite}
        style={{
          width: 100,
          height: 100,
          border: "1px solid black",
        }}
      ></div>
      <input
        type="text"
        onChange={(e) => {
          console.log(e.target.value);
        }}
      />
      <br />
      <br />
      <Button onClick={() => alert("확인 완료")} backgroundColor="blue">
        확인
      </Button>

      <Button onClick={() => alert(" 취소 완료")} backgroundColor="red">
        취소
      </Button>

      <Button onClick={() => alert("보류 완료")} backgroundColor="gray">
        보류
      </Button>

      <Button
        onClick={() => {
          getMoney(3);
        }}
        backgroundColor="violet"
      >
        1억년
      </Button>
    </>
  );
}
export default App;
