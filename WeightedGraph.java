import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V> {
    private Map<V, Vertex<V>> vertices;
    private boolean undirected;

    public WeightedGraph(boolean undirected) {
        this.vertices = new HashMap<>();
        this.undirected = undirected;
    }

    public void addVertex(V data) {
        vertices.put(data, new Vertex<>(data));
    }

    public void addEdge(V source, V dest, double weight) {
        // create vertices if they don't exist yet
        if (!vertices.containsKey(source)) addVertex(source);
        if (!vertices.containsKey(dest)) addVertex(dest);

        Vertex<V> srcVertex = vertices.get(source);
        Vertex<V> destVertex = vertices.get(dest);

        srcVertex.addAdjacentVertex(destVertex, weight);

        if (undirected) {
            destVertex.addAdjacentVertex(srcVertex, weight);
        }
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public Map<V, Vertex<V>> getVertices() {
        return vertices;
    }

    public boolean hasVertex(V data) {
        return vertices.containsKey(data);
    }
}