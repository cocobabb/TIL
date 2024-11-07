import Name from "./Name";
import Products from "./Products";
import Users from "./Users";
import Img from "./Img";
import Btn from "./Btn";
import Card from "./Card";
import Beverage from "./Beverage";

function App() {
  const btnValue = [
    {
      text: "확인",
      backgroundColor: "blue",
    },
    {
      text: "취소",
      backgroundColor: "red",
    },
    {
      text: "보류",
      backgroundColor: "gray",
    },
    {
      text: "1억년",
      backgroundColor: "pink",
    },
  ];
  const styleBtn = btnValue.map((ob) => {
    const { text, backgroundColor } = ob;
    return <Btn backgroundColor={backgroundColor}>{text}</Btn>;
  });

  const coffee = [
    {
      name: "아메리카노",
      price: "5.0/5.5",
    },
    {
      name: "카페라떼",
      price: "6.0/6.5",
    },
    {
      name: "바닐라라떼",
      price: "6.0/6.5",
    },
    {
      name: "카라멜마끼아또",
      price: "6.5/7.0",
    },
  ];
  const coffeeValue = coffee.map((c) => {
    const { name, price } = c;

    return <Beverage name={name} price={price}></Beverage>;
  });

  const ade = [
    {
      name: "레몬에이드",
      price: "6.0",
    },
    {
      name: "자몽에이드",
      price: "6.0",
    },
    {
      name: "유자에이드",
      price: "6.0",
    },
  ];
  const adeValue = ade.map((a) => {
    const { name, price } = a;
    return <Beverage name={name} price={price}></Beverage>;
  });

  return (
    <>
      <Name></Name>
      <br />
      <Users></Users>
      <br />
      <Products></Products>
      <br />
      <Img></Img>
      <br />
      <br />
      {styleBtn}
      <br />
      <br />
      <br />
      <Card title="강아지" content="귀여워"></Card>
      <br />
      <h1 style={{ color: "brown" }}>MENU</h1>
      <h4>COFFEE</h4>
      <hr />
      {coffeeValue}
      <h4>ADE</h4>
      <hr />
      {adeValue}
    </>
  );
}
export default App;
