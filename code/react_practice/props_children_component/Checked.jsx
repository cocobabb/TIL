import IsNotLogin from "./IsNotLogin";

export default function Checked({ isLogin }) {
  return isLogin ? <div>환영합니다!</div> : <IsNotLogin></IsNotLogin>;
}
