### 전역 상태 관리가 필요한 이유

- **데이터 일관성 유지**
    
- **중앙 집중식 관리**
    데이터와 관련된 코드를 집중하여 관리할 수 있기 때문에 유지보수가 용이
    
- **컴포넌트 간 상태 전달 문제 해결**
    전역 상태를 사용하면 필요한 컴포넌트에서 바로 데이터를 가져올 수 있어, 여러 props를 통한 불필요한 데이터 전달을 피할 수 있음

### store 사용법
1. redux toolkit 라이브러리 설치
```Shell
// Terminal
npm install @reduxjs/toolkit react-redux
```
****

2. redux toolkit 라이브러리의 createSlice 함수를 통해 state를 저장할 공간 생성
	- `initialState`에는 초기값을 지정
	- **`reducers`에는 state값 변경을 위한 함수들이 정의됨(함수들 export해줘야 외부에서 쓸 수 있음)**
    - 함수는 `state`, `action` 두 개의 parameter를 가지며, `action.payload`에는 함수에 대한 입력값이 들어있음
```Javascript
// 생성한 파일 경로: src/slices/postSlice.js
import { createSlice } from "@reduxjs/toolkit";

const initialState = [
    {
      id: 1,
      title: "첫 번째 프로젝트",
      content:
        "간단한 Todo 앱을 만들었습니다. UI 구성과 상태 관리의 중요성을 배웠습니다.",
    },
    {
      id: 2,
      title: "리액트와 함께한 성장",
      content:
        "리액트를 이용해 컴포넌트 기반 개발을 익히고 재사용성을 높이는 방법을 배웠습니다.",
    },
    {
      id: 3,
      title: "팀 프로젝트 경험",
      content:
        "팀 프로젝트에서 협업하여 일정 관리 앱을 개발했고, Git을 활용한 버전 관리와 코드 리뷰의 중요성을 배웠습니다.",
    },
  ];

const postsSlice = createSlice({
  name: "posts",
  initialState,
  reducers: {
	  addPost: (state, action) => {
      state.push(action.payload);
  },
});
export const {addPost} = PostsSlice.actions;
export default postsSlice.reducer;

```
****

3. redux toolkit 라이브러리의 함수 `configureStore` 이용해 state 저장공간인 slice들을 통합해서 관리하고 저장할 store 생성
```Javascript
// 생성한 파일경로: src/store/store.js
import { configureStore } from "@reduxjs/toolkit";
import postsReducer from "./slices/postsSlice";

const store = configureStore({
  reducer: {
    posts: postsReducer,
  },
});

export default store;
```
****

4. redux 라이브러리의 `Provider`함수를 이용해 어느 컴포넌트에서든 store에 접근 가능 하도록 App.jsx의 제일 상위 컴포넌트로 설정함
```Javascript
// App.jsx
import { RouterProvider } from "react-router-dom";
import router from "./router";

import { Provider } from "react-redux";
import store from "./store/store";

export default function App() {
  return (
    <>
      <Provider store={store}>
        <RouterProvider router={router}></RouterProvider>
      </Provider>
    </>
  );
}
```
****

5. store에 접근하여 state 값 가져오는 방법
	- **redux 라이브러리의 `useSelector` 함수를 이용해 특정 state 값 가져올 수 있음**(`configureStore`에 저장한 이름을 통해 가져옴)
```Javascript
import React from "react";
import { Link } from "react-router-dom";
import { useSelector } from "react-redux";

export default function PostList() {
  const posts = useSelector((state) => state.posts);

  return (
    <div>
      <h2>posts</h2>
      <ul>
        {posts.map((post) => {
          return (
            <li key={post.id}>
              <Link to={`/posts/${post.id}`} state={{ post }}>
                <h3>{post.title}</h3>
              </Link>
            </li>
          );
        })}
      </ul>
    </div>
  );
}
```
****

6. store에 접근하여 state값 변경하기
	- **redux 라이브러리의 `useDispatch` 함수를 이용해 특정 state 값 변경할 수 있음**
	- 특정state(`createSlice`)의 reducers에 **state값 변경을 위해 정의한 함수 import해야 `useDispatch`가 해당 함수를 사용할 수 있음**
```Javascript
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
```
****

7. react의 함수 `useEffect`을 이용해 UI가 렌더링 하는 동안 store의 state 데이터를 setter에 set
	- **useEffect : UI렌더링 되는 동안 다른 작업을 수행하게 하는 hook**
	- 해당 함수를 쓰는 이유:  **useState()의 setter가 트리거가 되어 렌더링이 실행** 되는데 **UI 렌더링 후 setter가 실행되면 다시 렌더링 되고 다시 setter에 실행 되고** 다시 렌더링 되고 이런 **무한루프가 발생**하는 에러가 발생하기 때문 => 해결: useEffect 이용하여 setter 실행 
```Javascript
import { useState } from "react";
import { useSelector } from "react-redux";
import { useParams } from "react-router-dom";

export default function PostDetail() {
  const { postId } = useParams();
  const posts = useSelector((state) => state.posts);

  const [post, setPost] = useState();

  setPost(posts.find((post) => post.id === parseInt(postId)));
  
  return (
    <div>
      //<h3>{post.title}</h3>
      //<p>{post.content}</p>
      // error:Cannot read properties of undefined (reading 'title')
      // => 아직 state 데이터가 없는 상태에서 접근 하려고 해서 나는 에러
      // => 옵셔널 체이닝(?.)을 이용하여 해당 에러 해결 가능
	    <h3>{post?.title}</h3>
	    <p>{post?.content}</p>
    </div>
  );
}

```