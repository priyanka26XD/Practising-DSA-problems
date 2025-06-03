import java.util.*;

// Step 1: Define the class
public class TopologicalSortDFS {

    // Step 2: Function to perform topological sort
    public static void topologicalSort(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];   // To track visited nodes
        Stack<Integer> stack = new Stack<>(); // To store the topological order

        // Step 3: Perform DFS from every unvisited node
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        // Step 4: Print topological sort by popping stack
        System.out.print("Topological Order: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    // Step 5: DFS function
    private static void dfs(int node, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true; // Mark node as visited

        // Visit all adjacent nodes
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, stack);
            }
        }

        // After visiting all neighbors, push to stack
        stack.push(node);
    }

    // Step 6: Main function to run example
    public static void main(String[] args) {
        int V = 6; // Number of vertices (0 to 5)

        // Step 7: Create the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 8: Add directed edges (example DAG)
        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        // Step 9: Call the topological sort function
        topologicalSort(V, adj);
    }
}
