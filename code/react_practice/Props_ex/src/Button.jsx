export default function Button({ text, backgroundColor, color }) {
  console.log(color);

  return (
    <>
      <button
        style={{
          backgroundColor: backgroundColor,
          color: color,
        }}
      >
        {text}
      </button>
    </>
  );
}
