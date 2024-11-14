import { useDispatch, useSelector } from "react-redux";
import { Link } from "react-router-dom";
import { login, logout } from "../store/slices/loginSlice";

export default function Header() {
  const { isLogin } = useSelector((state) => state.isLogin);
  const dispatch = useDispatch();

  return (
    <header>
      <div>
        <button onClick={() => console.log(isLogin)}>출력</button>
        {isLogin ? (
          <buttonn
            onClick={() => {
              dispatch(logout());
            }}
          >
            로그아웃
          </buttonn>
        ) : (
          <button
            onClick={() => {
              dispatch(login());
            }}
          >
            로그인
          </button>
        )}
      </div>

      <ul>
        <li>
          <Link to="/">Home으로</Link>
        </li>
        <li>
          <Link to="/posts">게시글로</Link>
        </li>
        {isLogin && (
          <li>
            <Link to="/posts/newPost">게시글 생성</Link>
          </li>
        )}
      </ul>
    </header>
  );
}
