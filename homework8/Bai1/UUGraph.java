package Bai1;

import java.util.ArrayList;
import java.util.List;

public class UUGraph implements Graph {
    private boolean[][] adjacencyMatrix;
    private int numVertices;
    private int numEdges;

    public UUGraph(int numVertices) {
        this.numVertices = numVertices;
        this.numEdges = 0;
        adjacencyMatrix = new boolean[numVertices][numVertices];
    }

    @Override
    public int numVertices() {
        return numVertices;
    }

    @Override
    public List<Integer> vertices() {
        List<Integer> vertices = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            vertices.add(i);
        }
        return vertices;
    }

    @Override
    public int numEdges() {
        return numEdges;
    }

    @Override
    public List<Edge> edges() {
        List<Edge> edges = new ArrayList<>();
        for (int u = 0; u < numVertices; u++) {
            for (int v = u + 1; v < numVertices; v++) {
                if (adjacencyMatrix[u][v]) {
                    edges.add(new Edge(u, v));
                }
            }
        }
        return edges;
    }

    @Override
    public Edge getEdge(int u, int v) {
        if (u >= 0 && u < numVertices && v >= 0 && v < numVertices && adjacencyMatrix[u][v]) {
            return new Edge(u, v);
        }
        return null;
    }

    @Override
    public int[] endVertices(Edge e) {
        return new int[] { e.u, e.v };
    }

    @Override
    public int opposite(int v, Edge e) {
        if (v == e.u) {
            return e.v;
        } else if (v == e.v) {
            return e.u;
        } else {
            throw new IllegalArgumentException("Vertex is not incident to the edge");
        }
    }

    @Override
    public int outDegree(int v) {
        int degree = 0;
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[v][i]) {
                degree++;
            }
        }
        return degree;
    }

    @Override
    public int inDegree(int v) {
        return outDegree(v);
    }

    @Override
    public List<Edge> outgoingEdges(int v) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[v][i]) {
                edges.add(new Edge(v, i));
            }
        }
        return edges;
    }

    @Override
    public List<Edge> incomingEdges(int v) {
        return outgoingEdges(v);
    }

    @Override
    public void insertVertex() {
        boolean[][] newMatrix = new boolean[numVertices + 1][numVertices + 1];
        for (int i = 0; i < numVertices; i++) {
            System.arraycopy(adjacencyMatrix[i], 0, newMatrix[i], 0, numVertices);
        }
        adjacencyMatrix = newMatrix;
        numVertices++;
    }

    @Override
    public void insertEdge(int u, int v) {
        if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
            if (!adjacencyMatrix[u][v]) {
                adjacencyMatrix[u][v] = true;
                adjacencyMatrix[v][u] = true;
                numEdges++;
            }
        }
    }

    @Override
    public void removeVertex(int v) {
        if (v >= 0 && v < numVertices) {
            boolean[][] newMatrix = new boolean[numVertices - 1][numVertices - 1];
            int newRow = 0;
            for (int i = 0; i < numVertices; i++) {
                if (i != v) {
                    int newCol = 0;
                    for (int j = 0; j < numVertices; j++) {
                        if (j != v) {
                            newMatrix[newRow][newCol] = adjacencyMatrix[i][j];
                            newCol++;
                        }
                    }
                    newRow++;
                }
            }
            adjacencyMatrix = newMatrix;
            numVertices--;
            numEdges = calculateNumEdges();
        }
    }

    @Override
    public void removeEdge(Edge e) {
        if (e.u >= 0 && e.u < numVertices && e.v >= 0 && e.v < numVertices && adjacencyMatrix[e.u][e.v]) {
            adjacencyMatrix[e.u][e.v] = false;
            adjacencyMatrix[e.v][e.u] = false;
            numEdges--;
        }
    }

    private int calculateNumEdges() {
        int count = 0;
        for (int u = 0; u < numVertices; u++) {
            for (int v = u + 1; v < numVertices; v++) {
                if (adjacencyMatrix[u][v]) {
                    count++;
                }
            }
        }
        return count;
    }

    public void printVertice() {
        System.out.println("Các đỉnh kề với nhau: ");
        for (int v = 0; v < numVertices; v++) {
            System.out.print("Đỉnh " + v + " kề với đỉnh: ");
            for (int u = 0; u < numVertices; u++) {
                if (adjacencyMatrix[v][u]) {
                    System.out.print(u + " ");
                }
            }
            System.out.println();
        }
    }

    public void printEdge() {
        System.out.println("Các cạnh kề với đỉnh:");
        for (int v = 0; v < numEdges; v++) {
            System.out.print("Cạnh " + v + " kề với đỉnh: ");
            for (int u = 0; u < numVertices; u++) {
                if (adjacencyMatrix[v][u]) {
                    System.out.print(u + " ");
                }
            }
            System.out.println();
        }
    }


    public void printAdjacencyMatrix(){
        System.out.println("Ma trận kề:");
        for(int i = 0; i < numVertices; i++){
            for(int j = 0; j < numVertices; j++){
                System.out.print(adjacencyMatrix[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }
    }
}
