
```Javascript
// JSX파일

// Profile 컴포넌트에서 넘겨준 데이터가 props라는 JSX의 객체에 담김 
function Avatar(props) {
  let person = props.person;
  let size = props.size;

  return (
    <img
      className="avatar"
      src={getImageUrl(person)}
      alt={person.name}
      width={size}
      height={size}
    />
  );
}

export default function Profile() {
  return (
    <Avatar
      person={{
        name: "Lin Lanying",
        imageId: "1bX5QH6",
      }}
      size={100}
    />
  );
}

```


```Javascript
// JSX파일

// {}를 사용하면 props객체에 있는 데이터 구조분해 할당 할 수 있음
function Avatar({ person, size = 100 }) {
  return (
    <img
      className="avatar"
      src={getImageUrl(person)}
      alt={person.name}
      width={size}
      height={size}
    />
  );
}

export default function Profile() {
  return (
    <div>
      <Avatar
        person={{ 
          name: 'Katsuko Saruhashi', 
          imageId: 'YfeOqp2'
        }}
      />
      <Avatar
        size={80}
        person={{
          name: 'Aklilu Lemma', 
          imageId: 'OKS67lh'
        }}
      />
      <Avatar
        size={50}
        person={{ 
          name: 'Lin Lanying',
          imageId: '1bX5QH6'
        }}
      />
    </div>
  );
}

```