```Terminial
npm install framer-motion
```

## 사용법
`framer-motion.태그명` 하면 해당 태그처럼 쓰면서 애니메이션 설정을 할 수 있음
```jsx
import { motion } from "framer-motion";

export default function App() {
	return(
		<motion.div
		  initial={{ x: -100 }}
		  animate={{ x: 0 }}
		  transition={{ type: "spring", stiffness: 100 }}
	>			
		  왼쪽에서 등장
		</motion.div>
	);
}
```

- `initial`: 시작 상태
- `animate`: 애니메이션 도착 상태

- `transition`: 애니메이션의 동작 방식(속도, 타이밍, 움직임 방식 등)을 제어하는 설정
	- `type` : 애니메이션 동작 방식 종류 지정(기본값 : "spring")
		- "spring"
			- `stiffness` : 스프링의 강도. 클수록 빠르게 도달하지만 더 튕김  
			- `damping` : 마찰력. 클수록 덜 튕기고 빨리 멈춤
			- `mess` : 물체의 질량. 무거울수록 느림
		- "tween" : 시간에 따라 변화 설정(투명도, 위치, 크기 변화 등)
	- `ease` : 애니메이션 작동 속도
		- `linear` : 일정한 속도
		- `easeIn` : 천천히 시작하다가 점점 빨라짐
		- `easeOut` : 빠르게 시작하다가 천천히 멈춤
		- `easeInOut` : 천천히 시작 -> 빠름 -> 천천히  
	- `duration` : 애니메이션 실행 시간
	- `delay` : 애니메이션 시작 전 지연 시간
```jsx
<motion.div
  animate={{ x: 100 }}
  transition={{
    type: "spring",
    stiffness: 200,
    damping: 20
  }}
>
  스프링 효과
</motion.div>
```

```jsx
<motion.div
  animate={{ opacity: 1 }}
  initial={{ opacity: 0 }}
  transition={{
    type: "tween",
    duration: 1,
    ease: "easeInOut"
  }}
>
  트윈 애니메이션
</motion.div>
```


- `drag` : 태그가 드래그 가능하도록 설정
	-  `dragConstraints` : 드래그 가능 범위 설정
	- `dragTransition` : 드래그 요소과 관련된 동작 방식
		- `velocity` :초기 속도
		- `power` :  이동 거리의 강도
		- `bounceStiffness`:  튕김 정도
		- `bounceDamping` : 마찰력
```jsx
<motion.div
  drag
  dragConstraints={{ left: -100, right: 100 }}
  dragTransition={{
    bounceStiffness: 600,
    bounceDamping: 10
  }}
>
  관성 효과 (inertia)
</motion.div>
```


- `whileHover`: Hover 되는 동안 적용될 설정
- `whileTap`:  클릭되어 있는 동안 적용될 설정

- `variants` : 여러 상태 정의 및 전환
```jsx
const boxVariants = {
  hidden: { opacity: 0, x: -100 },
  visible: { opacity: 1, x: 0 },
};

<motion.div
  variants={boxVariants}
  initial="hidden"
  animate="visible"
>
  상태 전환
</motion.div>
```