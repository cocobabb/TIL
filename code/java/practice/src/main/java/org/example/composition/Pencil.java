package org.example.composition;

public class Pencil implements Tool{
    protected String color;
    protected String writing;
    public Tool tool;

    public Pencil(String color) {
        this.color = color;
    }

    public Pencil(String color, Tool tool) {
        this.color = color;
        this.tool = tool;
    }

    public void write(String writing) {
        this.writing = writing;
        System.out.println("writing: " + this.writing);
        System.out.println("color: " + color);
    }

    @Override
    public void useTool() {
        write("tool");
    }
}
