import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {

    public BreadthFirstSearch(Vertex<V> source) {
        super(source);
        search();
    }

    @Override
    public void search() {
        Queue<Vertex<V>> queue = new LinkedList<>();

        marked.put(source, true);
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();

                if (!marked.getOrDefault(neighbor, false)) {
                    marked.put(neighbor, true);
                    edgeTo.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }
}