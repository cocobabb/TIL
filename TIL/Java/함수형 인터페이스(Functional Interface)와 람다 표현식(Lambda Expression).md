
### 함수형 인터페이스
: 단 하나의 추상 메서드만 존재하는 인터페이스

- default 메서드와 static 메서드는 여러 개 존재 가능
- 필수는 아니지만 함수형 인터페이스에는`@FunctionalInterface` 어노테이션을 붙이면 함수형 인터페이스 규칙을 잘 지키는지 컴파일 단계에서 확인

```Java
@FunctionalInterface
public interface Adder {

    int add(int number1, int number2);
}
```

### `[사용법 1]` 인터페이스 구현

기본적인 인터페이스의 구현을 통해, 함수형 인터페이스를 사용할 수 있다.

```java
public class MyAdder implements Adder {

    @Override
    public int add(int number1, int number2) {
        return number1 + number2;
    }
}
```

```Java
public class Main {

    public static void main(String[] args) {
        Adder adder = new MyAdder();

        System.out.println(adder.add(1, 2));
    }
}
```
1. Adder 인터페이스를 구현한 MyAdder라는 클래스를 선언
2. add 메서드를 재정의
3. main 메서드에서 MyAdder의 인스턴스를 생성하고, add 메서드를 호출
 **하나의 기능 구현을 위해 불필요하게 추가적인 클래스 파일(MyAdder)을 생성하게 된다는 단점이 존재**

### ### `[사용법 2]` 익명 클래스
```java
public class Main {

    public static void main(String[] args) {
        Adder adder = new Adder() {
            @Override
            public int add(int number1, int number2) {
                return number1 + number2;
            }
        };

        System.out.println(adder.add(1, 2));
    }
}
```

1. 별도의 클래스를 만들지 않고, main 메서드에서 바로 익명 클래스를 선언하고 add 메서드를 재정의
2. 익명 클래스의 인스턴스(adder)를 통해 add 메서드를 호출 가능
**익명 클래스를 선언하면, 불필요한 클래스 파일을 만들지 않아도 됨**

### `[사용법 3]` 람다 표현식

```java
public class Main {

    public static void main(String[] args) {
        Adder adder = (number1, number2) -> number1 + number2;

        System.out.println(adder.add(1, 2));
    }
}
```

**람다 표현식을 이용하면, 익명 클래스도 생성하지 않아도 됨**
	=> 함수형 인터페이스는 사실상 람다 표현식과 함께 쓰이기 위해 존재

****
### 람다 표현식
: 메서드를 하나의 간결한 식으로 표현한 것(함수형 프로그래밍을 지원하기 위해 자바 8 버전부터 도입)
```Java
타입 변수명 = (매개변수1, 매개변수2, ...) -> {
	구현부;
	return 결과값;
};
```
- 람다 표현식은 `람다식` 또는 `익명 함수(anonymous function)`라고도 함
- 익명 클래스의 인스턴스를 변수에 할당할 수 있는 것처럼 람다 표현식의 결과 또한 변수에 할당 가능
- **구현부가 선언부와 같은 줄에서(한 줄로) 끝나는 경우 {} 제외 가능 => 이 경우 retrun 키워드도 생략 가능(구현부가 여러 줄인 경우 {}가 필수)**
-  **매개변수가 한 개라면 ()생략하고 작성 가능**


**람다 표현식을 이용해 메서드를 간결하게 표현할 수 있는 이유는
함수형 인터페이스는 추상 메서드가 단 하나만 존재하므로
`@Override` 어노테이션이나 `메서드명`을 지정하지 않아도 어떤 메서드를 재정의할 것인지 알 수 있음**
=> 람다 표현식은 곧 추상 메서드를 재정의한 구현체가 되고 이를 변수에 할당함으로써 해당 변수는 그 메서드를 호출할 수 있게 되는 것

### 향상된 람다표현식 메서드 참조
: 클래스의 메서드를 참조하여 람다 표현식을 구성한다는 의미

- `클래스명::메서드명` 과 같은 형식으로 작성
- 함수형 인터페이스의 메서드에 어떤 타입의 매개변수가 들어가는지 반환 타입은 어떤지 이미 다 정의되어 있으므로, 컴파일러가 이를 알아서 추론 가능
```Java
@FunctionalInterface
public interface Parser {

    int parseToInt(String value);
}
```

```Java
// 람다표현식
public class Main {
    public static void main(String[] args) {
        Parser parser = value -> Integer.parseInt(value);

        System.out.println(parser.parseToInt("100"));
    }
}
```

```Java
// 메서드 참조
public class Main {
    public static void main(String[] args) {
        Parser parser = Integer::parseInt;
        System.out.println(parser.parseToInt("100"));
    }
}
```

