: 함수에서 **현재 실행 중인 코드의 컨텍스트를 참조하는 객체에 접근**하는 키워드

### 함수 내부의 this
```Javascript
function showThis() {
  console.log(this);
  // 브라우저 환경에서는 window 객체를 참조한다.
  // node.js 환경에서는 global 객체를 참조한다.
}

showThis();

```

### 메서드 내부의 this
: 메서드의 **바로 상위 컨텍스트인 함수의 객체를 참조함**
```Javascript
const person = {
  name: '철수',
  greet() {
    console.log(`안녕하세요. 저의 이름은 ${this.name} 입니다.`);
    // 안녕하세요. 저의 이름은 철수 입니다.
    // this는 객체 person을 참조한다.
  },
};

person.greet();
```
### 화살표 함수 내부의 this
: 함수의 **상위 컨텍스트의 상위 컨텍스트의 객체를 참조함** 

```Javascript
const person = {
  name: '철수',
  greet: () => {
    console.log(`안녕하세요. 저의 이름은 ${this.name} 입니다.`);
    // 화살표 함수의 this는 상위 컨텍스트의 this를 참조하므로 undefined이 출력된다.
    // 이 코드에서는 전역 컨텍스트 this를 참조한다.
  },
};

person.greet(); // 안녕하세요. 저의 이름은 undefined 입니다.

```

```Javascript
// 함수 선언식으로 된 함수의 this는 바로 상위 컨텍스트의 객체를 가리킴
const person = {
    name: '철수',
    greet () {
		    function sayHi () {
		        console.log(`안녕하세요. 저의 이름은 ${this.name} 입니다.`);
        }
        sayHi()
    },
};

person.greet(); // 안녕하세요. 저의 이름은 undefined 입니다.

```

```Javascript
// 화살표 함수로 된 함수의 this는 상위 컨텍스트의 상위컨텍스트 객체를 가리킴
const person = {
    name: '철수',
    greet() {
		    const sayHi = () => {
		        console.log(`안녕하세요. 저의 이름은 ${this.name} 입니다.`);
        }
        sayHi()
    },
};

person.greet(); // 안녕하세요. 저의 이름은 철수 입니다.

```



