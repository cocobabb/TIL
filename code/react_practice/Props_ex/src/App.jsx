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
      <Profile></Profile>
      <Welcome name={"김철수"}></Welcome>
      <Card title={"card"} content={"이건 카드다"} cardSize={cardSize}></Card>
      <Button text={"확인"} backgroundColor={"blue"} color={"white"}></Button>
      <Button text={"취소"} backgroundColor={"red"} color={"white"}></Button>
      <Button text={"보류"} backgroundColor={"gray"} color={"white"}></Button>
      <Button text={"1억년"} backgroundColor={"pink"} color={"white"}></Button>
    </>
  );
}
export default App;
