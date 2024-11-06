async function getData() {
  const URL = 'http://192.168.100.152:5500/index.json';
  const response = await fetch(URL);
  const data = await response.json();

  console.log(data);
}

getData();
