console.log(
  '--시도별 실시간 측정정보 조회의 서울의 데이터를 stationName으로 접근하기 쉬운 자료구조로 재구성--'
);
async function getAirData() {
  try {
    const response = await fetch(
      'https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey=nEoyfdtlzxUMT%2Bb5eHo3q%2FMdgKQxsXb1fE7STn8jkc8siwQtVCdVlAThFq6eV1DVoPtD1VZgfag2FQKZing4zA%3D%3D&returnType=json&numOfRows=100&pageNo=-&sidoName=%EC%84%9C%EC%9A%B8&ver=1.0'
    );
    let data = await response.json();
    data = data.response.body.items;
    let stationOb = {};
    for (ob of data) {
      let stationName = ob.stationName;
      stationOb[stationName] = ob;
    }
    console.log(stationOb);

    // console.log(data);
  } catch (error) {
    console.error('Error:', error);
  }
}
getAirData();
