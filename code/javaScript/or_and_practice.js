let meoney = true;
let car = true;

// money 와 car 조합해서 false 나오도록 하기
console.log(!(meoney && car));
console.log(!(meoney || car));
console.log(!meoney && !car);
console.log(!meoney || !car);
let result;
result = meoney && car ? false : true;
result = meoney || car ? false : true;
console.log(result);

console.log();
//xor (exclusive-or)
console.log(!(meoney && car) && (meoney || car));

console.log();
// 90이상 : "A" / 80점 이상:"B" / 그외: "C"
// 단 100점은 A학점과 더불어 교수님의 총애를, 40점 미만은 C학점과 더불어 학사경고를 출력
const score = 20;
if (score > 0 && score >= 90) {
  console.log('A');
  if (score === 100) {
    console.log('교수님의 총애');
  }
} else if (score > 0 && score >= 80 && score < 90) {
  console.log('B');
} else {
  console.log('C');
  if (score > 0 && score < 40) {
    console.log('학사경고');
  }
}

console.log();
// 새싹이는 주말이거나 일과시간 이후면 휴식을 취할 수 있다. 단, 주말의 일과시간 이후에는 자기개발을 할 예정이다.
// 일과시간이 09시 ~ 18시일 떄, 변수의 상태에 따라 일, 휴식, 자기개발을 출력하시오
const isWeekend = true;
const nowTime = 19;

if (isWeekend) {
  if (nowTime >= 9 && nowTime <= 18) {
    console.log('휴식');
  } else if (!(nowTime > 9 && nowTime < 18)) {
    console.log('자기개발');
  }
} else if (!isWeekend) {
  if (nowTime >= 9 && nowTime <= 18) {
    console.log('일');
  } else if (nowTime < 9 || nowTime > 18) {
    console.log('휴식');
  }
}

//
let isWorkingHour = nowTime >= 9 && nowTime <= 18;
let toDo;
if (isWeekend) {
  if (isWorkingHour) {
    toDo = '휴식';
  } else {
    toDo = '자기개발';
  }
} else {
  if (isWorkingHour) {
    toDo = '일';
  } else {
    toDo = '휴식';
  }
}
console.log(toDo);
