# A. Project Overview.

This project implements a graph representation system using an Adjacency List. 
The system allows for creating graphs of various sizes and performing two fundamental traversal algorithms: Breadth-First Search (BFS) and Depth-First Search (DFS).

Vertices: Represent unique nodes in the network (e.g., users, cities).

Edges: Represent directed connections between these nodes.# Assignment4

# B. Class Descriptions
Vertex: A class representing a node with a unique id.
Edge: Represents a directed connection from a source vertex to a destination vertex.  
Graph: The core structure that manages vertices and edges using a Map<Integer, List<Edge>> to implement an adjacency list.
Experiment: A utility class to automate testing across different graph scales (10, 30, and 100 vertices) and measure execution time. 

# C. Algorithm Descriptions
1. Breadth-First Search (BFS)   
Step-by-step: 
1) Start from a root node and add it to a Queue.
2) Mark the node as visited.
3) Dequeue a node and visit all its unvisited neighbors, adding them to the queue.
4) Repeat until the queue is empty.  
Use Cases: Finding the shortest path in unweighted graphs, social networking (finding friends of friends).
Time Complexity: O(V + E), where V is vertices and E is edges.

2. Depth-First Search (DFS)   

Step-by-step:

1) Start from a root node and push it onto a Stack (or use recursion).
2) Mark the node as visited.
3) Travel as far as possible along each branch before backtracking.

Repeat for all unvisited branches.  
Use Cases: Solving puzzles (mazes), topological sorting, detecting cycles in a graph.

# D. Experimental Results
Execution Time Comparison

| Graph Size | BFS Execution Time (ns) | DFS Execution Time (ns) |
|:-----------|:------------------------|:------------------------|
| **10 Vertices** | 593,400 | 131,600 |
| **30 Vertices** | 47,100 | 27,700 |
| **100 Vertices** | 121,900 | 68,800 |

Observations and Analysis   
1) Performance vs. Size: As expected, the execution time generally increases with the number of vertices and edges, aligning with $O(V+E)$ complexity.  
2) Algorithm Speed: In this experiment, DFS performed faster than BFS. This is likely due to the low overhead of recursion compared to the object instantiation required for the BFS Queue.  
3) Graph Structure: For the small graph, some vertices had no outgoing edges (e.g., Vertex 3, 4), resulting in "empty" connectivity lists and very short traversal paths.

# E. Screenshots
Vertex
<img width="1216" height="714" alt="carbon (1)" src="https://github.com/user-attachments/assets/56c0955b-2192-4d71-872e-fd7f11ca4ecc" />

Edge
<img width="1216" height="938" alt="carbon (2)" src="https://github.com/user-attachments/assets/40a1b6b1-11f9-485b-a6f0-7602378fe3f1" />

Graph
<img width="1216" height="3732" alt="carbon" src="https://github.com/user-attachments/assets/a30160e3-39a1-4983-85e9-69a19b21e02e" />

Experiment
<img width="1216" height="3060" alt="carbon (3)" src="https://github.com/user-attachments/assets/354fd96c-420c-4fb5-8c83-141ad1f1a3f5" />

Main
<img width="1216" height="342" alt="carbon (4)" src="https://github.com/user-attachments/assets/64b60de1-db2c-4708-aed0-0e269321f0c1" />

Results

<img width="565" height="715" alt="image" src="https://github.com/user-attachments/assets/008af1e9-dba1-4fa2-be41-faf1ae722f2e" />

# F. Reflection Section   
Through this assignment, I deepened my understanding of non-linear data structures. 
I learned that while BFS and DFS have the same theoretical time complexity, their practical performance depends on the implementation (iteration vs. recursion) and the specific structure of the graph. 
One of the main challenges was managing the random generation of edges to ensure the graph remained connected enough to demonstrate a full traversal. 
Additionally, observing the "warm-up" period of the JVM was interesting, as the first test (size 10) took significantly longer than the subsequent larger test.  
