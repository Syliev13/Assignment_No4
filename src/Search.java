import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class Search<V> {
    protected Vertex<V> source;
    // stores which vertex we came from to reconstruct the path
    protected Map<Vertex<V>, Vertex<V>> edgeTo;
    protected Map<Vertex<V>, Boolean> marked;

    public Search(Vertex<V> source) {
        this.source = source;
        this.edgeTo = new HashMap<>();
        this.marked = new HashMap<>();
    }

    public abstract void search();

    public boolean hasPathTo(Vertex<V> dest) {
        return marked.getOrDefault(dest, false);
    }

    // returns path from source to dest
    public List<Vertex<V>> pathTo(Vertex<V> dest) {
        if (!hasPathTo(dest)) return null;

        LinkedList<Vertex<V>> path = new LinkedList<>();
        Vertex<V> current = dest;

        while (!current.equals(source)) {
            path.addFirst(current);
            current = edgeTo.get(current);
        }
        path.addFirst(source);

        return path;
    }
}