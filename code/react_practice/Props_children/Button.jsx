export default function Button({ children, backgroundColor, color = "white" }) {
  console.log(color);

  return (
    <>
      <button
        style={{
          backgroundColor,
          color: color,
        }}
      >
        {children}
      </button>
    </>
  );
}
