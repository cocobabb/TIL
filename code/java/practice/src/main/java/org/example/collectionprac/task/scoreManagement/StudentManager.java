package org.example.collectionprac.task.scoreManagement;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
//    변경사항: HashMap -> ArrayList
//    처음에는 조회하기 쉽게하기 위해 HashMap을 이용하려 했는데
//    Map은 중복되는 키값을 가질 수 없으므로 동명이인이 들어갈 수 없었음
//    => 중복된 값을 저장할 수 있는  ArrayList로 변경함
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<> ();
    }


    public void addStudent(Student student) {
        students.add(student);
    }

    public Student searchStudent(String studentName) {
        for(Student s : students){
            if(s.name.equals(studentName)){
                return s;
            }
        }
        return null;
    }

    public void showSpecificStudentInfo(Student student){
        System.out.printf("<%s>\n", student.name);
        student.showScores();
        student.showScoresAVG();
    }

    public void showStudents() {
        System.out.printf("학생 리스트: %s\n",students);
        for(Student s : students){
            System.out.printf("<%s>\n", s.name);
            s.showScores();
            s.showScoresAVG();
        }
    }


}
