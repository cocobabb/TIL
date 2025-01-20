import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

import postApi from '../api/postsApi';

export default function PostList() {
  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  useEffect(() => {
    async function fetchPosts() {
      try {
        const response = await postApi.getPosts();
        const data = response.data;

        setPosts(data.data);
      } catch (err) {
        setError(err.message);
        console.error(err.responase);
      } finally {
        // 정상로직이든 에러 발생하든 로딩이 끝난 것임
        setLoading(false);
      }
    }

    fetchPosts();
  }, []);

  if (loading) {
    return <div>로딩중</div>;
  }

  if (error) {
    return <div>{error}</div>;
  }

  return (
    <div>
      <h2>posts</h2>
      <ul>
        {posts.map((post) => {
          const { id, title } = post;
          return (
            <li key={id}>
              <Link to={`/posts/${id}`}>
                <h3>
                  {id} : {title}
                </h3>
              </Link>
            </li>
          );
        })}
      </ul>
    </div>
  );
}
