
### 추상 클래스
: 완성되지 않은 클래스로 **다형성을 위한 상위 타입의 역할만을 수행**
추상 클래스는 자체적으로는 사용하기 힘들고, 추상 클래스를 상속한 자식 클래스에서 실질적으로 사용

- **추상 클래스는 자체 인스턴스를 생성할 수 없음**
    - 추상 클래스의 인스턴스를 생성하려고 하면 `컴파일 에러`가 발생
-  **추상 클래스는 구현부가 없는 추상 메서드를 통해, 자식 클래스에게 구현의 책임을 부여한다.**

#### 추상 메서드(Abstract Method)
: 구현부가 없는 메서드로 구현부가 없으므로 중괄호는 생략하고 매개변수를 정의하는 소괄호 이후에 세미콜론(;)을 붙임

- 추상 메서드는 추상 클래스를 상속한 자식 클래스에서 재정의(오버라이딩)하여 구현부를 정의해야 함 => 재정의 하지 않으면 `컴파일 에러`발생
```Java
public abstract class Parent {

    public abstract void hello(); // 추상 메서드
}
```
```Java
public class Child extends Parent {

    @Override
    public void hello() {
        System.out.println("Hello World!"); // 구현부 재정의
    }
}
```
****

### 인터페이스
: 각 구현 클래스들이 어떤 기능을 필수로 구현해야 하는지를 정의한 추상 클래스를 말함
```Java
public interface Interface {

    int NUMBER = 2;

    void abstractMethod1();
    void abstractMethod2(int number);
    void abstractMethod3(int number1, int number2);
}
```
- 인터페이스의 변수는 `public static final`로 취급
- 인터페이스의 메서드는 `public abstract`로 취급
- **다중 구현을 지원(상속과 달리 여러 클래스 `implements` 가능)**
```Java
public interface Parent1 {

    void parent1Method();
}
```
```Java
public interface Parent2 {

    void parent2Method();
}
```
```Java
public class Child implements Parent1, Parent2 {

    @Override
    public void parent1Method() {
        // Parent1의 메서드를 구현
    }

    @Override
    public void parent2Method() {
        // Parent2의 메서드를 구현
    }
}
```
- 상속 키워드 대신 `implements`를 사용
- 인터페이스의 메서드는 모두 추상 메서드이기 때문에, 구현 클래스에서는 이를 반드시 재정의해야 함 => 재정의 하지 않으면 `컴파일 에러` 발생
- 메서드 재정의 시 접근 제어자는 부모 클래스 메서드의 접근 제어자보다 같거나 넓은 범위여야 함
	- 인터페이스의 메서드는 기본적으로 public이므로, 재정의 할 때 메서드의 접근 제어자를 무조건 public으로 설정됨

|                | 추상 클래스                            | 인터페이스                                                 |
| -------------- | --------------------------------- | ----------------------------------------------------- |
| 키워드            | abstract class                    | interface                                             |
| 목적             | 상위 클래스에서 공통 속성/메서드를 제공하며, 일부만 추상화 | 클래스가 어떤 기능(메서드 집합)을 가져야 하는지에 대한 명세 역할                 |
| 설계 관점          | “미완성된 클래스”로서 상속 계층 내 공통 구조 제공     | “기능 명세서”로서 다양한 구현체를 하나의 타입으로 다루기 위한 규약 제공             |
| 멤버 구성          | 필드, 생성자, 추상 메서드, 일반 메서드           | 상수, 추상 메서드, default 메서드, static 메서드, private 메서드      |
| 변수             | 일반 변수 선언 가능                       | public static final로 취급 (즉, 상수만 가능)                   |
| 메서드            | 추상 메서드, 일반 메서드 모두 선언 가능           | public abstract로 취급 (default, static, private 메서드 제외) |
| 인스턴스 생성        | 직접 생성 불가                          | 직접 생성 불가                                              |
| 다형성 지원         | 가능                                | 가능                                                    |
| 상속(구현)         | 단일 상속만 가능                         | 다중 구현 가능                                              |
| 추가 메서드 정의 시 영향 | 하위 클래스가 영향을 받지 않음                 | 기존 구현 클래스가 영향을 받을 수 있으나 default 메서드로 해결 가능            |
****

