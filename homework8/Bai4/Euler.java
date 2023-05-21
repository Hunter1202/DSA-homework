package Bai4;

import Bai2.DWGraph;
import Bai2.Edge;
import Bai2.Vertex;

public class Euler extends DWGraph {

    public Euler(int maxVertices) {
        super(maxVertices);
    }

    public void eulerPath() {

        numVertices = 0;
        numEdges = 0;
        vertices.clear();
        edges.clear();

        Vertex v0 = insertVertex(0);
        Vertex v1 = insertVertex(1);
        Vertex v2 = insertVertex(2);
        Vertex v3 = insertVertex(3);

        insertEdge(v0, v1, 0);
        insertEdge(v1, v2, 0);
        insertEdge(v2, v3, 0);

        numVertices = vertices.size();
        numEdges = edges.size();
        System.out.println("Đồ thị tm đường đi Euler: ");
    }

    public void eulerCycle() {
        numVertices = 0;
        numEdges = 0;
        vertices.clear();
        edges.clear();

        Vertex v0 = insertVertex(0);
        Vertex v1 = insertVertex(1);
        Vertex v2 = insertVertex(2);
        Vertex v3 = insertVertex(3);

        insertEdge(v0, v1, 0);
        insertEdge(v1, v2, 0);
        insertEdge(v2, v3, 0);
        insertEdge(v3, v0, 0);

        numVertices = vertices.size();
        numEdges = edges.size();
        System.out.println("Đồ thị tm chu trình Euler: ");
    }

    public void printGraph() {
        System.out.println("Số đỉnh: " + numVertices);
        System.out.println("Số cạnh: " + numEdges);

        System.out.println("Các đỉnh:");
        for (Vertex v : vertices) {
            System.out.println("Đỉnh " + v.getIndex() + ": " + v.getElement());
        }

        System.out.println("Các cạnh:");
        for (Edge e : edges) {
            int[] endpoints = endVertices(e);
            int u = endpoints[0];
            int v = endpoints[1];
            System.out.println("Cạnh " + e.getIndex() + ": " + u + " -> " + v);
        }
    }


    public static void main(String[] args) {
        Euler eulerGraph = new Euler(10);
        eulerGraph.eulerPath();
        eulerGraph.printGraph();

        System.out.println();

        eulerGraph = new Euler(10);
        eulerGraph.eulerCycle();
        eulerGraph.printGraph();
    }
}
