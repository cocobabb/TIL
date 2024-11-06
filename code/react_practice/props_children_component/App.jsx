import Checked from "./Checked";
import OtherPage from "./OtherPage";

function App() {
  const isLogin = true;
  return (
    <>
      <OtherPage userType="admin">
        <Checked isLogin={isLogin}></Checked>
      </OtherPage>

      <OtherPage userType="manager">
        <Checked isLogin={isLogin}></Checked>
      </OtherPage>

      <OtherPage userType="user">
        <Checked isLogin={isLogin}></Checked>
      </OtherPage>
    </>
  );
}
export default App;
