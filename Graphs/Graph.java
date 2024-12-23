import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

@SuppressWarnings("unchecked")

public class Graph {
    private int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < V; i++)
            adj[i] = new Bag<>();
    }

    public void addEdge(int v, int w) {
        adj[v].insert(w);
        adj[w].insert(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges\n");
        for (int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for (int w : adj(v))
                sb.append(w + " ");
            sb.append("\n");
        }
        return sb.toString();
    }

    // Bag class implementation
    private static class Bag<T> implements Iterable<T> {
        private Node head;

        private class Node {
            private T data;
            private Node next;

            public Node(T data) {
                this.data = data;
                this.next = null;
            }
        }

        public void insert(T data) {
            head = insert(head, data);
        }

        private Node insert(Node node, T data) {
            if (node == null)
                return new Node(data);
            node.next = insert(node.next, data);
            return node;
        }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                Node temp = head;

                @Override
                public boolean hasNext() {
                    return temp != null;
                }

                @Override
                public T next() {
                    T data = temp.data;
                    temp = temp.next;
                    return data;
                }
            };
        }
    }

    // BFS implementation
    public static class BFS {
        private boolean[] marked;
        private int[] edgeTo;
        private int s;

        public BFS(Graph G, int s) {
            marked = new boolean[G.V()];
            edgeTo = new int[G.V()];
            this.s = s;
            bfs(G, s);
        }

        private void bfs(Graph g, int s) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(s);
            marked[s] = true;

            while (!q.isEmpty()) {
                int v = q.poll();
                for (int w : g.adj(v)) {
                    if (!marked[w]) {
                        edgeTo[w] = v;
                        marked[w] = true;
                        q.offer(w);
                    }
                }
            }
        }

        public boolean hasPathTo(int v) {
            return marked[v];
        }

        public void printPathTo(int v) {
            if (!hasPathTo(v)) {
                System.out.println("No path to " + v);
                return;
            }

            LinkedList<Integer> path = new LinkedList<>();

            for (int x = v; x != s; x = edgeTo[x]) {
                path.push(x);
            }

            path.push(s);

            while (!path.isEmpty()) {
                System.out.print(path.pop() + " -> ");
            }
        }
    }

    // DFS implementation
    public static class DFS {
        private boolean[] marked;
        private int[] edgeTo;
        private int s;

        public DFS(Graph G, int s) {
            marked = new boolean[G.V()];
            edgeTo = new int[G.V()];
            this.s = s;
            dfs(G, s);
        }

        private void dfs(Graph g, int s) {
            marked[s] = true;
            for (int w : g.adj(s)) {
                if (!marked[w]) {
                    edgeTo[w] = s;
                    dfs(g, w);
                }
            }
        }

        public boolean hasPathTo(int v) {
            return marked[v];
        }

        public void printPathTo(int v) {
            Stack<Integer> path = new Stack<>();

            for (int x = v; x != s; x = edgeTo[x]) {
                path.push(x);
            }

            path.push(s);

            while (!path.isEmpty()) {
                System.out.print(path.pop() + " -> ");
            }
        }
    }

    // GraphUtility implementation
    public static class GraphUtility {
        public static int degree(Graph g, int v) {
            int degree = 0;
            for (int w : g.adj(v)) {
                degree++;
            }
            return degree;
        }

        public static int maxDegree(Graph g) {
            int max = 0;
            for (int v = 0; v < g.V(); v++)
                max = Math.max(max, degree(g, v));
            return max;
        }

        public static boolean hasDirectPath(Graph g, int v, int w) {
            for (int x : g.adj(v))
                if (x == w)
                    return true;
            return false;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(1, 5);
        g.addEdge(4, 5);
        g.addEdge(6, 7);
        g.addEdge(7, 8);
        g.addEdge(8, 9);
        g.addEdge(9, 6);
        g.addEdge(2, 6);
        g.addEdge(3, 7);

        System.out.println(g);
        System.out.println("Degree of vertex 0: " + GraphUtility.degree(g, 0));
        System.out.println("Degree of vertex 1: " + GraphUtility.degree(g, 1));
        System.out.println("Max degree: " + GraphUtility.maxDegree(g));

        DFS dfs = new DFS(g, 0);
        System.out.println("Path to 7: " + dfs.hasPathTo(7));
        System.out.print("Path to 7: ");
        dfs.printPathTo(7);
        System.out.println();

        BFS bfs = new BFS(g, 0);
        System.out.println("Path to 7: " + bfs.hasPathTo(7));
        System.out.print("Path to 7: ");
        bfs.printPathTo(7);
        System.out.println();
    }
}