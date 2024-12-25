package org.example.collectionprac.task.scoreManagement;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
//        Score korean = new Score("국어",10);
//        Score math = new Score("수학",10);
//        Score english = new Score("영어",10);
        
        Student student1 = new Student("student1",18);
        student1.setScore("국어",20);
        student1.setScore("수학",30);
        student1.setScore("영어",40);
        Student student2 = new Student("student2",18);
        student1.setScore("국어",20);
        student1.setScore("수학",30);
        student1.setScore("영어",40);
        Student student3 = new Student("student3",18);
        student1.setScore("국어",20);
        student1.setScore("수학",30);
        student1.setScore("영어",40);

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
