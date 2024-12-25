package org.example.composition;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------사람과 펜---------------" );
        Pencil pinkPencil = new Pencil("pink");
        Person personHavePencil = new Person("hoho",pinkPencil);

        personHavePencil.write("안녕");

        System.out.println("-----------사람과 여러 펜-----------");
//        여러 펜을 가지고 있는 경우
        Pencil red = new Pencil("red");
        Pencil blue = new Pencil("blue");
        Pencil yellow = new Pencil("yellow");
        Pencil[] pencils = {red, blue, yellow};

        Person hihi = new Person("hihi", pencils);
        hihi.writeMany("잘가");

        System.out.println("----------------인터페이스 이용-------------------");
//        pencil 객체의 타입이 Pencil로 되면 person1객체에는 Pencil타입의 객체가 들어가고
//        person1객체는 여러 생성자 종류 중 Pencil 타입의 파라미터를 가지는 생성자로 생성되면서 tool필드의 값이 초기화 되지않음 
//        => 그럼 use()함수에는 tool필드의 useTool()메서드를 실행하는데 tool 필드가 null이기 때문에 실행 시 에러남
//        Pencil pencil = new Pencil("red");
        System.out.println("<펜>");
        Tool pencil = new Pencil("red");
        Person person1 = new Person("beemo", pencil);
        System.out.println(person1.tool);
        person1.use();

        System.out.println("<차>");
        Engine e2 = new Engine(300);
        Car car2 = new Car("car", e2);
        Person carPerson = new Person("carPerson", car2);
        carPerson.use();

        System.out.println("---------------엔진과 차---------------" );
        Engine e = new Engine(300);
        Car car = new Car("car", e);
        car.acclerate();
    }
}
