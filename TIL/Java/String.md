: String(문자열)은 문자(char)들의 집합으로 텍스트 데이터를 표현하는데 사용되는 자료형

#### 선언 및 초기화
```Java
// 새로운 객체 생성하여 초기화
String word = new String("hello");
// 동일 객체 초기화
String word = "hello"
```

```Java
public class Main {

    public static void main(String[] args) {
        String word1 = new String("hello");
        String word2 = new String("hello");
        String word3 = "hello";
        String word4 = "hello";

        System.out.println("word1 : " + System.identityHashCode(word1));
        System.out.println("word2 : " + System.identityHashCode(word2));
        System.out.println("word3 : " + System.identityHashCode(word3));
        System.out.println("word4 : " + System.identityHashCode(word4));
    }
}

// System.identityHashCode() => 서로 다른 객체에게 다르게 부여되는 객체 자체의 고유한 번호인 해시코드를 보여줌
// word1 : 664740647
// word2 : 168423058
// word3 : 821270929
// word4 : 821270929
```

#### 문자열의 결합(Concatenation)
: 문자열은 덧셈 연산자를 통해 결합

- 문자열끼리의 덧셈 뿐만 아니라 문자열과 다른 자료형끼리도 더할 수 있음(**다른 자료형과 합쳐지면 문자열로 형변환 됨**)
- 다른 자료형 더할 때 순서가 중요
```Java
public class Main {

    public static void main(String[] args) {
        System.out.println(1 + 1 + "1");
        System.out.println("1" + 1 + 1);
        System.out.println(1 + "1" + 1);
    }
}

// 21
// 111
// 111
```
- **참고로, 문자열은 변경 불가능(immutable)하므로 결합 시 새로운 문자열이 생성된다는 것에 주의**
```Java
public class Main {

    public static void main(String[] args) {
        String word1 = "hello";
        String word2 = "world";

        System.out.println(System.identityHashCode(word1));

        word1 += word2; // word1 자기 자신에 word2를 결합

        System.out.println(System.identityHashCode(word1));
    }
}

// 664740647
// 804564176
// word1에 word2를 결합하여 새로운 문자열이 생성되면서 변수 word1에 할당되는 객체가 달라짐
```

#### String 메서드
- .length()
	: 문자열 길이 반환
- .isEmpty()
	: 문자열의 길이가 0인지의 여부(true/false)를 반환
- .isBlank()
	: 문자열의 길이가 0이거나, 공백 문자만으로 이루어져 있는지 여부(true/false)를 반환
- .charAt(문자열 인덱스)
	: 문자열의 index 번째에 위치한 문자(char)를 반환
- .toCharArray()
	: 문자열을 문자(char) 배열로 쪼개서 반환한다. 보통 향상된 for문과 함께 문자열을 순회할 때 많이 사용
```Java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String word = "banana";
        char[] characters = word.toCharArray();

        System.out.println(Arrays.toString(characters));
    }
}

// [b, a, n, a, n, a]
```

```Java
public class Main {
    public static void main(String[] args) {
        String word = "banana";
        char[] characters = word.toCharArray();

        for (char character : characters) {
            String s = String.valueOf(character);
            System.out.println(s);
        }

    }
}

// toCharArray를 통해 생성된 char를 String으로 사용하기 위해서는 형변환을 시켜줘야 함
```
- .contains(문자열)
	: 특정 문자열의 포함 여부(true/false)를 반환
- .indexOf(문자열)
	: 특정 문자열이 원본 문자열의 몇 번째 인덱스에 있는지 반환
	 - 특정 문자열이 두 글자 이상인 경우에는 처음으로 매칭되는 곳의 인덱스 번호를 반환
	 - 특정 문자열을 찾지 못한 경우에는 -1을 반환
- .trim()
	: 문자열의 앞뒤 공백을 제거한 새로운 문자열을 반환
- .replace(교체될 문자열, 교체할 문자열)
	: 교체될 문자열을 모두 교체할 문자열로 교체한 새로운 문자열을 반환
```Java
public class Main {

    public static void main(String[] args) {
        String word = "banana";
        
        System.out.println(word.replace("a", "b")); // a -> b
        System.out.println(word.replace("an", "TT")); // an -> TT
        System.out.println(word.replace("b", "")); // b를 제거하는 효과
        System.out.println(word); // 원본은 변하지 않음
    }
}

// bbnbnb
// bTTTTa
// anana
// banana
```
- .substring(시작 인덱스, 끝 인덱스)
	: 문자열을 특정 구간(시작 인덱스는 포함하며 끝 인덱스는 포함하지 않음)만큼 자른 새로운 문자열을 반환
```Java
public class Main {
    public static void main(String[] args) {
        String word = "banana";

        System.out.println(word.substring(1, 3));
    }
}

// an
```
- .split(분할할 기준 문자)
	: 분할할 기준 문자를 기준으로 분할하여 새로운 배열 반환
