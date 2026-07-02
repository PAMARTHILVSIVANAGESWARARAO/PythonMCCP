import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String args[]) {
        Graph obj = new Graph(5);
        
        Graph.addEdge(obj.m, 0, 1);
        Graph.addEdge(obj.m, 1, 2);
        Graph.addEdge(obj.m, 2, 3);
        Graph.addEdge(obj.m, 3, 4);

        System.out.println("--- Recursive DFS ---");
        boolean visitedRecursive[] = new boolean[5];
        Graph.dfs(obj.m, 2, visitedRecursive);
        System.out.println("\n");

        System.out.println("--- Iterative DFS ---");
        
        boolean visitedIterative[] = new boolean[5];
        ArrayList<Integer> al = Graph.dfsIterator(obj.m, 2, visitedIterative);

        for(int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i) + " ");
        }
        System.out.println();


        System.out.print("----BFS-----");
        boolean visitedIterative1[] = new boolean[5];
        ArrayList<Integer> al2 = Graph.bfs(obj.m, 2, visitedIterative1);

        for(int i = 0; i < al2.size(); i++) {
            System.out.print(al2.get(i) + " ");
        }
        System.out.println();
    }
}

class Graph {
    int m[][], n;

    Graph(int n) {
        this.n = n;
        m = new int[n][n];
    }

    public static void addEdge(int m[][], int u, int v){
        m[u][v] = 1;
        m[v][u] = 1;
    }

    public static void display(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int[][] m, int s, boolean visited[]){
        visited[s] = true;
        System.out.print(s + " ");
        for (int i = 0; i < m.length; i++){
            if(m[s][i] == 1 && !visited[i]){
                dfs(m, i, visited);
            }
        }
    }


    public static ArrayList<Integer> bfs(int[][] m, int s, boolean visited[]) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        q.add(s);
        visited[s] = true;
        
        while (!q.isEmpty()) {
            // Remove the front element of the queue
            int curr = q.poll(); 
            res.add(curr);
            
            // Loop through all possible neighbors in the adjacency matrix
            for (int i = 0; i < m[curr].length; i++) {
                // If there is an edge and the neighbor hasn't been visited
                if (m[curr][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        return res;
    }
    public static ArrayList<Integer> dfsIterator(int[][] m, int s, boolean visited[]){
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();

        st.push(s);

        while (!st.isEmpty()) {
            int curr = st.pop();

            
            if (!visited[curr]) {
                visited[curr] = true;
                al.add(curr);

                
                for (int i = m.length - 1; i >= 0; i--) {
                    if (m[curr][i] == 1 && !visited[i]) {
                        st.push(i);
                    }
                }
            }
        }
        return al;
    }
}
