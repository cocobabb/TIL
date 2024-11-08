export default function Button({
  backgroundColor,
  color = "white",
  onClick,
  children,
}) {
  return (
    <button onClick={onClick} style={{ backgroundColor, color }}>
      {children}
    </button>
  );
}
