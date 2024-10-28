async function getMovies() {
  try {
    const baseURL = 'https://api.themoviedb.org/3/movie';
    const path = '/now_playing';
    const params = new URLSearchParams({
      api_key: 'd046f52f963f62311c3f229a4705de0e',
      // language: 'ko',
    });
    const URL = `${baseURL}${path}?${params}`;

    const response = await fetch(URL);
    const data = await response.json();
    // console.log(data);

    const movies = data.results;
    console.log('--현재 상영 중인 영화 중 평점이 가장 높은 영화1--');
    let maxVote = 0;
    let maxVote_movie = null;
    movies.forEach((movie) => {
      let movie_vote = movie.vote_average;
      // console.log(`영화제목: ${movie.title}, 영화평점: ${movie.vote_average}`);
      if (movie_vote > maxVote) {
        maxVote = movie_vote;
        maxVote_movie = movie.title;
      }
    });
    console.log(maxVote_movie); // 제일 높은 평점의 영화 제목
    console.log(maxVote); // 제일 높은 영화 평점

    console.log('--현재 상영 중인 영화 중 평점이 가장 높은 영화2--');
    const maxVote_movie2 = movies.reduce((acc, cur) => {
      let accVoteMax = acc.vote_average;
      let curVoteMax = cur.vote_average;

      if (accVoteMax > curVoteMax) {
        return acc;
      } else if (curVoteMax > accVoteMax) {
        return cur;
      } else {
        // 만약 값이 같다면 둘 중 평점의 갯수가 많은 것을 채택
        const accVoteCount = acc.vote_count;
        const curVoteCount = cur.vote_count;
        if (accVoteCount > curVoteCount) {
          return acc;
        } else if (curVoteCount > accVoteCount) {
          return cur;
        }
      }
    });
    console.log(maxVote_movie2.title);
    console.log(maxVote_movie2.vote_average);

    console.log('--평점이 가장 높은 영화의 수익--');
    // nowplaying 데이터에서 revenue와 관련된 데이터가 없음
    // >> 다른 곳에서 데이터를 찾아야 겠다.
    // >> 다른 곳 url에서 revenue 관련 데이터가 있음을 확인했음
    // >> 그 곳과 nowplaying 데이터의 공통 컬럼을 찾음
    // >> 평점 높은 데이터의 공통 컬럼 값을 찾음
    // >> 찾은 곳에서 공통 컬럼 값을 가지는 데이터만 봐서 확인
    const movieId = maxVote_movie2.id;
    console.log(`평점 최대 영화 id값: ${movieId}`);

    const detail_URL = `${baseURL}/${movieId}?${params}`;

    const response2 = await fetch(detail_URL);
    const data2 = await response2.json();
    const revenue = data2.revenue;
    console.log(revenue);

    console.log('--평점이 7 이상인 영화--');
    const highScore_movie = movies.filter((movie) => movie.vote_average >= 7);
    console.log(highScore_movie);

    console.log('-- 영화 중 평점이 가장 높은 영화의 포스터 이미지를 조회--');
    // nowplaying 데이터에서 revenue와 관련된 데이터가 없음
    // >> 다른 곳에서 데이터를 찾아야 겠다.
    // >> 다른 곳 url에서 image 관련 데이터가 있음을 확인했음
    // >> 그 곳과 nowplaying 데이터의 공통 컬럼을 찾음
    // >> 평점 높은 데이터의 공통 컬럼 값을 찾음
    // >> 찾은 곳에서 공통 컬럼 값을 가지는 데이터만 봐서 확인

    const image_URL = `${baseURL}/${movieId}?${params}`;

    const response3 = await fetch(image_URL);
    const data3 = await response3.json();
    const poster_path = data3.poster_path;

    // img가 보이는 URL을 찾는다.
    // 그 양식대로 출력
    const poster_baseURL = 'https://image.tmdb.org/t/p';
    const poster_size = 'original';
    const poster_URL = `${poster_baseURL}/${poster_size}/${poster_path}`;

    console.log(poster_URL);
  } catch (error) {
    console.error('Error:', error);
  }
}
getMovies();
