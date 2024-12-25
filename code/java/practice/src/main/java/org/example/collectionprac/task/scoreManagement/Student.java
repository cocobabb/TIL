package org.example.collectionprac.task.scoreManagement;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    protected String name;
    private int age;
    private HashMap <String, Integer> scores;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.scores =  new HashMap <> ();
    }

    public HashMap getScores() {
        return scores;
    }

    public void setScore(String subject, int score) {
        scores.put(subject, score);
    }

    public void showScores(){
        for(String subject : scores.keySet()){
            System.out.printf("%s: %d\n", subject, scores.get(subject));
        }
    }

    public void showScoresAVG(){
        int sum = 0;
        for(int score : scores.values()){
            sum += score;
        }
        System.out.println("avg: "+ sum / scores.size());
    }

    @Override
    public String toString() {
        return name;
    }

}
