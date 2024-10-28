console.log(
  '--시도별 실시간 측정정보 조회의 서울의 데이터에 대해, 초 미세먼지 농도가 가장 낮은 stationName을 찾기--'
);
async function getAirData() {
  try {
    const response = await fetch(
      'https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey=nEoyfdtlzxUMT%2Bb5eHo3q%2FMdgKQxsXb1fE7STn8jkc8siwQtVCdVlAThFq6eV1DVoPtD1VZgfag2FQKZing4zA%3D%3D&returnType=json&numOfRows=100&pageNo=-&sidoName=%EC%84%9C%EC%9A%B8&ver=1.0'
    );

    const data = await response.json();
    // console.log(data);
    // console.log(data.response.body);
    const info = data.response.body;
    // console.log(info);
    // for (el in info) {
    //   console.log(el);
    // }
    // console.log(info['items']);
    const items = info['items'];
    let min_microDust = Infinity;
    let statation = null;
    items.forEach((ob) => {
      const microDust = parseInt(ob.pm25Value);
      // console.log(microDust);
      if (microDust !== NaN) {
        if (min_microDust > microDust) {
          min_microDust = microDust;
          statation = ob.stationName;
        }
        // console.log(min_microDust);
      }
    });
    console.log(statation);
  } catch (error) {
    console.error('Error:', error);
  }
}
getAirData();
