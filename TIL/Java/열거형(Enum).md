: 관련있는 상수들의 모임을 클래스로 정의한 것
- 일관된 타입의 상수를 사용하게 하여 값에 대한 `타입 안정성`을 보장
- Enum도 하나의 클래스이지만 class 키워드 대신 `enum` 키워드를 이용해 클래스를 선언
- Enum을 선언하면, 자동으로 해당 클래스는 `java.lang.Enum`을 상속

```Java
public enum 클래스명 {

    상수1,
    상수2,
    상수3,
    ...
    상수n;
}
```

- 상수들은 `쉼표(,)`를 기준으로 나열
- 마지막 상수에는 `세미콜론(;)`을 붙여야 함
- 상수들은 모두 `대문자`로 표기한다. 띄어쓰기가 있는 경우 `언더바(_)`로 대신 작성
- **상수 각각은 해당 Enum 클래스의 인스턴스에 해당**
- Enum 클래스의 인스턴스인 상수는 두 번 이상 생성될 수 없으므로 유일하므로 비교 시 `.equals()` 대신 `==`으로 비교



### 자주 사용하는 메서드

-  `.values()` : 해당 Enum의 **모든 상수를 저장한 배열을 생성하여 반환**
	- .values() 메서드는 호출될 때마다 **매번 새로운 배열을 생성하여 반환**
- `.valueOf(String name)` : 전달된 **name 문자열과 일치하는 Enum의 상수를 반환**
-  `.name()` : 해당 상수의 이름을 반환
- 기본적으로 Enum의 상수는 이름을 반환하도록 .toString()이 재정의되어 있다
-  `.ordinal()` : 해당 상수의 순서(0부터 시작)을 반환
	- 반환값은 상수의 순서에 따라 자동 증가하므로 **상수의 순서가 변경되면 기존 로직에 영향을 미칠 수 있음에 주의**


```Java
public enum Day {

    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
}
```

```Java
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // 1) .values()
        Day[] days = Day.values();
        System.out.println(Arrays.toString(days));

        // 2) .valueOf()
        Day tuesday = Day.valueOf("TUESDAY");
        System.out.println(tuesday);

        // 3) .name()
        Day friday = Day.FRIDAY;
        String fridayName = friday.name();
        System.out.println(fridayName);

        // 4) .ordinal
        int fridayOrdinal = friday.ordinal();
        System.out.println(fridayOrdinal);
    }
}

// [MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY]
// TUESDAY
// FRIDAY
// 4
```

