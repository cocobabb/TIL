export default function Name() {
  const names = ["김철수", "이영희", "박민수", "정지원", "최동욱"];
  const renderNames = names.map((name) => <li>{name}</li>);
  return <ul>{renderNames}</ul>;
}
