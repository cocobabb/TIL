package org.example.collectionprac.task.scoreManagement;

public class Score {
    protected String subject;
    private int score;

    public Score(String subject, int score) {
        this.subject = subject;
        this.score = score;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return subject;
    }
}
//js class => object == map
//javascript의 객체는 클래스이다. 클래스는 객체이다. map은 클래스이며 객체이다.