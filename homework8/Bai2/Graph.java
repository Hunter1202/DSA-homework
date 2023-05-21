package Bai2;

public interface Graph {
    int numVertices();
    Iterable<Integer> vertices();
    int numEdges();
    Iterable<Edge> edges();
    Edge getEdge(int u, int v);
    int[] endVertices(Edge e);
    int opposite(int v, Edge e);
    int outDegree(int v);
    int inDegree(int v);
    Iterable<Edge> outgoingEdges(int v);
    Iterable<Edge> incomingEdges(int v);
    Vertex insertVertex(int x);
    Edge insertEdge(Vertex u, Vertex v, int x);
    void removeVertex(Vertex v);
    void removeEdge(Edge e);
}