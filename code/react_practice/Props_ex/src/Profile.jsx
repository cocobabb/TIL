function Avatar(props) {
  // const imgUrl = "https://i.imgur.com/1bX5QH6.jpg";
  // const name = "Lin Lanying";
  // const size = 100;
  const { imgUrl, name, size } = props;
  console.log(props);
  return (
    <img
      className="avatar"
      src={imgUrl}
      alt={name}
      width={size}
      height={size}
    />
  );
}

export default function Profile() {
  return (
    <Avatar
      const
      name={"Lin Lanying"}
      imgUrl={"https://i.imgur.com/1bX5QH6.jpg"}
      size={100}
    />
  );
}
