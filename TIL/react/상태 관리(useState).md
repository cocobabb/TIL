: 리액트의 use로 시작하는 함수들을 hook이라고 부르는데, 다양한 훅들 중 하나로 상태 변화를 반영해야 할 때 사용하는 함수

hook: 렌더링 중에 사용하는 특별한 함수. 조건문이나 반복문, 중첩 형태 등을 자유롭게 사용할 수 없음

```Javascript
import {useState} from 'react';

const [state변수, setter함수] = useState(state의 초기값)

// 위와 같이 import해서 사용할 수 있다
```

**리액트는 지역변수의 변경 사항을 고려하지 않기 때문에 컴포넌트의 데이터 변화에 따라 업데이트하기 위해서는 다음의 두 가지가 필요하다.

-  렌더링 사이에 데이터를 유지
-  React가 새로운 데이터로 컴포넌트를 렌더링하도록 구조화

ex)
```Javascript
import { useState } from "react";
import StatusBtn from "./StatusBtn";

function App() {
  const [num, setNum] = useState(0);

  return (
    <>
      <div>{num}</div>
    
      <StatusBtn onClick={() => setNum(num + 1)}>+</StatusBtn>
      <StatusBtn onClick={() => setNum((prevNum) => prevNum - 1)}>-</StatusBtn>
  );
}
export default App;
```

**useState() 동작하는 순서**
    1. 컴포넌트가 처음 렌더링될 때, state의 초기값으로 0이 설정됨.
    2. state가 setter함수를 통해 업데이트 되면서 해당 state 관련 부분을 다시 렌더링하도록 유발
    3. 컴포넌트가 다시 렌더링 되면서 업데이트 된 state값이 반영됨.


**state의 특징**
- state는 격리되어 있어서 각각 개별의 state와 setter함수를 가질 수 있기 때문에 다른 state에 영향을 주지 않음
- 부모 컴포넌트는 자식 커포넌트의 state가 어떻게 변화하는지 관여할 수 없음 >> 다른 컴포넌트와의 결합 과정에서 불필요한 사이드이펙트를 만들지 않음



