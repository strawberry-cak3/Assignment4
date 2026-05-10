import java.util.*;


public class Graph {
    // Adjacency List representation
    private Map<Integer, Vertex> vertices;
    private Map<Integer, List<Edge>> adjacencyList;

    public Graph() {
        vertices = new HashMap<>();
        adjacencyList = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        vertices.putIfAbsent(v.getId(), v);
        adjacencyList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        Vertex source = vertices.get(from);
        Vertex dest = vertices.get(to);

        if (source != null && dest != null) {
            adjacencyList.get(from).add(new Edge(source, dest));
        }
    }

    public void printGraph() {
        System.out.println("Graph Structure:");
        for (Integer vertexId : adjacencyList.keySet()) {
            System.out.print("Vertex " + vertexId + " connects to: ");
            for (Edge edge : adjacencyList.get(vertexId)) {
                System.out.print(edge.getDestination().getId() + " ");
            }
            System.out.println();
        }
    }

    // Breadth-First Search (BFS)
    public void bfs(int start) {
        if (!vertices.containsKey(start)) return;

        boolean isSmallGraph = vertices.size() <= 10;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        if (isSmallGraph) System.out.print("BFS Traversal Order: ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (isSmallGraph) System.out.print(current + " ");

            for (Edge edge : adjacencyList.get(current)) {
                int neighbor = edge.getDestination().getId();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        if (isSmallGraph) System.out.println();
    }

    // Depth-First Search (DFS)
    public void dfs(int start) {
        if (!vertices.containsKey(start)) return;

        boolean isSmallGraph = vertices.size() <= 10;
        Set<Integer> visited = new HashSet<>();

        if (isSmallGraph) System.out.print("DFS Traversal Order: ");
        dfsHelper(start, visited, isSmallGraph);
        if (isSmallGraph) System.out.println();
    }

    private void dfsHelper(int current, Set<Integer> visited, boolean isSmallGraph) {
        visited.add(current);
        if (isSmallGraph) System.out.print(current + " ");

        for (Edge edge : adjacencyList.get(current)) {
            int neighbor = edge.getDestination().getId();
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited, isSmallGraph);
            }
        }
    }

    public int getSize() {
        return vertices.size();
    }
}
