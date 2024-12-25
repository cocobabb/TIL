package org.example.composition;

public class Person{
    private String name;
    public Pencil pencil;
    public Pencil[] pencils;
    public Tool tool;

    public Person(String name, Pencil pencil) {
        this.name = name;
        this.pencil = pencil;
    }

    public Person(String name, Pencil[] pencils) {
        this.name = name;
        this.pencils = pencils;
    }

    public Person(String name, Tool tool) {
        this.name = name;
        this.tool = tool;
    }


    public void write(String writing) {
        pencil.write(writing);
    }

    public void writeMany(String writing) {
        for(Pencil p : pencils) {
            p.write(writing);
        }
    }

    public void use() {
        tool.useTool();
    }

}
