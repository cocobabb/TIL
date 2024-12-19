package org.example.interfaceprac.library;

public abstract class LibraryPhysical extends LibraryItem{
    String location;

    public LibraryPhysical(String title, int id, String location) {
        super(title, id);
        this.location = location;
    }

    abstract void  findLocation();
}
