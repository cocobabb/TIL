: 하나의 타입 안에 다른 타입의 변수를 포함시키는 것

상속은 계층 관계를 형성하는 반면, **컴포지션은 포함 관계를 형성**

상속관계
```Java
public class Address {

    private String city;
    private String street;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }
}
```
```Java
public class Building extends Address {

    public Building(String city, String street) {
        super(city, street);
    }

    public void showAddress() {
        System.out.println("시 : " + getCity());
        System.out.println("도로 : " + getStreet());
    }
}
```


컴포지션
```Java
public class Building {

    private Address address; // composition

    public Building(Address address) {
        this.address = address;
    }

    public void showAddress() {
        System.out.println("시 : " + this.address.getCity());
        System.out.println("도로 : " + this.address.getStreet());
    }
}
```
### 해당 기능이 나오게 된 배경
- 상속은 결합도를 높임
	- 합도가 높으면, 그만큼 한 쪽 클래스의 내용을 변경할 때마다, 다른 쪽 클래스의 내용도 변경해야할 가능성이 높아짐 => 유지 보수성 떨어짐
	
- Java는 다중 상속이 불가능
