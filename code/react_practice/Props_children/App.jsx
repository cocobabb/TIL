import Profile from "./Profile";
import Welcome from "./Welcome";
import Card from "./Card";
import Button from "./Button";
function App() {
  const cardSize = {
    width: "500px",
    height: "500px",
    border: "solid black 1px",
  };

  return (
    <>
      <Button backgroundColor={"blue"}>확인</Button>
      <Button backgroundColor={"red"}>취소</Button>
      <Button backgroundColor={"gray"}>보류</Button>
      <Button backgroundColor={"pink"}>1억년</Button>
      <Button>
        <Profile></Profile>
      </Button>
    </>
  );
}
export default App;
