#### 메서드 시그니처(Signature)
: 메서드를 식별할 수 있는 고유의 서명으로 **메서드의 이름, 매개변수의 타입, 매개변수의 개수들을 의미**
- 요소들이 모두 같으면 동일한 메서드로 취금
- **요소들 중 하나라도 같지 않으면 다른 메서드로 취급**

#### 메서드 오버로딩(Overloading)
:  하나의 클래스에서 **동일한 이름의 메서드를 여러 개 선언**하는 것
- 이름은 같아도 메서드 시그니처 요소 중 다른 것이 있다면 다른 메서드로 취급 => 여러 개 선언 가능(**반환 타입은 메서드 시그니처에 불포함**)
- 메서드의 기능은 같으나 매개변수의 타입에 따라 이름을 다르게 선언해야 하는 문제에서 생겨난 기능

#### 가변인자(Variable Arguments)
: `타입… 매개변수명` 의 형식으로 가변인자를 사용할 수 있고, **가변인자 매개변수는 배열로 취급**
- 메서드의 기능은 같으나 매개변수의 개수에 따라 이름을 다르게 선언해야 하는 문제에서 생겨난 기능

가변인자 사용 x
```Java
public class Main {

    public static void main(String[] args) {
        int result1 = add(1, 2);
        int result2 = add(1, 2, 3);
        int result3 = add(1, 2, 3, 4);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    public static int add(int number1, int number2) {
        return number1 + number2;
    }

    public static int add(int number1, int number2, int number3) {
        return number1 + number2 + number3;
    }

    public static int add(int number1, int number2, int number3, int number4) {
        return number1 + number2 + number3 + number4;
    }
}
```
****
가변인자 사용O
```Java
public class Main {

    public static void main(String[] args) {
        int result1 = add(1, 2);
        int result2 = add(1, 2, 3);
        int result3 = add(1, 2, 3, 4);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

		// 가변인자를 도입하여 여러 메서드를 하나로 통합
    public static int add(int... numbers) {
        int result = 0;

        for (int number : numbers) {
            result += number;
        }

        return result;
    }
}
```