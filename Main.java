import java.util.List;

public class Main {
    public static void main(String[] args) {

        // build a simple weighted graph
        WeightedGraph<String> graph = new WeightedGraph<>(true); // undirected

        graph.addEdge("Almaty", "Astana", 1000.0);
        graph.addEdge("Almaty", "Shymkent", 700.0);
        graph.addEdge("Shymkent", "Astana", 1300.0);
        graph.addEdge("Astana", "Kostanay", 500.0);
        graph.addEdge("Kostanay", "Kokshetau", 300.0);
        graph.addEdge("Astana", "Kokshetau", 270.0);

        Vertex<String> source = graph.getVertex("Almaty");

        System.out.println("=== BFS from Almaty ===");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(source);

        Vertex<String> bfsDest = graph.getVertex("Kokshetau");
        if (bfs.hasPathTo(bfsDest)) {
            List<Vertex<String>> path = bfs.pathTo(bfsDest);
            System.out.print("Path to Kokshetau: ");
            for (Vertex<String> v : path) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

        System.out.println("\n=== Dijkstra from Almaty ===");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(source);

        Vertex<String> dijkDest = graph.getVertex("Kokshetau");
        if (dijkstra.hasPathTo(dijkDest)) {
            List<Vertex<String>> path = dijkstra.pathTo(dijkDest);
            System.out.print("Shortest path to Kokshetau: ");
            for (Vertex<String> v : path) {
                System.out.print(v + " ");
            }
            System.out.println();
            System.out.println("Total distance: " + dijkstra.getDistanceTo(dijkDest));
        }
    }
}