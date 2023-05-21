package Bai2;

import java.util.ArrayList;
import java.util.List;

public class DWGraph implements Graph {

    protected int numVertices;
    protected int numEdges;
    private int[][] adjacencyMatrix;
    protected List<Vertex> vertices;
    protected List<Edge> edges;

    public DWGraph(int maxVertices) {
        numVertices = 0;
        numEdges = 0;
        adjacencyMatrix = new int[maxVertices][maxVertices];
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    @Override
    public int numVertices() {
        return numVertices;
    }


    @Override
    public Iterable<Integer> vertices() {
        List<Integer> vertexList = new ArrayList<>();
        for (Vertex v : vertices) {
            vertexList.add(v.getIndex());
        }
        return vertexList;
    }

    @Override
    public int numEdges() {
        return numEdges;
    }

    @Override
    public Iterable<Edge> edges() {
        return edges;
    }

    @Override
    public Edge getEdge(int u, int v) {
        return adjacencyMatrix[u][v] != 0 ? edges.get(adjacencyMatrix[u][v] - 1) : null;
    }

    @Override
    public int[] endVertices(Edge e) {
        return new int[]{e.getSource().getIndex(), e.getDestination().getIndex()};
    }

    @Override
    public int opposite(int v, Edge e) {
        int[] endpoints = endVertices(e);
        if (v == endpoints[0]) {
            return endpoints[1];
        } else if (v == endpoints[1]) {
            return endpoints[0];
        } else {
            throw new IllegalArgumentException("Đỉnh không đối diện với cạnh.");
        }
    }

    @Override
    public int outDegree(int v) {
        int degree = 0;
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[v][i] != 0) {
                degree++;
            }
        }
        return degree;
    }

    @Override
    public int inDegree(int v) {
        int degree = 0;
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[i][v] != 0) {
                degree++;
            }
        }
        return degree;
    }

    @Override
    public Iterable<Edge> outgoingEdges(int v) {
        List<Edge> outgoing = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[v][i] != 0) {
                outgoing.add(edges.get(adjacencyMatrix[v][i] - 1));
            }
        }
        return outgoing;
    }

    @Override
    public Iterable<Edge> incomingEdges(int v) {
        List<Edge> incoming = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[i][v] != 0) {
                incoming.add(edges.get(adjacencyMatrix[i][v] - 1));
            }
        }
        return incoming;
    }

    @Override
    public Vertex insertVertex(int x) {
        Vertex v = new Vertex(x, numVertices);
        vertices.add(v);
        numVertices++;
        return v;
    }

    @Override
    public Edge insertEdge(Vertex u, Vertex v, int x) {
        int sourceIndex = u.getIndex();
        int destinationIndex = v.getIndex();
        if (adjacencyMatrix[sourceIndex][destinationIndex] != 0) {
            throw new IllegalArgumentException("Edge already exists between the vertices.");
        }
        Edge e = new Edge(u, v, x, numEdges);
        edges.add(e);
        adjacencyMatrix[sourceIndex][destinationIndex] = numEdges + 1;
        numEdges++;
        return e;
    }

    @Override
    public void removeVertex(Vertex v) {
        int index = v.getIndex();
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[index][i] != 0) {
                removeEdge(edges.get(adjacencyMatrix[index][i] - 1));
            }
            if (adjacencyMatrix[i][index] != 0) {
                removeEdge(edges.get(adjacencyMatrix[i][index] - 1));
            }
        }
        vertices.remove(index);
        numVertices--;
        for (int i = index; i < numVertices; i++) {
            vertices.get(i).setIndex(i);
        }
        for (int i = 0; i < numVertices; i++) {
            for (int j = index; j < numVertices; j++) {
                adjacencyMatrix[i][j] = adjacencyMatrix[i][j + 1];
            }
        }
        for (int i = index; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjacencyMatrix[i][j] = adjacencyMatrix[i + 1][j];
            }
        }
    }

    public void removeEdge(Edge e) {
        int index = e.getIndex();
        int sourceIndex = e.getSource().getIndex();
        int destinationIndex = e.getDestination().getIndex();
        edges.remove(index);
        adjacencyMatrix[sourceIndex][destinationIndex] = 0;
        numEdges--;
        for (int i = index; i < numEdges; i++) {
            edges.get(i).setIndex(i);
        }
    }
    public Vertex getVertexByIndex(int index) {
        if (index >= 0 && index < numVertices) {
            return vertices.get(index);
        }
        return null;
    }


//    public void printAdjacentVertices(int v) {
//        System.out.println("Các đỉnh kề của đỉnh " + v + ":");
//        for (int i = 0; i < numVertices; i++) {
//            if (adjacencyMatrix[v][i] != 0) {
//                System.out.println("Đỉnh " + i);
//            }
//        }
//    }
//
//    public void printAdjacentEdges(int v) {
//        System.out.println("Các cạnh kề của đỉnh " + v + ":");
//        for (int i = 0; i < numVertices; i++) {
//            if (adjacencyMatrix[v][i] != 0) {
//                Edge e = edges.get(adjacencyMatrix[v][i] - 1);
//                System.out.println("Cạnh từ " + v + " đến " + i + ", trọng số: " + e.getElement());
//            }
//        }
//    }

    public void printAdjacentVerticesAndEdges() {
        System.out.println("\nDanh sách các đỉnh và cạnh kề nhau trong đồ thị:");
        for (int v = 0; v < numVertices; v++) {
            System.out.println("Đỉnh " + v + ":");

            // In ra các đỉnh kề
            System.out.println("Các đỉnh kề:");
            for (int i = 0; i < numVertices; i++) {
                if (adjacencyMatrix[v][i] != 0) {
                    System.out.println("Đỉnh " + i);
                }
            }

            // In ra các cạnh kề
            System.out.println("Các cạnh kề:");
            for (int i = 0; i < numVertices; i++) {
                if (adjacencyMatrix[v][i] != 0) {
                    Edge e = edges.get(adjacencyMatrix[v][i] - 1);
                    System.out.println("Cạnh từ " + v + " đến " + i + ", trọng số: " + e.getElement());
                }
            }

            System.out.println();
        }
    }

    public void printAdjacencyMatrix() {
        System.out.println("Ma trận kề của đồ thị:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
