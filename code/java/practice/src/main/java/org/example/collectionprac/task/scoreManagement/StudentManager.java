package org.example.collectionprac.task.scoreManagement;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentManager {
    private ArrayList <Student> students;

    public StudentManager() {
        this.students = new ArrayList <> ();
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
        System.out.println(students);
    }
}
