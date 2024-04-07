import java.util.*;

public class BreadthFirstSearch {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>(); // Initialize each element as a new empty ArrayList
        }

        // Add edges to the graph (modify as needed for your specific graph structure)
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[6].add(new Edge(6, 5, 1));
    }

    public static void bfs(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[graph.length]; // Array to keep track of visited vertices

        // Add the starting vertex (assumed to be vertex 0) to the queue
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) {
                System.out.print(curr + " "); // Print the visited vertex
                vis[curr] = true;

                // Get the size of the adjacency list for curr before the loop
                int currListSize = graph[curr].size();
                for (int i = 0; i < currListSize; i++) {
                    Edge e = graph[curr].get(i);
                    if (!vis[e.dest]) { // Check if destination vertex is unvisited
                        q.add(e.dest);
                    }
                }
            }
        }
    }
    public static void dfs(ArrayList<Edge>[]graph,int curr,boolean vis[]){
        //visit
        System.out.print(curr+" ");
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph,e.dest,vis);
            }
        }
    }

    public static void main(String[] args) {
        int v = 7; // Number of vertices in the graph
        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph);
        System.out.println("Breadth First Search Traversal:");
        bfs(graph);
        System.out.println();
        dfs(graph,0,new boolean[v]);
    }
}
