import axios from "axios";

async function fetchData() {
  const response = await fetch("https://jsonplaceholder.typicode.com/");
  const jsonData = await response.json();

  console.log(jsonData);
}
fetchData();

async function fetchDataWithAxios(params) {
  const url = "https://jsonplaceholder.typicode.com/";
  const response = await axios({
    url: url,
  });
  console.log(response.data);
}
fetchDataWithAxios();
