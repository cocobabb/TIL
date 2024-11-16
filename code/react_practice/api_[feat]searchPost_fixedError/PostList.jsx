import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";

export default function PostList() {
  const navigate = useNavigate();
  const [posts, setPosts] = useState([]);
  const [searchPost, setSearchPost] = useState(); //검색어 관련

  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    // const posts = useSelector((state) => state.posts); // fetch를 통해 서버에서 데이터를 가져오겠다
    async function fetchPosts() {
      const url = "http://localhost:3000/posts";
      try {
        const response = await axios.get(url);
        // const response = await axios({ url: url }); // 위 코드와 같은 의미
        const data = response.data;
        setPosts(data);
      } catch (err) {
        console.error(err);
        setError("무엇인가의 error가 났어");
      } finally {
        setLoading(false);
      }
    }

    fetchPosts();
  }, []);

  useEffect(() => {
    async function fetchSerchPosts() {
      const url = "http://localhost:3000/posts";
      try {
        const response = await axios.get(url);
        const data = response.data;
        setPosts(data);
      } catch (err) {
        console.error(err);
        setError("무엇인가의 error가 났어");
      } finally {
        setLoading(false);
      }
    }

    fetchSerchPosts();
  }, [searchPost]);

  if (error) {
    return <div>{error}</div>;
  }

  if (loading) {
    return <div>로딩중</div>;
  }

  return (
    <div>
      <h2>posts</h2>

      <label htmlFor="searchPost">게시물 검색:</label>
      <input
        onChange={(e) => setSearchPost(e.target.value)}
        type="text"
        id="searchPost"
      />
      <ul>
        {searchPost &&
          posts
            .filter((post) => post.title.includes(searchPost))
            .map((filteredPost) => {
              const { id, title, content } = filteredPost;
              return (
                <li key={id}>
                  <Link to={`/posts/${id}`} state={{ filteredPost }}>
                    {title}
                  </Link>
                </li>
              );
            })}
      </ul>

      <ul>
        {posts.map((post) => {
          const { id, title, content } = post;
          return (
            <li key={id}>
              <Link to={`/posts/${id}`} state={{ post }}>
                <h3>{title}</h3>
              </Link>
              <h3
                onClick={() => {
                  // 이동을 하고 싶다
                  navigate(`/posts/${id}`);
                }}
              >
                {title}
              </h3>
            </li>
          );
        })}
      </ul>
    </div>
  );
}
