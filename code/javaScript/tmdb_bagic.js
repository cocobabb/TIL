async function getPosts() {
  try {
    const URL =
      'https://api.themoviedb.org/3/movie/now_playing?api_key=d046f52f963f62311c3f229a4705de0e';
    const response = await fetch(URL);
    const data = await response.json();
    console.log(data);
  } catch (error) {
    console.error('Error:', error);
  }
}
getPosts();

console.log('--------------------------------------------------');
// 인기있는 영화 데이터 가져오기
async function getPosts() {
  try {
    const URL =
      'https://api.themoviedb.org/3/movie/popular?api_key=d046f52f963f62311c3f229a4705de0e';
    const response = await fetch(URL);
    const data = await response.json();
    console.log(data);
  } catch (error) {
    console.error('Error:', error);
  }
}
getPosts();

console.log('--------------------------------------------------');
// 인기있는 영화 데이터 가져오기(results만)
async function getPosts() {
  try {
    const URL =
      'https://api.themoviedb.org/3/movie/popular?api_key=d046f52f963f62311c3f229a4705de0e';
    const response = await fetch(URL);
    const data = await response.json();

    const movies = data.results;
    // console.log(movies);
    console.log(movies.slice(0, 3));
  } catch (error) {
    console.error('Error:', error);
  }
}
getPosts();

console.log('--------------------------------------------------');
// 인기있는 영화 데이터 가져오기(영화제목만)
async function getPosts() {
  try {
    // base URL 만들기
    const baseURL = 'https://api.themoviedb.org/3/movie';
    const path = '/popular';
    // const params = 'api_key=d046f52f963f62311c3f229a4705de0e&language=ko';
    const params = new URLSearchParams({
      api_key: 'd046f52f963f62311c3f229a4705de0e',
      language: 'ko',
    });
    const URL = ` ${baseURL}${path}?${params} `;
    // const URL =
    // 'https://api.themoviedb.org/3/movie/popular?api_key=d046f52f963f62311c3f229a4705de0e';

    const response = await fetch(URL);
    const data = await response.json();

    const movies = data.results;
    // const movie = movies[0];
    console.log(movies);
    // console.log(movie.title);
  } catch (error) {
    console.error('Error:', error);
  }
}
getPosts();
