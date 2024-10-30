async function getNowPlayingMovies() {
  const baseURL = 'https://api.themoviedb.org/3/movie';
  const params = new URLSearchParams({
    api_key: 'd046f52f963f62311c3f229a4705de0e',
    // language: 'ko',
  });
  const path = '/now_playing';

  const URL = `${baseURL}${path}?${params}`;

  const response = await fetch(URL);
  const data = await response.json();

  const movies = data.results;

  return movies;
}

async function highScore_movie2() {
  const movies = await getNowPlayingMovies();
  const movie = movies.reduce((acc, cur) => {
    let accMovie_scroe = acc.vote_average;
    let curMovie_scroe = cur.vote_average;

    if (accMovie_scroe < curMovie_scroe) {
      cur;
    } else {
      acc;
    }
  });

  return movie;
}

async function main() {
  const movie = await highScore_movie2();
  // TypeError: Cannot read properties of undefined (reading 'vote_average')
  // reduce 함수에는 return 값이 필요함.
  // 위에 highScore_movie2()에서는 Array.reduce함수에는 return 값이 없고
  // highScore_movie2()의 return값만 존재
  // reduce에 return값이 없으면 다음 요소의 반복문에서 argument가 존재하지 않아서 에러남
  console.log(movie);
}

main();
