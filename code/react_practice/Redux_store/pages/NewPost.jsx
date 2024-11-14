import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { addPost } from "../store/slices/postSlice";
import { Navigate, useNavigate } from "react-router-dom";

export default function NewPost() {
  const posts = useSelector((state) => state.posts);
  const [formData, setFormData] = useState({
    title: "",
    content: "",
  });

  const dispatch = useDispatch();
  const navigate = useNavigate();
  const { isLogin } = useSelector((state) => state.isLogin);

  // 아래 코드 추가 전: 새 게시글은 로그인 한 경우에만 접근이 가능한데 접근 후 로그아웃 했을 때 해당 기능을 이용할 수 있는 오류가 있었음
  // 아래 코드 추가 후: 새 게시글 작성 기능 접근 후 로그아웃하면 홈으로 돌아감
  useEffect(() => {
    if (!isLogin) {
      navigate("/");
    }
  }, [isLogin]);

  function handleData(e) {
    const key = e.target.name;
    setFormData({
      ...formData,
      [key]: e.target.value,
    });
  }
  function handleSubmit(e) {
    e.preventDefault();

    const id = Date.now();

    dispatch(addPost({ ...formData, id }));
    // navigate("/posts");
    navigate(`/posts/${id}`);
  }
  return (
    <>
      <h3>newPost</h3>
      <form onSubmit={handleSubmit}>
        <label htmlFor="title">제목: </label>
        <input type="text" name="title" id="title" onChange={handleData} />
        <br />
        <label htmlFor="content">내용:</label>
        <br />
        <textarea name="content" id="content" onChange={handleData}></textarea>
        <br />
        <button>제출</button>
      </form>
    </>
  );
}
