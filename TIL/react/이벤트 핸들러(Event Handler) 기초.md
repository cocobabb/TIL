
#### 이벤트 핸들러를 Prop으로 전달하기
- 부모 컴포넌트
	: **Prop은** 일종의 1급객체로 **함수를 넘길 수 있고 해당 함수는 자식컴포넌트로 전달** 되어 사용 가능하다.
```Javascript
function Parents(){
	function handleClick() { alert('버튼 클릭됨!'); }
	return(
		<Button onNurm={handleClick} backgroundColor="blue" color="white">
			버튼
		</Button>
	);
}
export default Parents;
```
- 자식 컴포넌트
	: 자식 컴포넌트는 **부모 컴포넌트에서** onNurm이라는 **key이름으로 넘겨진 이벤트 핸들러에 적용될 함수를 받아서 사용**할 수 있다.
```Javascript
export default function Button({
  backgroundColor,
  color,
  onNurm,
  children,
}) {
  return (
    <button onClick={onNurm} style={{ backgroundColor, color }}>
      {children}
    </button>
  );
}
// style{{backgroundColor: backgroundColor}} 와 같이 스타일 요소와 값에 들어갈 key의 이름이 같은 겨우 위와 같이 표현 가능하다
```