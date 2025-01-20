import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import postApi from '../api/postsApi';
import CommentForm from '../components/CommentForm';

export default function PostDetail() {
  const [post, setPost] = useState({});
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  // url(/posts/:postId) 에서 상세페이지의 id 값을 가지고옴
  // 만약 이와 같은 방법이 아니라 게시글 목록 페이지에서 props로 넘거주는 방식으로 id를 가져왔다면
  // 사용자는 게시글 목록을 꼭 거쳐야만 상세페이지로 접근 할 수 있고
  // 게시글 목록과 게시글 상세페이지의 url이 차이가 없기 때문에 상세페이지에서 새로 고침 시 게시글 목록 페이지로 돌아가는 문제나타날 수 있음
  const { postId } = useParams();

  useEffect(() => {
    async function fetchPost() {
      try {
        const response = await postApi.getPostById(postId);
        setPost(response.data.data);
      } catch (err) {
        setError(err.message);
        console.error(err.responase);
      } finally {
        setLoading(false);
      }
    }
    fetchPost();
  }, []);

  if (loading) return <div>로딩중...</div>;

  if (error.status == 404) {
    return <h3>존재하지 않는 게시글입니다.</h3>;
  }
  return (
    <div>
      <h3>{post?.title}</h3>
      <p>{post?.content}</p>
      <hr />
      <div>
        tags :
        {post?.tags?.map((tag) => {
          return <span key={tag}>#{tag} </span>;
        })}
      </div>
      <hr />
      <CommentForm setPost={setPost} postId={postId}></CommentForm>
      {post?.comments?.length ? (
        <ol>
          {post?.comments?.map((comment) => {
            return <li key={`comment-${comment.id}`}>{comment.content}</li>;
          })}
        </ol>
      ) : (
        <div>댓글이 없습니다.</div>
      )}
    </div>
  );
}
