import algorithms.dijkstra.Dijkstra;
import graph.Edge;
import graph.Graph;
import graph.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        new Client().testDijkstra();
    }

    private void testDijkstra() {
        List<Vertex> vertexList = getVertexList(8);
        List<Edge> edgeList = getEdgeList(vertexList);
        Graph graph = new Graph(vertexList, edgeList);
        Dijkstra dijkstra = new Dijkstra(graph.getVertices(), vertexList.get(1));
        dijkstra.algorithm();
    }

    private List<Vertex> getVertexList(int count) {
        List<Vertex> vertexList = new ArrayList<>(count);
        for (int number = 1; number <= count; number++) {
            vertexList.add(new Vertex(number));
        }
        return vertexList;
    }

    private List<Edge> getEdgeList(List<Vertex> vertexList) {
        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge(vertexList.get(0), vertexList.get(1), 8));
        edgeList.add(new Edge(vertexList.get(0), vertexList.get(2), 2));
        edgeList.add(new Edge(vertexList.get(0), vertexList.get(3), 5));

        edgeList.add(new Edge(vertexList.get(1), vertexList.get(3), 2));
        edgeList.add(new Edge(vertexList.get(1), vertexList.get(5), 13));

        edgeList.add(new Edge(vertexList.get(2), vertexList.get(3), 2));
        edgeList.add(new Edge(vertexList.get(2), vertexList.get(4), 5));

        edgeList.add(new Edge(vertexList.get(3), vertexList.get(4), 1));
        edgeList.add(new Edge(vertexList.get(3), vertexList.get(5), 6));
        edgeList.add(new Edge(vertexList.get(3), vertexList.get(6), 3));

        edgeList.add(new Edge(vertexList.get(4), vertexList.get(6), 1));

        edgeList.add(new Edge(vertexList.get(5), vertexList.get(6), 2));
        edgeList.add(new Edge(vertexList.get(5), vertexList.get(7), 3));

        edgeList.add(new Edge(vertexList.get(6), vertexList.get(7), 6));

        return edgeList;
    }
}
