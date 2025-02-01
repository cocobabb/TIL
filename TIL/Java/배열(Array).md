 : 동일한 자료형의 여러 변수를 하나로 묶을 수 있는 자료구조

#### 선언 및 초기화
- 배열을 선언할 때는 `[]`를 사용함
- 보통은 `int[] numbers;`의 방법을 주로 사용
```Java
int[] numbers; 
int numbers[]; // C언어 스타일의 배열 선언
```
```Java
int[] numbers = new int[] {10, 20, 30, 40, 50}; // 선언과 동시에 원하는 값으로 초기화
int[] numbers = {10, 20, 30, 40, 50}; // 이때는 뒤의 타입 생략 가능
```

- 배열을 선언했다면 new 키워드를 이용해 값을 초기화 할 수 있음
```Java
int[] numbers; // 선언
numbers = new int[5]; // 초기화
numbers = {10, 20, 30, 40, 50}; // 문법오류 => 선언과 초기화를 따로 할 때 new 타입[]을 생략할 수 없음
```
- 배열은 길이를 초기에 지정하기 때문에 한번 생성하면 이후 길이를 늘리거나 줄일 수 없으므로 길이를 변경하고 싶다면 변경한 길이의 새로운 배열을 생성해야 함(new 연산자를 통해서 덮어씌우는 방법으로 가능)

- 길이
	.length를 이용하여 배열의 길이를 알 수 있음
```Java
public class Main {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        
        System.out.println(numbers.length); // 5
    }
}
```

#### 인덱스(Index)
: 배열에서 각각의 원소가 어느 위치에 있는지 알려주는 목차. 0부터 시작하여 순차적으로 증가

- 가장 앞에는 있는 원소는 배열의 0번째 인덱스
- 그 다음 원소들은 순서대로 1, 2, 3..번째 인덱스
- 가장 뒤에 있는 원소는 배열의 (길이 -1)번째 인덱스
- 인덱스를 통해 단순 조회 뿐만 아니라, 원소의 값을 수정할 수 있음(변수에 값을 재할당 하는 방식)

#### 배열의 특성을 이용한 특정 값 구하기

- 배열의 최솟값 구하기
```Java
public class Main {

    public static void main(String[] args) {
        int[] numbers = {30, 10, 50, 25, 100};
        int minNumber = 9999999; // 최솟값 (일단 매우 큰 수로 초기화)

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < minNumber) { 
            // 만약 배열의 원소가 최솟값보다 작으면
                minNumber = numbers[i]; // 최솟값을 갱신
            }
        }

        System.out.println(minNumber);
    }
}
```

- 배열의 최댓값 구하기
```Java
public class Main {

    public static void main(String[] args) {
        int[] numbers = {30, 10, 50, 25, 100};
        int maxNumber = -9999999; // 최댓값 (일단 매우 작은 수로 초기화)

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > maxNumber) { 
            // 만약 배열의 원소가 최댓값보다 크면
                maxNumber = numbers[i]; // 최댓값을 갱신
            }
        }

        System.out.println(maxNumber);
    }
}
```

#### 배열과 향상된(enhanced) for 문
: Java에서는 배열과 같이 여러 값을 담은 자료형에서 반복문을 사용할 때 더 편리하게 사용할 수 있도록 enhaced for문을 제공함(Javascript의 for in문과 비슷함)
```Java
public class Main {

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        for (int number : numbers) {
            System.out.println(number);
            // 10
			// 20
			// 30
			// 40
			// 50
        }
    }
}

// int number : numbers 부분은 결국 numbers에서 원소를 하나씩 꺼내서 number라는 임시 변수에 할당한다는 의미이고 number는 for문 블록 안에서만 사용할 수 있음
```
#### 배열의 정렬
- Array.sort(배열) 
	: 해당 배열의 원소를 오름차순으로 정렬
```Java
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {50, 30, 10, 40, 20};

        Arrays.sort(numbers); // 오름차순 정렬

        System.out.println(Arrays.toString(numbers));
    }
}
```