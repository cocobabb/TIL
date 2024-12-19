package org.example.interfaceprac.library;

public class Book extends LibraryPhysical{
    public Book(String title, int id, String location) {
        super(title, id, location);
    }

    @Override
    void findLocation() {

    }

    @Override
    public void borrowItem() {

    }

    @Override
    public void returnItem() {

    }

    @Override
    public void isBorrowed() {

    }
}
