package org.example.interfaceprac.library;

// 추상클래스이기 때문에 interface의 메서드 구현이 강제 되지않음
// => but, 해당 추상클래스를 상속 받는 클래스는 다 구현이 강제됨 
public abstract class LibraryItem implements Borrowable {
    String title;
    int id;
    boolean isBorrowed;

    public LibraryItem(String title, int id) {
        this.title = title;
        this.id = id;
        this.isBorrowed = false;
    }
}