+)
#### 인터페이스의 static 메서드
Java 8 이전에는 인터페이스에 추상 메서드만 정의할 수 있었음
=> 인터페이스를 구현한 클래스들에서 공통으로 필요한 static 메서드를 구현하기 위해서는 별도의 클래스를 따로 만들어서 구현해야만 했음

해결: **Java 8 버전부터**는 **인터페이스에도 static 메서드를 정의할 수 있게 됨**
```Java
public interface Interface {

    static void staticMethod() {
        // static 메서드 구현
    }
}
```
- 인터페이스의 **static 메서드도 public 접근 제어자를 가진 것으로 취급**
- `인터페이스명.인터페이스 메서드`의 형태로 호출 가능

#### 인터페이스의 default 메서드
인터페이스에 새로 메서드를 추가
=> 인터페이스를 구현하고 있던 클래스들은 모두 새로 추가된 메서드를 재정의해야 함

해결: **Java 8 버전부터는 인터페이스에 default 메서드를 작성**
```Java
public interface Parent {

    void method();
    
    default void additionalMethod() {
        // Parent 인터페이스에서 구현
    }
}
```
- 인터페이스의 default 메서드도 public 접근 제어자를 가진 것으로 취급
- **자체 구현부를 가질 수 있음**
- 인터페이스 static 메서드와 달리 default 메서드는 **구현 클래스를 통해서만 호출이 가능**하다. (`인터페이스명.인터페이스 메서드`로 호출 불가능)
- 구현 클래스에서는 default 메서드를 반드시 재정의하지 않아도 됨
	- 기존 로직을 그대로 사용해도 되고, 만약 새로운 로직이 필요하다면 그 때 재정의
		=> **기존 구현 클래스에 대한 수정 없이도 인터페이스에 새로운 메서드를 추가**할 수 있게 된다.
    
    ```java
    public class Child1 implements Parent {
    
        @Override
        public void method() {
            // Child1에서 method 구현
        }
        
        // Child1은 additionalMethod를 재정의하지 않음
    }
    ```
    
    ```java
    public class Child2 implements Parent {
    
        @Override
        public void method() {
            // Child2에서 method 구현
        }
    
        @Override
        public void additionalMethod() {
            // Child2에서 additionalMethod 재정의
        }
    }
    ```

#### 인터페이스의 private 메서드
static이나 default 메서드에서의 중복

해결: **Java 9 버전부터는 인터페이스에 private 메서드를 정의하는 것도 허용**
ex)
```java
public interface Interface {

    default void defaultMethod1() {
        System.out.println("이것은 디폴트 메서드입니다.");
        System.out.println("디폴트 메서드 중에서도 1번입니다.");
    }

    default void defaultMethod2() {
        System.out.println("이것은 디폴트 메서드입니다.");
        System.out.println("디폴트 메서드 중에서도 2번입니다.");
    }
}
```
1. 두 개의 default 메서드에서 코드의 중복이 발생
	- 이를 줄이기 위해서는 별도의 메서드로 분리할 수 있는데, 인터페이스는 public 메서드만 허용하기 때문에 public 메서드로만 분리해야 함
		=> but 분리된 내용은 외부에서 사용하는 것이 아니라 오직 인터페이스 내부에 있는 default 메서드에서만 사용하는 것


```java
public interface Interface {

    default void defaultMethod1() {
        printDefaultMethod(1);
    }

    default void defaultMethod2() {
        printDefaultMethod(2);
    }

		// 중복 코드는 private 메서드로 분리
    private void printDefaultMethod(int number) {
        System.out.println("이것은 디폴트 메서드입니다.");
        System.out.println("디폴트 메서드 중에서도 " + number + "번입니다.");
    }
}
```

1. `printDefaultMethod(int number)` 메서드는 private 접근 제한을 가지므로 인터페이스 내부에서만 사용 가능
	- default 메서드들의 코드 중복을 줄이는 목적으로 사용 가능

 참고로 private 접근 제한은 default 메서드 뿐만 아니라 static 메서드에도 적용할 수 있음