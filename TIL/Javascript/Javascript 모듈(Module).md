
### 모듈(Module)
- 코드를 여러 파일로 나누고, **코드를 파일 단위로 관리**하는 시스템.
- **연관성이 높은 코드들을 파일 단위로 관리**하기 때문에 **유지보수가 더 쉬워짐**
- **ES 모듈** 시스템과 **CommonJS 모듈** 시스템


### ES 모듈(ECMAScript Modules)

- **ECMAScript 6 (ES6)에서 도입된 모듈 시스템**
- 웹 브라우저와 Node.js에서 사용할 수 있다.
- 모듈 파일의 확장자는 `.js`, `.mjs` (Node.js 환경)
- **트리 쉐이킹(사용하는 모듈로부터 전체를 Import 하지 않고 사용하는 기능만 부분적으로 Import)이 가능**
- 현대 웹 개발에서 선호되는 방식이다.

##### - 기본 사용법
- 모듈 내보내기 `export`
- 모듈 불러오기 **`import ... from 파일`**
- 모듈 설정 파일 `package.json`

##### - export 방식
- **여러 값을 내보낼 수 있음**
- 불러올 때 반드시 원본 이름을 사용하거나 as로 별칭 지정한다.
- **중괄호 {} 사용이 필수**

##### - export defualt 방식
- **모듈 당 하나만 가능**
- 불러올 때 아무 이름이나 사용 가능
- **중괄호 {} 없이 사용**
```Javascript
// 모듈을 내보내는 파일
const obj = {
  name: '홍길동',
  greet() {
    console.log('안녕하세요, ' + this.name);
  }
}

export default obj
```


```Javascript
// 모듈을 불러오는 파일
import obj from './20-2.mjs';
console.log(obj.name)
obj.greet()
```


### CommonJS 모듈
- ES 모듈 이전 Node.js에서 사용된 모듈 시스템.
- 많은 Node.js 프로젝트는 CommonJS 모듈을 활용한다.
- 모듈 파일의 확장자는 `.js`

##### - 기본 사용법
- 모듈 내보내기 **`module.exports`**
- 모듈 불러오기 **`… = require(모듈)`**
- Node.js 환경

```Javascript
// 모듈을 내보내는 파일
const name = '홍길동';

function greet() {
    console.log('안녕하세요, ' + name);
}

module.exports = { name, greet };
```

```Javascript
// 모듈을 불러오는 파일
const { name, greet } = require('./20-3.cjs');

console.log(name); // '홍길동'
greet(); // '안녕하세요, 홍길동'

```
### 라이브러리(Library)
- 관련된 모듈들의 집합이다.
- **특정 기능을 수행하기 위한 도구들의 모음**


### **패키지(Package)**
- 배포 가능한 가장 작은 소프트웨어 단위
- 하나 이상의 모듈/라이브러리를 포함
- package.json 파일로 관리 (의존성, 메타데이터 등)

### 패키지(외부 모듈)
- 여러 모듈의 집합이며 **NPM(Node Package Manager)을 활용해서 프로젝트에 패키지를 설치, 삭제, 관리**
- 프로젝트에 설치된 패키지는 `package.json` 파일에 작성됨
- `package.json` 파일에 작성된 패키지 목록을 통해 다른 환경에서도 동일한 패키지를 설치 가능

##### - 예시

- Lodash
    
    - 배열, 객체, 문자열 등의 자료형을 쉽게 조작할 수 있는 함수를 제공하는 패키지
    
    [Lodash](https://lodash.com/)
    
- Axios
    
    - Promise 기반의 HTTP 클라이언트 패키지
    
    [Axios Docs](https://axios-http.com/kr/docs/intro)
    
- Moment
    
    - 날짜와 시간을 쉽게 처리하고 조작할 수 있게 도와주는 패키지
    
    [Moment.js](https://momentjs.com/)


### NPM(Node Package Manager) 기본 명령어
- **`npm install [패키지명]`**
    - 현재 프로젝트에 해당 패키지를 설치
    - **`npm install -g [패키지명]`**
        - 전역 환경 설치
        - 하나의 프로젝트가 아닌 PC 환경 전체에서 사용할 수 있게 패키지를 설치
    - **`npm install [패키지명] --save-dev`**
        - 개발용 패키지 설치
        - 배포 환경에 사용되지 않고, 오직 개발 환경에서만 사용할 수 있게 패키지를 설치
        - 배포, 운영과 관련 없는 개발 과정에만 사용되는 패키지를 설치할 때 사용하는 명령어.
- **`npm uninstall [패키지명]`**
    - 현재 프로젝트에서 해당 패키지를 삭제
- **`npm install`**
    - `package.json` 에 작성된 모든 패키지를 읽어서 설치
- **`npm update`**
    - 패키지를 최신 버전으로 업데이트
- **`npm list`**
    - 현재 프로젝트에 설치된 패키지 목록을 출력
