import { useState } from "react";
import StatusBtn from "./StatusBtn";

function App() {
  const [num, setNum] = useState(0);
  const [value, setValue] = useState("");
  const [like, setLike] = useState(false);

  return (
    <>
      <div>{num}</div>
      {/* <button onClick={() => setNum(num + 1)}>+</button> */}
      {/* <button onClick={() => setNum(num - 1)}>-</button> */}
      <StatusBtn onClick={() => setNum(num + 1)}>+</StatusBtn>
      <StatusBtn onClick={() => setNum(num - 1)}>-</StatusBtn>
      <br />
      <br />
      <br />
      <input type="text" onChange={(e) => setValue(e.target.value)} />
      <br />
      {/* 값 출력 */}
      <div>setValue: {value}</div>
      {/* 색깔박스 */}
      <div
        style={{
          width: 100,
          height: 100,
          border: "1px solid black",
          backgroundColor: value,
        }}
      ></div>
      <br />
      <br />
      <br />
      <StatusBtn
        backgroundColor={like ? "" : "changed"}
        onClick={(e) => setLike(!like)}
      >
        {like ? "좋아요 취소" : "좋아요"}
      </StatusBtn>
    </>
  );
}
export default App;
