package Bai3;

import Bai1.Edge;
import Bai1.Graph;
import Bai1.UUGraph;

import Bai2.DWGraph;
import Bai2.Vertex;


import java.util.List;

public class Bai3 {

    public static void main(String[] args) {
        Bai1();
        Bai2();
    }

    public static void Bai1(){
        System.out.println("ĐỒ THỊ VÔ HƯỚNG KHÔNG TRỌNG SỐ (U/U): ");

        UUGraph graph = new UUGraph(5);

        graph.insertVertex();

        graph.insertEdge(0, 1);
        graph.insertEdge(1, 2);
        graph.insertEdge(2, 3);
        graph.insertEdge(3, 4);
        graph.insertEdge(4, 5);

        int numEdges = graph.numEdges();
        System.out.println("số cạnh: " + numEdges);

        List<Edge> edges = graph.edges();
        System.out.println("danh sách cạnh: " + edges);

        int numVertices = graph.numVertices();
        System.out.println("số đỉnh: " + numVertices);

        List<Integer> vertices = graph.vertices();
        System.out.println("danh sách đỉnh: " + vertices);

        graph.printVertice();

        graph.printEdge();

        graph.printAdjacencyMatrix();

    }

    public static void Bai2(){
        System.out.println("\nĐỒ THỊ CÓ HƯỚNG CÓ TRỌNG SỐ (D/W): ");
        DWGraph graph = new DWGraph(10);

        Vertex v1 = graph.insertVertex(1);
        Vertex v2 = graph.insertVertex(2);
        Vertex v3 = graph.insertVertex(3);

        Bai2.Edge e1 = graph.insertEdge(v1, v2, 10);
        Bai2.Edge e2 = graph.insertEdge(v2, v3, 5);

        int numVertices = graph.numVertices();
        int numEdges = graph.numEdges();
        System.out.println("Số đỉnh: " + numVertices);
        System.out.println("Số cạnh: " + numEdges);

        System.out.println("Danh sách các cạnh trong đồ thị:");
        for (Bai2.Edge edge : graph.edges()) {
            Vertex source = edge.getSource();
            Vertex destination = edge.getDestination();
            int weight = edge.getElement();

            System.out.println("Cạnh từ " + source.getIndex() + " đến " + destination.getIndex() + ", trọng số: " + weight);
        }

        System.out.println("Danh sách các đỉnh: ");
        for (Integer vertex : graph.vertices()) {
            System.out.println("Đỉnh: " + vertex);
        }

        graph.printAdjacentVerticesAndEdges();

        graph.printAdjacencyMatrix();

        System.out.println("\nXóa 1 đỉnh: ");
        graph.removeVertex(v1);
        int numVertice = graph.numVertices();
        System.out.println("số đỉnh: " + numVertice);

        System.out.println("Xóa cạnh: ");
        graph.removeEdge(e1);
        int numEdge = graph.numEdges();
        System.out.println("Số cạnh: " + numEdge);


    }
}
