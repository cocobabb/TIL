export default function Button({ text, backgroundColor, color = "white" }) {
  console.log(color);

  return (
    <>
      <button
        style={{
          backgroundColor,
          color: color,
        }}
      >
        {text}
      </button>
    </>
  );
}
