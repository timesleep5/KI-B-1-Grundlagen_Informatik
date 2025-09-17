package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private static final List<Integer> usedNumbers = new ArrayList<>();
    private int number;
    private final List<Edge> edges;

    public Vertex(int number) {
        setNumber(number);
        edges = new ArrayList<>();
    }

    private void setNumber(int number) {
        if (!usedNumbers.contains(number)) {
            this.number = number;
            usedNumbers.add(number);
        } else {
            setNumber(number + 1);
        }
    }

    public int weightOfConnectionWith(Vertex vertex) {
        for (Edge edge:edges) {
            if (edge.contains(vertex)) {
                return edge.getWeight();
            }
        }
        return Integer.MAX_VALUE;
    }

    void addEdge(Edge edge) {
        edges.add(edge);
    }

    void removeEdge(Edge edge) {
        edges.remove(edge);
    }
}
