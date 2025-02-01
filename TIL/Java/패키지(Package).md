
: 서로 관련된 클래스들끼리 그룹으로 묶어놓은 단위
- **패키지가 다르면  동일 이름의 클래스끼리 충돌 안됨**
-  패키지를 통해 공통 기능을 가진 클래스를 모아두면, 다른 프로젝트나 클래스에서 쉽게 재사용 가능
-  패키지를 사용하면 클래스의 접근 수준을 조절할 수 있어, **특정 클래스나 메서드를 외부에서 접근하지 못하도록 숨길 수 있음**
- 패키지 선언은 . 을 구분자로 하여 계층 구조로 작성
- 패키지명은 모두 소문자로만 띄어쓰기 없이 작성
- 예약어로 작성 불가능
- 패키지명에 띄어쓰기가 필요하다거나 예약어로 지어야 한다는 등의 예외가 필요한 경우에는,  주로 `언더바(_)`를 이용해 예외를 해결
	ex) org.example.hyphenated_name, itn_.example

#### import
: 하나의 클래스에서 **다른 패키지에 소속된 클래스를 사용하려면**, 해당 **클래스의 패키지 경로가 필요**한데 쓸 때마다 **매번 직접 명시 하면 코드의 가독성이 저하됨**
- **`import` 키워드를 이용**해 이용할 클래스의 경로를 명시하면 **어느 패키지에 속해 있는지 일일히 명시할 필요가 없음**
```Java
package com.test.execution;

import com.test.mathematics.Calculator;

public class Main {

    public static void main(String[] args) {
        int result = Calculator.add(1, 2);
        System.out.println(result);
    }
}
```

#### static import
: 정적(static) 멤버(필드 및 메서드)를 호출할 때 static import문을 사용하면, 클래스 이름까지도 생략 가능
```Java
package com.test.execution;

import static com.test.mathematics.Calculator.add;
import static com.test.mathematics.Comparator.getBigger;

public class Main {

    public static void main(String[] args) {
        int addResult = add(1, 2); // 두 수의 덧셈
        System.out.println(addResult);

        int biggerResult = getBigger(10, 20); // 두 수의 크기 비교
        System.out.println(biggerResult);
    }
}

```