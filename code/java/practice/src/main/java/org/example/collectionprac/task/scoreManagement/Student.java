package org.example.collectionprac.task.scoreManagement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Student {
    protected String name;
    private int age;

//    변경사항: Score class를 Student class에서 컴포지션하려고 했는데 
//    구현하다가 보니 불필요한 객체 생성이 많아지고 해당 클래스에 메서드로도 구현하는 방법으로도 충분하다 생각되어 
//    score 관련은 메서드로 빼고 Score class를 생성하지 않기로 함
    private Map<String, Integer> scores;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.scores =  new HashMap<> ();
    }

    public Map getScores() {
        return scores;
    }

    public void addScore(String subject, Integer score) {
        scores.put(subject, score);
    }

    public void showScores(){
        for(String subject : scores.keySet()){
//            .keySet()
//            System.out.printf("%s: %d\n", subject, scores.getOrDefault(subject, -1));
            System.out.printf("%s: %d\n", subject, scores.get(subject));
        }
    }

    public void showScoresAVG(){
        if (scores.isEmpty()){
            System.out.println("평균 낼 성적이 없습니다.");
//          *문제점: return을 사용하지 않아서 함수가 끝나지 않고 그 다음 코드가 실행됨*
//          내가 생각한 방향은 if문 조건을 충족시키는 경우 if문을 실행 후 showScoresAVG 함수가 끝나는 것 그런데 if문에 return을 넣지 않음
//          return을 해서 showScoresAVG를 함수를 끝내주지 않으면 if문 실행 후 아래 코드들도 실행된다.
            return;
        }

        Integer sum = 0;
        for(int score : scores.values()){
            sum += score;
        }
        System.out.println( "avg: "+ sum / scores.size() );
    }

    @Override
    public String toString() {
        return name;
    }


}
