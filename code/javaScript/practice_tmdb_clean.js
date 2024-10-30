const baseURL = 'https://api.themoviedb.org/3/movie';
const params = new URLSearchParams({
  api_key: 'd046f52f963f62311c3f229a4705de0e',
  // language: 'ko',
});

// 현재 상영 중인 영화정보 가지고 있는 배열 가져옴
async function getNowPlayingMovies() {
  const path = '/now_playing';

  const URL = `${baseURL}${path}?${params}`;

  const response = await fetch(URL);
  const data = await response.json();

  const movies = data.results;
  return movies;
}

// 현재 상영 중인 영화 중 평점이 높은 영화 객체 반환(forEach)
function highScore_movie(movies) {
  let high_movie = -Infinity;
  let movieOb = {};
  movies.forEach((movie) => {
    if (movie.vote_average > high_movie) {
      high_movie = movie.vote_average;
      movieOb = movie;
    }
  });
  return movieOb;
}
// 현재 상영 중인 영화 중 평점이 높은 영화 객체 반환(reduce)
function highScore_movie2(movies) {
  const movie = movies.reduce((acc, cur) => {
    let accMovie_scroe = acc.vote_average;
    let curMovie_scroe = cur.vote_average;

    if (accMovie_scroe < curMovie_scroe) {
      return cur;
    } else {
      return acc;
    }
  });

  return movie;
}
// 평점 높은 영화 객체 받아서 연관된 다른 데이터 불러오기
async function movie_detail(movie) {
  const path = `/${movie.id}`;
  const URL = `${baseURL}${path}?${params}`;

  const response = await fetch(URL);
  const data = await response.json();
  return data;
}
// 영화객체 배열 받아와서 평점 7이상 영화객체 반환
function getMovies_score7(movies) {
  const socore7 = movies.filter((movie) => movie.vote_average >= 7);
  return socore7;
}

// 평점 높은 영화객체에서 포스터 path를 가져오고 포스터 이미지를 가져오는 url 규칙에 맞게 배열한 후 주소 반환
async function getPosterImg(movie) {
  const poster_baseURL = 'https://image.tmdb.org/t/p';
  const poster_size = 'original';
  const poster_URL = `${poster_baseURL}/${poster_size}/${movie.poster_path}`;

  return poster_URL;
}

async function main() {
  // 현재 상영중인 영화객체 배열을 가져온다.
  const movies = await getNowPlayingMovies();
  // console.log(movies);

  // 현재 상영 중인 영화 중 평점이 가장 높은 영화
  // forEach 함수 활용
  console.log(
    '--현재 상영 중인 영화 중 평점이 가장 높은 영화(forEach 함수 활용)--'
  );
  const movie = highScore_movie(movies); // 평점 높은 영화 객체
  const high_movie = movie.title; //평점 높은 영화 제목
  const highMovie_score = movie.vote_average; //평점
  console.log(high_movie);
  console.log(highMovie_score);

  // reduce 함수 활용
  console.log(
    '--현재 상영 중인 영화 중 평점이 가장 높은 영화(reduce 함수 활용)--'
  );
  const movie2 = highScore_movie2(movies);
  const high_movie2 = movie2.title;
  const highMovie_score2 = movie2.vote_average;
  console.log(high_movie);
  console.log(highMovie_score);

  // 현재 상영 중인 영화 중 평점이 가장 높은 영화의 수익
  console.log('--현재 상영 중인 영화 중 평점이 가장 높은 영화의 수익--');
  const detail = await movie_detail(movie);
  const revenue_highMovie = detail.revenue;
  console.log(revenue_highMovie);

  // 현재 상영 중인 영화 중 평점이 7 이상인 영화
  console.log('--현재 상영 중인 영화 중 평점이 7 이상인 영화--');
  const socore7 = getMovies_score7(movies);
  for (ob of socore7) {
    console.log(ob.title);
  }

  // 현재 상영 중인 영화 중 영화 중 평점이 가장 높은 영화의 포스터 이미지를 조회
  console.log(
    '--현재 상영 중인 영화 중 영화 중 평점이 가장 높은 영화의 포스터 이미지를 조회--'
  );
  const posterImg = await getPosterImg(movie);
  console.log(posterImg);
}

main();
