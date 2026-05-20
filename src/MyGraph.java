import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyGraph<V> {

    private Map<V, List<V>> adjacencyMap;
    private boolean undirected;

    public MyGraph(boolean undirected) {
        this.adjacencyMap = new HashMap<>();
        this.undirected = undirected;
    }

    public void addVertex(V data) {
        adjacencyMap.putIfAbsent(data, new ArrayList<>());
    }

    public void addEdge(V source, V dest) {
        addVertex(source);
        addVertex(dest);

        adjacencyMap.get(source).add(dest);

        if (undirected) {
            adjacencyMap.get(dest).add(source);
        }
    }

    public List<V> getNeighbors(V data) {
        return adjacencyMap.getOrDefault(data, new ArrayList<>());
    }

    public boolean hasVertex(V data) {
        return adjacencyMap.containsKey(data);
    }

    public Map<V, List<V>> getAdjacencyMap() {
        return adjacencyMap;
    }

    public void printGraph() {
        for (Map.Entry<V, List<V>> entry : adjacencyMap.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            System.out.println(entry.getValue());
        }
    }
}
//change