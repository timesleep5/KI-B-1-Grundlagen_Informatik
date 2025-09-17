package algorithms.dijkstra;

import graph.Vertex;

import java.util.HashMap;
import java.util.List;

public class Dijkstra {
    private final static int INFINITY_VALUE = -1;
    private final HashMap<Vertex, Integer> connectedVertices;
    private final HashMap<Vertex, Integer> unconnectedVertexValues;
    private final Vertex startVertex;

    public Dijkstra(List<Vertex> vertices, Vertex startVertex) {
        unconnectedVertexValues = fillVertexValues(vertices);
        connectedVertices = new HashMap<>();
        connectedVertices.put(startVertex, 0);
        this.startVertex = startVertex;

        if (!vertices.contains(startVertex)) {
            throw new IllegalArgumentException("startVertex not contained in graph");
        }
    }

    private HashMap<Vertex, Integer> fillVertexValues(List<Vertex> vertices) {
        HashMap<Vertex, Integer> unconnectedVertexValues = new HashMap<>();
        for (Vertex vertex : vertices) {
            unconnectedVertexValues.put(vertex, INFINITY_VALUE);
        }
        return unconnectedVertexValues;
    }

    public void algorithm() {
        Vertex currentVertex = startVertex;
        while (!unconnectedVertexValues.isEmpty()) {
            for (Vertex unconnectedVertex : unconnectedVertexValues.keySet()) {
                int shortestConnection = Integer.MAX_VALUE;
                for (Vertex connectedVertex : connectedVertices.keySet()) {
                    int weightOfConnection = connectedVertex.weightOfConnectionWith(unconnectedVertex);
                    shortestConnection = Math.min(shortestConnection, weightOfConnection);
                    }
                unconnectedVertexValues.put(unconnectedVertex, shortestConnection);
            }
            System.out.println(unconnectedVertexValues);
            unconnectedVertexValues.remove(currentVertex);
            break;
        }
    }
}
