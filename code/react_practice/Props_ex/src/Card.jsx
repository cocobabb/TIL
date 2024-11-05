export default function Card({ title, content, cardSize }) {
  return (
    <>
      <div
        style={{
          width: cardSize.width,
          height: cardSize.height,
          border: cardSize.border,
        }}
      >
        <div>{title}</div>
        <div>{content}</div>
      </div>
      ;
    </>
  );
}
