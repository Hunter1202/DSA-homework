package Bai1;

import java.util.List;

public interface Graph {
    int numVertices();
    List<Integer> vertices();
    int numEdges();
    List<Edge> edges();
    Edge getEdge(int u, int v);
    int[] endVertices(Edge e);
    int opposite(int v, Edge e);
    int outDegree(int v);
    int inDegree(int v);
    List<Edge> outgoingEdges(int v);
    List<Edge> incomingEdges(int v);
    void insertVertex();
    void insertEdge(int u, int v);
    void removeVertex(int v);
    void removeEdge(Edge e);
}
