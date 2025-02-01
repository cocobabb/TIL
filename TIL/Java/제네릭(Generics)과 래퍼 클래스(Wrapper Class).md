: 다양한 타입의 객체를 다루는 클래스나 메서드에 컴파일 시의 타입 체크를 해주는 기능
- <>을 사용하여 지정
- <>안에 지정된 타입만 할당 가능(타입 안정성 높임)=> **다른 타입의 값을 할당하면 `컴파일 에러` 발생**

### 제네릭 클래스
```Java
public class Test<T> {

    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
```
```Java
public class Main {

    public static void main(String[] args) {
        // 1. String으로 지정
        Test<String> test1 = new Test<String>();
        test1.setValue("Hello!");
        System.out.println(test1.getValue());

        // 2. Integer로 지정
        Test<Integer> test2 = new Test<>(); // 생성자 부분의 타입 매개변수는 생략 가능
        test2.setValue(120);
        System.out.println(test2.getValue());
    }
}
```

- 클래스명 뒤 <>을 사용하여 지정

- **타입 변수(Type Variable)**: 타입을 정해두는 것이 아니라 변수T를 통해 어떤 타입이 들어오느냐에 따라 **타입이 동적으로 지정됨**(T이외의 자유롭게 이름을 지정할 수 있음)
	=> 해당 클래스의 인스턴스를 생성 시 타입을 넣어주면 해당 타입의 값만 할당 가능한 인스턴스 생성됨

- **타입 매개변수에는 기본 자료형(int, double 등)은 대입될 수 없**으므로 **기본 자료형의 사용을 위해서는 래퍼 클래스(Integer, Double 등)를 이용**해야 함

- 제네릭 타입으로 객체나 배열을 직접 생성 할 수 없음
```Java
public class Test<T> {

    public T variable = new T(); // 직접 객체 생성 불가
    public T[] array = new T[10]; // 직접 배열 생성 불가
}

// java: Type parameter 'T' cannot be instantiated direct
```
- **static 멤버에 클래스 제네릭 타입을 사용할 수 없음(static 멤버는 클래스의 인스턴스가 생성되기 전에 이미 메모리에 할당되어 있기 때문)**

#### 제네릭 클래스 타입제한
: 제네릭으로 특정 타입으로만 가능하게 제한할 필요가 있다면 e**xtends 키워드를 사용해 상속받은 클래스와 그 하위 클래스만 받도록 설정**
```Java
public class Test<T extends Number> {

    public void show(T number) {
        System.out.println(number);
    }
}
```
```Java
public class Main {

    public static void main(String[] args) {
        Test<Integer> test = new Test<>();
        test.show(100);
    }
}
```

****
### 제네릭 메서드
: 메서드 선언부에 <>이용해 타입 파라미터(ex. `<T>`)가 선언된 메서드

- 단순히 클래스의 제네릭을 이용해 매개변수 타입을 지정한 경우에는 제네릭 메서드가 아님
```
public class Test<T> {

		// 제네릭 메서드 아님 (매개변수의 타입 T는 Test 클래스의 제네릭 T에 해당)
    public void show(T object1, T object2) {
        System.out.println(object1);
        System.out.println(object2);
    }
}
```
- 제네릭 메서드의 **타입 변수의 이름이 클래스의 타입 변수와 같더라도 독립적으로 사용**
```Java
public class Test<T> {

    private T value;

    Test(T value) {
        this.value = value;
    }

    // 이름이 T로 동일하지만, Test 클래스의 제네릭 T와는 엄연히 다른 독립적인 제네릭에 해당
		public <T> void show(T object1, T object2) {
        System.out.println(object1);
        System.out.println(object2);
    }
}
```
```Java
public class Main {

    public static void main(String[] args) {
        Test<Integer> test = new Test<>(100);
        
        // Integer가 아닌 String 타입의 인자를 넣었지만 컴파일 에러가 발생하지 않음
        // 제네릭 메서드의 타입 변수는 클래스의 타입 변수와는 별도이기 때문
        test.show("hello", "world");
    }
}
```

#### 제네릭 메서드의 와일드 카드
: 제네릭 메서드의 **매개변수 타입에 대한 제한 설정**
- `<? extends T>` :  특정 타입과 그의 하위 타입만을 허용
- `<? super T>` :  특정 타입과 그의 상위 타입만을 허용
-  `<?>` : 모든 타입을 허용 `<? extends Object>`와 동일한 개념
```Java
import java.util.List;

public class Test {

    public static void show(List<? extends Number> numberList) {
        System.out.println(numberList);
    }
}
```
****
### 래퍼 클래스(Wrapper Class)
:  Java의 `기본 자료형을 참조 자료형처럼 사용`하기 위한 포장 클래스

참조 자료형이므로 기본 자료형으로는 사용할 수 없는 다양한 메서드들을 가지고 있음

| **기본 자료형** | **래퍼 클래스** |
| ---------- | ---------- |
| byte       | Byte       |
| short      | Short      |
| char       | Character  |
| int        | Integer    |
| long       | Long       |
| float      | Float      |
| double     | Double     |
| boolean    | Boolean    |

- `박싱(Boxing)` : 기본 자료형 값을 래퍼 클래스의 인스턴스로 포장하는 과정

```java
// 기본 타입 -> 래퍼 타입
Integer boxedNumber = Integer.valueOf(10); 
```
 
- `언박싱(Unboxing)` : 래퍼 클래스의 인스턴스를 기본 자료형 값으로 꺼내는 과정
    
```java
// 래퍼 타입 -> 기본 타입
int unboxedNumber = boxedNumber.intValue(); 
```


Java 컴파일러는 박싱과 언박싱을 자동으로 처리해주기도 함
- `오토 박싱(Auto Boxing)`
- `오토 언박싱(Auto Unboxing)`
```java
Integer boxedNumber = 10; // 오토 박싱 (기본 타입 -> 래퍼 타입)
int unboxedNumber = boxedNumber; // 오토 언박싱 (래퍼 타입 -> 기본 타입)
```

래퍼 클래스는 주로 `컬렉션 프레임워크의 제네릭 타입을 위해 사용`되거나, `기본 자료형의 형 변환을 위해 사용`
```java
public class Main {

    public static void main(String[] args) {
        String byteString = "127";
        String shortString = "32767";
        String intString = "2147483647";
        String longString = "9223372036854775807";
        String floatString = "3.14";
        String doubleString = "3.141592653589793";
        String booleanString = "true";

        byte byteValue = Byte.parseByte(byteString);
        short shortValue = Short.parseShort(shortString);
        int intValue = Integer.parseInt(intString);
        long longValue = Long.parseLong(longString);
        float floatValue = Float.parseFloat(floatString);
        double doubleValue = Double.parseDouble(doubleString);
        boolean booleanValue = Boolean.parseBoolean(booleanString);

        System.out.println("byteValue: " + byteValue);
        System.out.println("shortValue: " + shortValue);
        System.out.println("intValue: " + intValue);
        System.out.println("longValue: " + longValue);
        System.out.println("floatValue: " + floatValue);
        System.out.println("doubleValue: " + doubleValue);
        System.out.println("booleanValue: " + booleanValue);
    }
}
```

```
byteValue: 127
shortValue: 32767
intValue: 2147483647
longValue: 9223372036854775807
floatValue: 3.14
doubleValue: 3.141592653589793
booleanValue: true
```