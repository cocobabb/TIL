export default function Beverage({ name, price }) {
  return (
    <>
      <ul>
        <li>
          <span>{name}</span>
          <span>{price}</span>
        </li>
      </ul>
    </>
  );
}
