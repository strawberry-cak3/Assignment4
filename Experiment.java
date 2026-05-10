import java.util.Random;
import java.util.ArrayList;
import java.util.List;


public class Experiment {

    private List<String> resultsLog = new ArrayList<>();

    public void runMultipleTests() {
        System.out.println("Starting Graph Traversal Experiments...\n");

        Graph smallGraph = generateRandomGraph(10, 15);
        Graph mediumGraph = generateRandomGraph(30, 60);
        Graph largeGraph = generateRandomGraph(100, 300);

        System.out.println("--- Testing Small Graph (10 vertices) ---");
        smallGraph.printGraph();
        runTraversals(smallGraph);

        System.out.println("\n--- Testing Medium Graph (30 vertices) ---");
        runTraversals(mediumGraph);

        System.out.println("\n--- Testing Large Graph (100 vertices) ---");
        runTraversals(largeGraph);

        printResults();
    }

    public void runTraversals(Graph g) {
        int startVertex = 0; // Assuming 0 is always generated

        // Measure BFS
        long startBfs = System.nanoTime(); // [cite: 68]
        g.bfs(startVertex); // [cite: 65]
        long endBfs = System.nanoTime(); // [cite: 69]
        long timeBfs = endBfs - startBfs;

        // Measure DFS
        long startDfs = System.nanoTime(); // [cite: 68]
        g.dfs(startVertex); // [cite: 66]
        long endDfs = System.nanoTime(); // [cite: 69]
        long timeDfs = endDfs - startDfs;

        resultsLog.add(String.format("Size: %3d | BFS Time: %7d ns | DFS Time: %7d ns",
                g.getSize(), timeBfs, timeDfs));
    }

    // Helper method to auto generate graphs with edges
    private Graph generateRandomGraph(int numVertices, int numEdges) {
        Graph g = new Graph();
        for (int i = 0; i < numVertices; i++) {
            g.addVertex(new Vertex(i));
        }

        Random rand = new Random();
        for (int i = 0; i < numEdges; i++) {
            int from = rand.nextInt(numVertices);
            int to = rand.nextInt(numVertices);
            if (from != to) {
                g.addEdge(from, to);
            }
        }
        return g;
    }

    public void printResults() {
        System.out.println("\n=== EXPERIMENT RESULTS ===");
        for (String res : resultsLog) {
            System.out.println(res);
        }
    }
}
