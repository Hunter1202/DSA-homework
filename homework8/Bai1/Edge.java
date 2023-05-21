package Bai1;

public class Edge {
    int u;
    int v;

    public Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }

    @Override
    public String toString() {
        return "\n" + "Edge{" +
                "u=" + u +
                ", v=" + v +
                '}';
    }
}
