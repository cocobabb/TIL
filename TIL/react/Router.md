
```Shell
// Terminal에서 router 라이브러리 설치
npm install react-router-dom
```
### Routing
: 사용자가 웹 애플리케이션 내에서 다른 페이지로 이동할 수 있도록 경로(주소)를 지정하는 과정

react 라이브러리는 SPA(Single Page Application)으로 한번 페이지가 로드된 후 페이지가 전환될 때 페이지 전체가 새로고침 될 필요가 없는데 **router 라이브러리는 SPA에서 각 페이지처럼 동작할 수 있게 해준다.( 여러 페이지로 전환 시 발생하던 불필요한 새로고침 없이 전환)**
	SPA란?
		변경사항이 있을 때마다 요청을 보내 서버로부터 변경사항이 적용된 **새로운 페이지(새로운 변경사항을 포함한 resource를 가진 HTML)를 불러와 다시 rendering** 되던 **SSR web application 방식과 달리** 
		한번 요청했을 때 받은 페이지(기본 resource를 가진 HTML)를 rendering 하고 변경사항이 생길 때마다 동적으로 요청(Javascript => AJAX )을 보내고 서버로부터 resource만 받아와서 **변경 사항 부분만 갱신하는 CSR web application방식** 
		
		

![[SSR_CSR.png]]

### 사용 방법
1. router 폴더 생성 후 index.jsx 생성
	- index.jsx에는 라우터 라이브러리의 함수**createBrowserRouter을 통해 URL경로에 따라 보여줄 컴포넌트를 매핑**
```Javascript
// index.jsx
import { createBrowserRouter } from "react-router-dom";
import Home from "../pages/Home";
import PostList from "../pages/PostList";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Home />
  },
  {
    path: "/posts",
    element: <PostList />,
  },
]);

export default router;
```

2. App.jsx에 라우터 라이브러리의 함수 **RouterProvider을 통해 URL과 컴포넌트를 매핑정보를 가지고 있는 컴포넌트를 불러옴**
```Javascript
// App.jsx
import React from "react";
import { RouterProvider} from "react-router-dom";
import router from "./router";

export default function App() {
  return (
    <>
      <RouterProvider router={router}></RouterProvider>
    </>
  );
}
```
3. 반복적인 틀으로 이용하는 구조에서  레이아웃을 생성하여 content 부분만 부분적으로 바꿀 수 있다.
	- Layout.jsx 생성하고 라우터 라이브러리의 **Outlet 함수를 이용하여 부모 라우트가 자식 라우트를 렌더링할 위치 지정**
```Javascript
// Layout.jsx
import React from "react";
import { Outlet } from "react-router-dom";

export default function RootLayout() {
  return (
    <>
      <header>헤더</header>
      <Outlet></Outlet>
      <footer>푸터</footer>
    </>
  );
}
```

4. createRouter 변경
	- **children 옵션을 통해 중첩된 라우트를 지정**할 수 있음
	- **부모 라우트에 속한 자식 라우트들은 추가적인 path를 지정**할 수 있으며, index : true를 지정하면 부모와 같은 path를 갖게 됨
	- **동적 라우팅**은 path 설정 중 변화하는 값이 url에 필요할 경우 하는 설정으로 **`:변수명`형태로 사용 ex) `path: "/posts/:postId"`**
```Javascript
// index.jsx
import { createBrowserRouter } from "react-router-dom";
import Home from "../pages/Home";
import PostList from "../pages/PostList";
import RootLayout from "../RootLayout";
import PostDetail from "../pages/PostDetail";

const router = createBrowserRouter([
  {
    path: "/",
    element: <RootLayout />,
    children: [
      {
        index: true,
        element: <Home />,
      },
      {
        path: "/posts",
        element: <PostList />,
      },
      {
        path: "/posts/:postId",
        element: <PostDetail />,
      },
    ],
  },
]);

export default router;
```
7. 동적 라우팅의 변수값(path parameter)에 접근 & state 값에 접근
	- 라우터 라이브러리의 **useParams** 함수로 path에 설정된 변수명을 통해 가져옴(**동적 라우팅 시 설정한 변수명과 useParams로 가져올 때 변수명이 일치해야 함**)
	- **`Link`,`useNavigate` 등 라우터 라이브러리 함수로 부모 라우터로 부터 전달 받은 state 값**을 자식 라우터는 라우터 라이브러리의 **useLocation** 함수을 통해 가져올 수 있음(state 뿐만 아니라 아래와 같은 값에 접근할 수 있음)
		- pathname: 현재 경로
		- search: 쿼리 파라미터 (`useSearchParams`을 통해서도 확인 가능)
		- hash: `#`해시

```Javascript
// 부모 라우터
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

function PostList() {
 
  const navigate = useNavigate();

  return (
    <div>
	    <h2>Posts</h2>
	    <ul>
	        {posts.map((post) => (
	          <li key={post.id}>
	            <h3 onClick={() => { navigate(`/posts/${post.id}`) }} >
	              {post.title}
	            </h3>
	          </li>
	        ))}
	    </ul>
		<ul>
	        {posts.map((post) => (
	          <li key={post.id}>
	            <Link to={`/posts/${post.id}`}>
	              <h3>{post.title}</h3>
	            </Link>
	          </li>
	        ))}
	    </ul>
    </div>
  );
}

export default PostList;

```
****
```Javascript
// 자식 라우터
import React from "react";
import { useParams } from "react-router-dom";

export default function PostDetail() {
  const { postId } = useParams();
  return <div>{postId}번째 게시글</div>;
}

```

