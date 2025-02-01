: 기존 클래스(부모 클래스)의 멤버를 새로운 클래스(자식 클래스)가 물려받아 사용하는 기능
- `extends` 키워드를 이용해 적용
- 생성자와 초기화 블록은 상속되지 않고 오로지 **멤버 변수와 메서드만 상속**
- **Java는 오직 단일 상속**만 지원 => 다중 상속 시도 시 컴파일 에러
```Java
public class Child extends Parent {
    // 자식 클래스
}
```

### super()
: 자식 클래스에서 `부모 클래스의 생성자를 호출`하는데 사용
`this()`: 같은 클래스의 다른 생성자를 호출

**자식 클래스는 부모 클래스의 모든 것을 포함**하므로, 일단 **부모 클래스의 멤버에 대한 초기화 작업이 우선되어야** 함

- 자식 클래스의 생성자의 맨 첫 줄에서 반드시 super()가 먼저 호출되어야 함
	- **super()를 생략하면, 자바 컴파일러가 부모 클래스의 기본 생성자를 호출하는 super()를 자동으로 삽입**
	
- **부모 클래스에 기본 생성자가 없다면** 자식 클래스의 생성자에서 **매개변수가 있는 super()를 명시적으로 호출**해야 함(부모 클래스에 매개변수가 있는 생성자만 존재한다면 매개변수가 없는 super()를 호출할 수 없음)
```Java
public class Parent {

    private String parentValue;
    
    // 부모 클래스에 매개변수가 있는 생성자만 존재 (기본 생성자 X => 자바 컴파일러는 매개변수 있는 생성자가 존재하면 자동으로 기본 생성자 생성하지 않음)
    public Parent(String parentValue) {
        this.parentValue = parentValue;
    }
}
```
```Java
public class Child extends Parent {

    private String childValue;

    public Child(String parentValue, String childValue) {
        super(parentValue); // 명시적으로 매개변수가 있는 super()를 호출해야 함
        this.childValue = childValue;
    }
}
```

### super
: 부모 클래스의 멤버 변수나 메서드를 참조할 때 사용

this => 인스턴스 자신에 대한 참조 변수
super => 부모에 대한 참조 변수

### Object 클래스
: 모든 클래스의 `최상위 부모 클래스`이다.

Java의 모든 클래스는 `Object 클래스를 암묵적으로 상속`받으며, 이로 인해 아래와 같은 기본 메서드를 자동으로 상속
각 클래스는 상황에 맞게 해당 메서드들을 오버라이딩하여 기능을 확장할 수 있음

| **Object 클래스의 메서드**                                                     | **설명**                                                                                 |
| ----------------------------------------------------------------------- | :------------------------------------------------------------------------------------- |
| `String toString()`                                                     | 객체 자신의 정보를 문자열로 반환                                                                     |
| `boolean equals(Object obj)`                                            | 객체 자신과 obj가 동등한 객체인지 비교                                                                |
| `int hashCode()`                                                        | 객체 자신의 해시코드를 반환                                                                        |
| Object clone()                                                          | 객체 자신의 복사본을 반환                                                                         |
| void finalize()                                                         | 가비지 컬렉션에 의해 객체가 소멸될 때 호출                                                               |
| Class getClass()                                                        | 객체 자신의 클래스 정보를 담고 있는 Class 인스턴스를 반환                                                    |
| void notify()                                                           | 현재 객체를 사용하려고 기다리는 쓰레드 중 하나를 깨움                                                         |
| void notifyAll()                                                        | 현재 객체를 사용하려고 기다리는 모든 쓰레드를 깨움                                                           |
| void wait(), void wait(long timeout),void wait(long timeout, int nanos) | 다른 쓰레드가 notify()나 notifyAll()을 호출할 때까지, 현재 쓰레드를 무한히 혹은 지정된 시간(timeout, nanos)동안 대기시킨다. |

ex)
#### toString()
: 객체 자신의 정보를 문자열로 반환하는 메서드
```Java
public class Object {
		...
		public String toString() {
		//클래스이름 + 16진수 해시코드 값
		    return getClass().getName() + "@" + Integer.toHexString(hashCode());
		}
		
		...
}
```
Overriding
```Java
public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "이름: " + this.name + ", 나이: " + this.age;
    }
}
```