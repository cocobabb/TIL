
## Intersection Observer API
: 타겟 요소와 상위 요소 또는 최상위 documendml viewport 사이의 intersection내의 변화를 비동기적으로 관찰
```Terminal
npm install react-intersection-observer --save
```

## 함수
```javascript
const { ref, inView } = useInView({
  triggerOnce: true,
  threshold: 0.1,
});
```
#### `useInView`
: 해당 훅은 **해당 요소가 뷰포트(Viewport)에 들어왔는지** 감지
##### 속성
- `ref`: DOM 요소에 연결할 참조값(참조할 태그의 ref 값)
- `inView`:  `ref`요소가 Viewport에 보이는 상태인지 판별하는 boolean 값
- `triggerOnce`: `ref`요소를 **한 번만 감지**할지 말지 정하는 속성
- `threshold`: `ref`요소의 **(설정한 크기)% 이상이 화면에 보이면** `inView`가 `true`로 설정됨