const posts = [
  { id: 1, title: '첫 번째 포스트', content: '첫 번째 포스트 내용' },
  { id: 2, title: '두 번째 포스트', content: '두 번째 포스트 내용' },
  { id: 3, title: '세 번째 포스트', content: '세 번째 포스트 내용' },
];

const comments = [
  { id: 1, postId: 1, content: '첫 번째 댓글' },
  { id: 2, postId: 2, content: '두 번째 댓글' },
  { id: 3, postId: 1, content: '세 번째 댓글' },
  { id: 4, postId: 2, content: '네 번째 댓글' },
  { id: 5, postId: 3, content: '다섯 번째 댓글' },
  { id: 6, postId: 2, content: '여섯 번째 댓글' },
  { id: 7, postId: 3, content: '일곱 번째 댓글' },
  { id: 8, postId: 3, content: '여덟 번째 댓글' },
  { id: 9, postId: 1, content: '아홉 번째 댓글' },
  { id: 10, postId: 3, content: '열 번째 댓글' },
];

console.log('--모든 posts 의 번호 id, 제목 title을 출력--');
for (let ob of posts) {
  console.log(ob.id, ob.title);
}

console.log('--모든 posts 의 번호 id, 제목 title을 출력--');
for (let ob of comments) {
  if (ob.postId === 1) {
    console.log(ob);
  }
}

console.log(
  '-- 모든 posts와 comments의 객체를 출력한다. 이때, 개별 posts 에 연관된 comments를 구분해서 출력--'
);
for (ob of posts) {
  console.log(ob);
  for (obes of comments) {
    if (obes.postId == ob.id) {
      console.log(obes);
    }
  }
  console.log();
}
