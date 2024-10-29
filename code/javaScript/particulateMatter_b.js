console.log(
  '--시도별 실시간 측정정보 조회의 서울의 데이터에 대해, 초 미세먼지 농도가 가장 낮은 stationName을 찾기1--'
);

async function getAirData() {
  try {
    const response = await fetch(
      'https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey=nEoyfdtlzxUMT%2Bb5eHo3q%2FMdgKQxsXb1fE7STn8jkc8siwQtVCdVlAThFq6eV1DVoPtD1VZgfag2FQKZing4zA%3D%3D&returnType=json&numOfRows=100&pageNo=-&sidoName=%EC%84%9C%EC%9A%B8&ver=1.0'
    );

    let data = await response.json();
    data = data.response.body.items;
    let min_microDust = Infinity;
    let station = null;
    data.forEach((ob) => {
      const microDust = parseInt(ob.pm25Value);
      if (microDust !== NaN) {
        if (min_microDust > microDust) {
          min_microDust = microDust;
          station = ob.stationName;
        }
      }
    });
    console.log(station);
  } catch (error) {
    console.error('Error:', error);
  }
}
getAirData();

console.log(
  '--시도별 실시간 측정정보 조회의 서울의 데이터에 대해, 초 미세먼지 농도가 가장 낮은 stationName을 찾기2--'
);
// 측정치가 없는 값 제거하여 새 배열로 반환하는 함수
function filterNetworkError(data) {
  const results = data.filter((el) =>
    data.pm25Flag === '통신장애' ? false : true
  );
  return results;
}

async function getAirData() {
  try {
    const response = await fetch(
      'https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey=nEoyfdtlzxUMT%2Bb5eHo3q%2FMdgKQxsXb1fE7STn8jkc8siwQtVCdVlAThFq6eV1DVoPtD1VZgfag2FQKZing4zA%3D%3D&returnType=json&numOfRows=100&pageNo=-&sidoName=%EC%84%9C%EC%9A%B8&ver=1.0'
    );

    let data = await response.json();
    data = data.response.body.items;
    data = filterNetworkError(data); 

    let min_microDust = Infinity;
    let station = null;

    data.forEach((ob) => {
      const microDust = parseInt(ob.pm25Value);

      if (min_microDust > microDust) {
        min_microDust = microDust;
        station = ob.stationName;
      }
    });
    console.log(station);
  } catch (error) {
    console.error('Error:', error);
  }
}
getAirData();
