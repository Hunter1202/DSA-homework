package Bai2;

public class Vertex {
    private int element;
    private int index;

    public Vertex(int element, int index) {
        this.element = element;
        this.index = index;
    }

    public int getElement() {
        return element;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "element=" + element +
                ", index=" + index +
                '}';
    }
}