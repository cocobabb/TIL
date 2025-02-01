#### static
: 정적인, 고정된이라는 뜻을 가진 제어자
- 클래스 단위의 멤버에 사용
- **클래스가 최초 로딩되는 시점에 메모리에 적재**되므로 별도의 인스턴스 생성 없이도 사용

**정적 클래스 변수**
:  모든 인스턴스에서 공통적으로 사용하는 변수
- 별도의 인스턴스 생성 없이, `클래스명.변수명`의 형태로 사용
- **클래스가 최초 로딩되는 시점에 메모리에 적재**되어 **프로그램이 종료될 때까지 값 유지**

 **클래스 초기화 블록**    
: 클래스 변수의 복잡한 초기화를 위한 목적으로 사용
- 클래스가 최초 로딩되는 시점에 **`단 한 번만` 수행**된다.
- `자료형의 기본값 → 명시적인 초기화 → 클래스 초기화 블록에 의한 초기화` 순서로 초기화

 **정적 클래스 메서드**    
- 별도의 인스턴스 생성 없이, `클래스명.메서드명`의 형태로 사용
- **클래스가 최초 로딩되는 시점에 메모리에 적재**되어 **프로그램이 종료될 때까지 사용 가능**
- **클래스 메서드에서는 인스턴스 변수를 사용하거나, 인스턴스 메서드를 호출할 수 없다.**

```Java
public class Rectangle {

    // 정적 클래스 변수
    public static String color;

    // 클래스 초기화 블록
    static {
        color = "red";
    }

    // 정적 클래스 메서드
    public static void printInfomation() {
        System.out.println("사각형의 색깔 : " + color);
    }
}
```
****
#### final
: 변수, 메서드, 클래스에 사용하며 최초 선언 이후 **프로그램이 종료될 때까지 변경될 수 없음(값 재할당 불가능)**

##### final 정적 클래스 변수 => 상수(Constant)
```Java
public class Rectangle {

    // 상수
    public static final int MAX_WIDTH = 100; // 명시적인 초기화
}
```
- 클래스가 최초 로딩될 때 초기화
- 프로그램 종료 시까지 값 변경 불가능(**값 재할당 안됨) => 값 변경 시도 시 컴파일 에러**
- **대문자로만 작성**하고 **띄어쓰기는 `언더바(_)`** 로 표현
- **명시적인 초기화를 하지 않는다면 반드시 `클래스 초기화 블록에서 초기화`를 해야 함 => 안하면 컴파일 에러 발생**
```Java
public class Rectangle {

    public static final int MAX_WIDTH;
// 클래스 초기화 블록에 의한 초기화
    static {
        MAX_WIDTH = 100; 
    }
}
```


##### final 인스턴스 변수
```Java
public class Rectangle {

    // final 인스턴스 변수
    public final int width = 50; // 명시적인 초기화
}
```
- 인스턴스가 생성될 때 초기화
- 프로그램 종료 시까지 값 변경 불가능(**값 재할당 안됨) => 값 변경 시도 시 컴파일 에러**
- **명시적인 초기화를 하지 않는다면 반드시 `인스턴스 초기화 블록이나 생성자에서 초기화`를 해야 함 => 안하면 컴파일 에러 발생**

	인스턴스 초기화 블록
```Java
public class Rectangle {
	// 인스턴스 초기화 블록에 의한 초기화
    public final int width;

    {
        width = 50; 
    }
}
```
	 생성자에 의한 초기화
```Java
public class Rectangle {

    public final int width;

    public Rectangle(int width) {
        this.width = width; // 생성자에 의한 초기화
    }
}
```


##### final 지역 변수
```Java
public class Rectangle {

    public void method() {
        // final 지역 변수
        final int width = 50; // 명시적인 초기화
    }
}
```
-  메서드가 실행될 때 초기화
- 메서드 종료 시까지 값 변경 불가능(**값 재할당 안됨) => 값 변경 시도 시 컴파일 에러**
- 변수를 사용하기 전에는 반드시 값을 초기화 해야 함
```Java
public class Rectangle {

    public void method() {
        final int width = 50; // 명시적인 초기화

        final int height; // 미리 선언은 가능
        height = 20; // 하지만, 이후 사용하기 전에는 초기화 필수
        System.out.println(height);
    }
}
```


##### final 메서드
- **해당 메서드는 상속 관계에서 오버라이딩(Overriding)할 수 없음**
	-   오버라이딩(Overriding): 상속 관계에서 자식 클래스가 **부모 클래스에 작성된 메서드의 내용을 재정의하는 것**


##### final 클래스
- **해당 클래스는 상속 불가능한 클래스가 됨**
- **상속을 통해 동작이 변경되거나 확장되지 않도록** 보호하려는 경우에 사용