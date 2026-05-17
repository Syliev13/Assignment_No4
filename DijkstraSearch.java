import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraSearch<V> extends Search<V> {
    private Map<Vertex<V>, Double> distTo;

    public DijkstraSearch(Vertex<V> source) {
        super(source);
        this.distTo = new HashMap<>();
        search();
    }

    @Override
    public void search() {
        // min-heap by distance
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(distTo.getOrDefault(a, Double.MAX_VALUE),
                        distTo.getOrDefault(b, Double.MAX_VALUE))
        );

        distTo.put(source, 0.0);
        marked.put(source, true);
        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double newDist = distTo.getOrDefault(current, Double.MAX_VALUE) + entry.getValue();

                if (newDist < distTo.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    distTo.put(neighbor, newDist);
                    edgeTo.put(neighbor, current);
                    marked.put(neighbor, true);
                    pq.add(neighbor);
                }
            }
        }
    }

    public double getDistanceTo(Vertex<V> dest) {
        return distTo.getOrDefault(dest, Double.MAX_VALUE);
    }
}