```Java
public class Main {

    public static void main(String[] args) {
        String sentence = "Hello new world";
        String[] tokens = sentence.split(" "); // 공백 기준 분할
        
        System.out.println(Arrays.toString(tokens));
    }
}
// [Hello, new, world]
```
- .equals(문자열)
	: 특정 문자열과 같은 문자열인지 여부(true/false)를 반환
	- 문자열과 같은 참조 자료형은 **`==`로 비교하면 값이 같은지 확인하지 않고 서로 같은 객체인지 확인**(값이 같은지 확인 => 동일성)
	- **new String()으로 문자열을 생성**하면 새로운 객체가 만들어져서 두 문자열이 같은 값을 가지더라도, **서로 다른 객체이므로 `==`로 비교했을 때 false로 판별** (객체가 같은지 확인 => 동등성)
- String.join(구분 문자, 문자열 배열)
	: 문자열 배열을 구분 문자를 기준으로 배열 요소들을 결합하여 새로운 문자열로 반환
```Java
public class Main {
    public static void main(String[] args) {
        String[] words = {"Hello", "new", "world"};
        String sentence = String.join(" ", words); // 공백 기준 결합

        System.out.println(sentence);
    }
}

// Hello new world
```

#### 문자열 포매팅(formatting)
: 동적으로 변하는 값들을 이용해서 문자열을 원하는대로 만드는 것
- `System.out.println()`과 달리, 문장의 끝에서 개행하지 않음에 주의
- `지시자(Specifier)`를 통해 각 값을 대입할 수 있다. 이때 **지시자와 값의 순서가 일치해야 함**
- **지시자의 종류**
    - `%s` : 문자열
    - `%c` : 문자
    - `%d` : 10진수
    - `%o` : 8진수
    - `%x, %X` : 16진수
    - `%f` : 부동 소수점
    - `%b` : boolean
    - `%n` : 개행
- System.out.printf(String pattern, Object.. args)
	: 지시자와 값의 순서가 일치해야 함
```Java
public class Main {
    public static void main(String[] args) {
        String pattern = "저는 %d살의 %s입니다.";
        int age = 30;
        String name = "kyle";

        System.out.printf(pattern, age, name);
    }
}

// 저는 30살의 kyle입니다.
```
- String.format(String pattern, Object.. args)
	: System.out.printf()와 달리, 바로 출력하는 것이 아니라 포매팅한 문자열 자체를 반환
```Java
public class Main {
    public static void main(String[] args) {
        String pattern = "저는 %d살의 %s입니다.";
        int age = 30;
        String name = "kyle";

        String sentence = String.format(pattern, age, name);

        System.out.println(sentence);
    }
}
// 저는 30살의 kyle입니다.
```
- MessageFormat.format(String pattern, Object.. args)
	: 지시자를 이용하지 않고 대신 0번째부터 시작하는 위치로 어디에 대입할지 결정
```Java
import java.text.MessageFormat;

public class Main {

    public static void main(String[] args) {
        String pattern = "저는 {0}살의 {1}입니다.";
        int age = 30;
        String name = "kyle";

        String sentence = MessageFormat.format(pattern, age, name);

        System.out.println(sentence);
    }
}
// 저는 30살의 kyle입니다.
```

#### StringBuilder
: 문자열은 연산 시 새로운 문자열이 계속 만들어져 메모리 효율성이 떨어져서 문자열에 대한 연산이나 변경이 잦은 경우를 위해 Java에서 **연산 시 새로운 객체가 생성되지 않고 기존 객체에 대한 내용이 변경되므로 메모리 효율성이 좋은** StringBuilder가 생겨남

- .append(문자열)
	: StringBuilder에 문자열 삽입
```Java
public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a");
        stringBuilder.append("b");
        stringBuilder.append("c");

        String word = stringBuilder.toString(); // StringBuilder -> String
        System.out.println(word);
    }
}

// abc
```

- .insert(인덱스, 문자열)
	: StringBuilder의 index 위치에 특정 문자열을 삽입
```Java
public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ACD");
        
        stringBuilder.insert(1, "B"); // 1번 인덱스에 B 삽입
        
        String word = stringBuilder.toString();
        System.out.println(word);
    }
}

// ABCD
```

- .delete(시작 인덱스, 끝 인덱스)
	: StringBuilder에서 특정 구간(시작인덱스 ~ 끝인덱스-1)만큼 문자열을 삭제
```Java
public class Main {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Algorithm");

        stringBuilder.delete(2, 6); // 2~5번째 인덱스의 문자열 삭제

        String word = stringBuilder.toString();
        System.out.println(word);
    }
}

// Althm
```

- .deleteCharAt(인덱스)
	: StringBuilder에서 특정 인덱스의 문자열 1개만 지울 수 있음
```Java
public class Main {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Algorithm");

        stringBuilder.deleteCharAt(2); // 2번째 인덱스의 문자열 삭제

        String word = stringBuilder.toString();
        System.out.println(word);
    }
}

// Alorithm
```
- .substring(시작 인덱스, 끝 인덱스)
```Java
public class Main {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Algorithm");

        String token = stringBuilder.substring(2, 6); // 2~5번째 인덱스의 문자열만큼 잘라냄
        String word = stringBuilder.toString(); 

        System.out.println(token);
        System.out.println(word);
    }
}
// gori => 원본
// Algorithm => 원본은 변하지 않음
```

- .reverse()
	: StringBuilder의 문자열을 뒤집음
```Java
 public class Main {
     public static void main(String[] args) {
         StringBuilder stringBuilder = new StringBuilder("abc");
         stringBuilder.reverse();

         String word = stringBuilder.toString(); 
         System.out.println(word);
     }
 }

// cba
```