| 구분           | 형태            |
| ------------ | ------------- |
| 클래스 메서드 참조   | `클래스명::메서드명`  |
| 인스턴스 메서드 참조  | `인스턴스명::메서드명` |
| 매개변수의 메서드 참조 | `클래스명::메서드명`  |
| 생성자 참조       | `클래스명::new`   |

##### 매개변수의 메서드 참조
```Java
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

// 람다표현식으로 표현한 경우
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        BiConsumer<List<Integer>, Integer> biConsumer = (list, number) -> list.add(number);
        biConsumer.accept(numbers, 1); // numbers.add(1); 을 호출
    }
}
```
```Java
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

// 매개변수의 메서드 참조로 표현한 경우
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        BiConsumer<List<Integer>, Integer> biConsumer = List::add;
        biConsumer.accept(numbers, 1); // numbers.add(1); 을 호출
    }
}
```

****
### 표준 함수형 인터페이스
: Java에서는 자주 사용되는 형식의 메서드를 함수형 인터페이스로 미리 정의해 놓았음

| 함수형 인터페이스      | 추상 메서드            | 설명                                     |
| -------------- | ----------------- | -------------------------------------- |
| Runnable       | void run()        | 매개변수와 반환값이 모두 없을 때 사용                  |
| Supplier<T>    | T get()           | 매개변수는 없고, 반환값만 있을 때 사용 (Consumer와 반대)  |
| Consumer<T>    | void accept(T t)  | 매개변수만 있고, 반환값이 없을 때 사용 (Supplier와 반대)  |
| Function<T, R> | R apply(T t)      | 매개변수와 반환값이 모두 있을 때 사용                  |
| Predicate<T>   | boolean test(T t) | 매개변수를 받아 조건을 검사하고 boolean 결과를 반환할 때 사용 |

#### Runnable 인터페이스
- 메서드의 **매개변수X 반환값X**
- void run() 추상 메서드가 존재
- 주로 Thread를 실행할 때 사용
- **별도의 값을 반환하지 않고 단순히 어떤 동작을 실행하는 경우에 유용**
```Java
public class Main {

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Hello World");
        runnable.run();
    }
}
```

#### Supplier 인터페이스
- 메서드의 **매개변수X 반환값O**
- `T get()` 추상 메서드가 존재
- 제네릭 타입 T를 통해 반환 타입을 원하는대로 지정 가능
- 새로운 데이터를 생성하거나 외부에서 얻어오는 **로직을 캡슐화할 때 유용**
```Java
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello World";
        System.out.println(supplier.get());
    }
}
```
#### Consumer 인터페이스
- 메서드의 **매개변수O  반환값X**
- `void accept(T t)` 추상 메서드가 존재
- 제네릭 타입 T를 통해 매개변수 타입을 원하는대로 지정 가능
- **전달받은 값을 기반으로 로그**를 남기거나, **화면에 출력**하거나, 내**부 상태를 변경**하는데 사용
```Java
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Consumer<String> consumer = string -> System.out.println(string);
        consumer.accept("Hello World");
    }
}
```

+)**두 개의 매개변수를 받을 수 있는 BiConsumer 인터페이스도 존재**
- `void accept(T t, U u)` 추상 메서드가 존재
```Java
import java.util.function.BiConsumer;

public class Main {

    public static void main(String[] args) {
        BiConsumer<String, String> biConsumer = (string1, string2) -> System.out.println(string1 + " " + string2);
        biConsumer.accept("Hello", "World");
    }
}
```
#### Function 인터페이스
- 메서드의 **매개변수O 반환값O**
- `R apply(T t)` 추상 메서드가 존재
- 제네릭 타입 T의 매개변수 타입을 통해 R의 반환 타입을 원하는대로 지정할 수 있다.

```java
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Function<String, String> function = string -> string;
        System.out.println(function.apply("Hello World"));
    }
}
```

+) 두 개의 매개변수를 받을 수 있는 BiFunction 인터페이스도 존재
- `R apply(T t, U u)` 추상 메서드가 존재

```java
import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {
        BiFunction<String, String, String> biFunction = (string1, string2) -> string1 + " " + string2;
        System.out.println(biFunction.apply("Hello", "World"));
    }
}

```

### Predicate 인터페이스
: 매개변수를 받아 조건을 검사하고 `boolean` 결과를 반환하는 작업을 정의하는 함수형 인터페이스
- Function 인터페이스의 변형
- `boolean test(T t)` 추상 메서드가 존재
```Java
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Predicate<String> predicate = string -> string.isEmpty();
        System.out.println(predicate.test("Hello World"));
    }
}
```