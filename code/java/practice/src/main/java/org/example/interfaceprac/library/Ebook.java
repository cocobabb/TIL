package org.example.interfaceprac.library;

public class Ebook extends LibraryItem implements Downloadable{
    protected boolean isDownloadable;

    public Ebook(String title, int id, boolean isDownloadable) {
        super(title, id);
        this.isDownloadable = true;
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

    @Override
    public void download() {

    }

    @Override
    public void isDownloadable() {

    }
}
