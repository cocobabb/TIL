let tem = 20;
if (tem < 22) {
  console.log('보일러 좀 틀어줘');
} else {
  console.log('에어컨 좀 틀어줘');
}

let fruits = ['사과', 1, '딸기'];
console.log(fruits);
console.log(typeof fruits[0]);
console.log(typeof fruits[1]);

let uniqueValues = new Set([1, 2, 2, 3]);
console.log(uniqueValues); // Set(2) { 1, 2, 3 } 중복값 자동으로 제거됨. size:3
uniqueValues.delete(2);
console.log(uniqueValues); // Set(2) { 1, 3 }
uniqueValues.delete(2); // 오류가 발생하지 않는다.
