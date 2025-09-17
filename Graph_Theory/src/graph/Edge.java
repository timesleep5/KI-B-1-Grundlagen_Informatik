package graph;

public class Edge {
    private final Vertex v1;
    private final Vertex v2;
    private final int weight;


    public Edge(Vertex v1, Vertex v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;

        v1.addEdge(this);
        v2.addEdge(this);
    }

    boolean contains(Vertex vertex) {
        return v1.equals(vertex) || v2.equals(vertex);
    }

    @Override
    protected void finalize() {
        v1.removeEdge(this);
        v2.removeEdge(this);
    }

    public int getWeight() {
        return weight;
    }
}
