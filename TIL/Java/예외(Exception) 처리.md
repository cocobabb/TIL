## 프로그램 오류
: 프로그램이 실행 중에 어떤 원인에 의해서 오작동을 하거나 비정상적으로 종료되는 경우
- **컴파일 에러 : 컴파일 시에 발생하는 에러**
- **런타임 에러 : 실행 시에 발생하는 에러**
	- 에러(Error): 메모리 부족이나 스택 오버 플로우와 같이 발생하면 **복구할 수 없는 치명적인 오류**
	- 예외(Exception): 발생하더라도 **수습될 수 있는** 비교적 덜 치명적인 오류
- **논리적 에러 : 실행은 되지만, 의도와 다르게 동작하는 것**

### 예외 클래스
: Java에서는 실행 시 발생할 수 있는 `에러(Error)와 예외(Exception)를 클래스로 정의`
- 모든 클래스의 조상은 Object 클래스이므로, 에러와 예외 클래스도 Object의 자손
- 모든 예외의 최상위 조상은 Exception 클래스

### 예외 처리하기 (try ~ catch문)
: 프로그램 실행 시 발생할 수 있는 예외에 대비한 코드를 작성하는 것
- 프로그램의 비정상 종료를 막고, 정상적인 실행상태를 유지하기 위해 처리
- 처리되지 못한 예외는 프로그램을 비정상적으로 종료시키며 JVM의 예외 처리기(UncaughtExceptionHandler)는 예외의 원인을 콘솔에 출력
```Java
try {
    // 예외가 발생할 가능성이 있는 동작
} catch (Exception1 e) {
    // Exception1이 발생한 경우의 실행하는 동작
} catch (Exception2 e) {
    // Exception2이 발생한 경우의 실행하는 동작
} catch (Exception3 e) {
    // Exception3이 발생한 경우의 실행하는 동작
}
```
- `예외가 발생한 경우`
	1. try ~ catch문 이전의 동작을 수행
	2. try문 안에서 예외가 발생하면 발생한 **예외 클래스의 인스턴스가 생성**
	3. 맨 위 catch 블록부터 차례로 내려가면서, 생성된 예외 인스턴스가 `괄호()`내에 선언된 예외 클래스에 해당하는지 `isinstanceof` 연산자를 통해 검사
	    -  여러 catch 블록에서 처리 될 수 있는 예외는 `가장 먼저 만나는 catch 블록에서 먼저 처리`
	4. 검사 결과가 true이면 catch의 `블록{}`에 있는 동작을 모두 수행하고 try ~ catch문을 탈출
	5. try ~ catch문 이후의 동작을 수행
- `예외가 발생하지 않은 경우`
    1. try문 안에서 예외가 발생하지 않으면 catch 블록을 거치지 않고 전체 try ~ catch문을 빠져나가 이후 동작을 수행

### 예외 메시지 확인하기
: 예외가 발생했을 때, 생성되는 예외 클래스의 인스턴스에는 발생한 예외에 대한 정보가 담겨있음
- `printStackTrace()` : 스택 영역에 있던 **메서드의 정보**와 **예외 메시지**를 출력
- `getMessage()` : 예외 인스턴스에 저장된 **메시지를 반환**

#### 멀티 catch 블록
: JDK 1.7부터 여러 catch블록을 `|` 기호를 이용해 하나의 catch 블록으로 합칠 수 있음
```java
try {
    ...
} catch (Exception1 | Exception2 e) {
    e.printStackTrace();
}
```
- **연결된 예외 클래스가 상속 관계에 있다면 컴파일 에러가 발생** (다형성에 의해 동일하다고 인식)
- 예외 인스턴스 e가 정확히 어떤 타입의 예외 클래스인지 모르기 때문에, **멀티 catch 블록에서는 e의 메서드를 사용할 때, 나열된 예외 클래스들의 공통 조상에 선언된 메서드만 사용할 수 있음

### 예외 발생시키기 (throw)
: 의도적으로 예외를 발생시키는 경우 `throw` 키워드를 사용
- 보통 조건문을 이용한 값의 유효성 검증을 위해 throw 키워드를 사용
	- 예외가 발생하면 프로그램 자체가 종료되므로, 정상적이지 않은 상태에서 로직이 더 진행되는 경우를 방지 가능
```Java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("숫자를 입력하세요 : ");
        int number = scanner.nextInt();

        // 유효성 검증 (음수를 입력한 경우 예외 발생)
        if (number < 0) {
            throw new RuntimeException("0이상의 정수만 입력 가능합니다.");
        }

        System.out.println("입력하신 숫자 : " + number);
    }
}
```

### 메서드에 예외 선언하기
: 예외가 발생했을 때, try ~ catch문으로 직접 처리하는 방법 대신 `예외 처리의 책임을 메서드의 바깥으로 넘겨주는` 방법도 존재
- 메서드의 선언부에 **`throws` 키워드를 사용하여 발생할 가능성이 있는 예외에 대한 처리를 강제**
- 메서드에 예외를 선언할 때 일반적으로 RuntimeException 클래스들(Unchecked 예외: 컴파일러가 예외처리 확인하지 않는 예외)은 적지 않음 주로 Checked 예외를 선언
- throws를 통한 예외 선언은 예외를 처리하는 것이 아니라 해당 메서드를 호출한 부분에 **예외를 넘겨주는 것으로 어느 한 곳에서는 반드시 try ~ catch문을 이용해 예외처리(try~catch)를 해야 함**

### finally 블록
: `finally 블록`은 예외의 발생 여부에 관계없이 실행 되어야 할 코드를 포함 시킬 목적으로 사용
- try 블록에 return이 있다면, finally 블록의 동작들이 먼저 실행된 후 return
```Java
public class Main {

    public static void main(String[] args) {
        String result = method();
        System.out.println(result);
    }

    private static String method() {
        try {
            System.out.println("method가 호출");
            return "try 블록 안에서 return";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally 블록 실행");
        }

        return "try 블록 바깥에서 return";
    }
}
// method가 호출
// finally 블록 실행
// try 블록 안에서 return
```

### 사용자 정의 예외 만들기
: Java 표준 예외 클래스 대신, Exception 혹은 RuntimeException 클래스를 상속받아 `사용자 정의 예외 클래스`를 직접 만들 수 있음 `커스텀 예외 클래스`라고도 함
- 예외를 발생시킬 때 내가 필요한 값을 원하는대로 기록할 수 있음
- 별도의 에러 코드를 부여하기 위한 사용자 정의 예외 클래스를 선언
```Java
public class CustomException extends RuntimeException {

    private final int errorCode; // 에러 코드
    
    CustomException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    
    CustomException(String message) {
        this(message, 400); // 예외 메시지만 입력되는 경우, 자동으로 400 에러 코드로 부여
    }
    
    public int getErrorCode() {
        return this.errorCode;
    }
}
```