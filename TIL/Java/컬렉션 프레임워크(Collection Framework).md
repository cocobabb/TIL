: 데이터를 효율적으로 관리하고 처리하기 위한 클래스와 인터페이스의 집합
- 컬렉션 프레임워크는 `<Integer>`와 같이 내부에 담는 자료형을 <>안에 선언해야 함(제네릭이 필수적임)
### 계층 구조
인터페이스끼리 상속받을 때는 extends, 클래스가 인터페이스를 상속 받을 때는  implements 
- Iterable (Interface)
	- Collection (Interface)
		- List (Interface)
			- ArrayList (Class)
			- LinkedList (Class)
			- Vector (Class)
			- Stack (Class)
		- Queue (Interface)
			- PriorityQueue (Class)
			- Deque (Interface)
				- ArrayDeque (Class)
		- Set (Interface)
			- HashSet (Class)
			- LinkedHashSet (Class)
			- SortedSet (Interface)
				- TreeSet (Class)

- Map (Interface)
	- Hashtable (Class)
	- LinkedHashMap (Class)
	- HashMap (Class)
	- SortedMap (Interface)
		- TreeMap (Class)


### List
: **순서가 있는** 자료구조(인덱스 존재)이며, **데이터의 중복**을 허용
```Java
import java.util.ArrayList;
import java.util.List;

// 다형성을 활용하여 ArrayList 대신 다른 List 구현체가 사용되더라도 변경을 최소화 할 수 있기 때문에 생성 시 상위 타입으로 선언
List<Integer> list = new ArrayList<>();
```
- ArrayList(구현체로 많이 사용)
	: 내부 배열의 길이가 고정되어 있지 않고 동적으로 변화
	- .add(Object element) : 끝에 새로운 원소 element를 삽입
	- .add(int index, Object element) : index 위치에 새로운 원소 element를 삽입
	- .get(int index) : index 위치에 있는 원소를 조회
	- .set(int index, Object element) : index 위치에 있는 원소를, 새로운 원소 element로 `교체`
	- .size() : ArrayList의 `길이`를 반환
	- .isEmpty() : ArrayList가 `비어있는지 여부(true/false)`를 반환
	- .contains(Object element) : 특정 원소 element의 `포함 여부(true/false)`를 반환
	- .remove(int index) : 특정 index 위치의 원소를 `제거`
- LinkedList
- Vector

### Map
: **순서가 없는** 자료구조이며, 데이터를 키(key)와 값(value)의 쌍으로 저장한다. 키는 중복을 허용하지 않고, **값은 중복을 허용**
```Java
import java.util.HashMap;
import java.util.Map;

// HashMap이 다른 구현체로 사용되더라도 변경을 최소화 할 수 있기 때문에 생성 시 상위 타입으로 선언
Map<String, Integer> map = new HashMap<>();
```
- HashMap(구현체로 많이 사용)
	- .put(Object key, Object value) : 새로운 key=value 쌍을 `삽입`(**이미 해당 key에** 대한 value가 **존재한다면**, 그 value를 **새로운 값으로 `교체`**)
	- .get(Object key) : key에 해당하는 value를 `조회` (key가 존재하지 않는 경우 `null`을 반환)
	- .getOrDefault(Object key, Object defaultValue) : key에 해당하는 value를 조회(**key가 존재하지 않는다면 defaultValue를 `반환`**)
	- .size() : HashMap의 `크기`를 반환
	- .containsKey(Object key), .containsValue(Object value) : 특정 key 혹은 특정 value의 `존재 여부(true/false)`를 `반환`
	- .remove(Object key) : 특정 key에 해당하는 key=value 쌍을 `제거`
	- .keySet() : **저장된 key의 집합을 `반환`** (보통 전체 데이터를 순회하기 위해 반복문과 함께 사용)
```Java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("kyle", 2);
        map.put("alex", 1);
        map.put("haley", 5);

        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }
}
```

- LinkedHashMap
- TreeMap
- HashTable

### Set
: **순서가 없는** 자료구조이며, 데이터의 **중복을 허용하지 않**음
```Java
import java.util.HashSet;
import java.util.Set;

//// HashSet이 다른 구현체로 사용되더라도 변경을 최소화 할 수 있기 때문에 생성 시 상위 타입으로 선언
Set<Integer> set = new HashSet<>();
```
- HashSet(구현체로 많이 사용)
	- .addAll(Collection c) :  컬렉션 c의 모든 원소를 `삽입`
	- .size() : HashSet의 `크기`를 반환
	- .isEmpty() : HashSet이 `비어있는지 여부(true/false)`를 반환
	- .contains(Object element) : 특정 원소 element의 `포함 여부(true/false)`를 반환
	- .remove(Object element) : 특정 원소 element를 `제거`
- TreeSet
- LinkedHashSet