package Bai2;

public class Edge {
    private Vertex source;
    private Vertex destination;
    private int element;
    private int index;

    public Edge(Vertex source, Vertex destination, int element, int index) {
        this.source = source;
        this.destination = destination;
        this.element = element;
        this.index = index;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getDestination() {
        return destination;
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
        return "\n"+"Edge{" +
                "source=" + source +
                ", destination=" + destination +
                ", element=" + element +
                ", index=" + index +
                '}';
    }
}