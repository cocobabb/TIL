let air;
air = 50;
if (air > 0 && air <= 50) {
  console.log('좋음');
} else if (air >= 51 && air <= 100) {
  console.log('보통');
} else if (air >= 101 && air <= 250) {
  console.log('나쁨');
} else if (air >= 251) {
  console.log('매우나쁨');
}
