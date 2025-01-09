package org.example.collectionprac.task.scoreManagement;

public class Main {
    public static void main(String[] args) {
//    변경사항: Score class를 Student class에서 컴포지션 -> Student class의 메서드로 대체
//    Score class를 Student class에서 컴포지션하려고 했는데 구현하다가 보니
//    불필요한 객체 생성이 많아지고 해당 클래스에 메서드로도 구현하는 방법으로도 충분하다 생각되어
//    score 관련은 메서드로 빼고 Score class를 생성하지 않기로 함
        //     컴포지션(Composition)
//       => 하나의 클래스의 멤버 변수로 다른 클래스 타입의 참조형 변수를 가지는 것
//        Score korean = new Score("국어",10);
//        Score math = new Score("수학",10);
//        Score english = new Score("영어",10);
        
        Student student1 = new Student("student1",18);
        student1.addScore("국어",20);
        student1.addScore("수학",30);
        student1.addScore("영어",40);
        Student student2 = new Student("student2",18);
        student1.addScore("국어",20);
        student1.addScore("수학",30);
        student1.addScore("영어",40);
        Student student3 = new Student("student3",18);
        student1.addScore("국어",20);
        student1.addScore("수학",30);
        student1.addScore("영어",40);

        System.out.printf("<%s>\n", student1.name);
        student1.showScores();
        student1.showScoresAVG();

        System.out.println("-----------Student Manager----------");
        StudentManager stuManager = new StudentManager();
        stuManager.addStudent(student1);
        stuManager.addStudent(student2);
        stuManager.addStudent(student3);
        stuManager.showStudents();
        Student searchStu = stuManager.searchStudent("student1");
        stuManager.showSpecificStudentInfo(searchStu);

    }
}
