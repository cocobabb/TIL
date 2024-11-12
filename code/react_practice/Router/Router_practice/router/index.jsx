import { createBrowserRouter } from "react-router-dom";
import Home from "../pages/Home";
import RootLayout from "../RootLayout";
import WebtoonLayout from "../WebtoonLayout";
import Webtoon from "../pages/Webtoon";
import WebtoonContent from "../pages/WebtoonContent";
import NovelLayout from "../NovelLayout";
import Novel from "../pages/Novel";
import NovelContent from "../pages/NovelContent";

const router = createBrowserRouter([
  {
    path: "/",
    element: <RootLayout />,
    children: [
      { index: true, element: <Home /> },
      {
        path: "/webtoon",
        element: <WebtoonLayout />,
        children: [
          { index: true, element: <Webtoon /> },
          { path: "/webtoon/:webtoonId", element: <WebtoonContent /> },
        ],
      },
      {
        path: "/novel",
        element: <NovelLayout />,
        children: [
          { index: true, element: <Novel /> },
          { path: "/novel/:novelId", element: <NovelContent /> },
        ],
      },
    ],
  },
]);

export default router;
