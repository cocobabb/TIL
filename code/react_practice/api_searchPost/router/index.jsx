import { createBrowserRouter } from "react-router-dom";
import Home from "../pages/Home";
import PostList from "../pages/PostList";
import Hello from "../pages/Hello";
import RootLayout from "../RootLayout";
import PostDetail from "../pages/PostDetail";
import NotFound from "../pages/NotFound";
import NewPost from "../pages/NewPost";

const router = createBrowserRouter([
  {
    path: "/",
    element: <RootLayout />,
    // errorElement: <NotFound />,
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
        path: "/posts/newPost",
        element: <NewPost />,
      },
      {
        // /posts/:postId가 posts/newPost 보다 위에 있으면
        // 순서대로 실행되면서 체크하므로 PostDetail로 넘어갈 수 있음
        //  :postId는 뭐든 들어갈 수 있는 동적변수이기 때문에
        path: "/posts/:postId",
        element: <PostDetail />,
      },
    ],
  },
  {
    path: "/not-found",
    element:<NotFound/>
  }

]);

export default router;
