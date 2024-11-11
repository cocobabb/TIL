import { createBrowserRouter } from "react-router-dom";
import Home from "../pages/Home";
import PostList from "../pages/PostList";
import RootLayout from "../RootLayout";
import PostDetail from "../pages/PostDetail";
const router = createBrowserRouter([
  // {
  //   path: "/",
  //   element: <Home />,
  // },
  // {
  //   path: "/posts",
  //   element: <PostList />,
  // },
  // {
  //   path: "/hello",
  //   element: <Hello />,
  // },
  {
    path: "/",
    element: <RootLayout />,
    children: [
      { index: true, element: <Home /> },
      { path: "/posts", element: <PostList /> },
      { path: "/posts/:postId", element: <PostDetail /> },
    ],
  },
]);

export default router;
