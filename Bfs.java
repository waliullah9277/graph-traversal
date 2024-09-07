import java.util.*;

public class bfs {
    static final int N = 100007;
    static Vector<Integer>[] vector = new Vector[N];
    static boolean[] visited = new boolean[N];
    static int[] level = new int[N];
    
    // Modified BFS to check if there's a path between s and d
    public static void bfsT(int s) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        level[s] = 0;
        
        while (!q.isEmpty()) {
            int parent = q.poll();
            System.out.println(parent);
            
            for (int child : vector[parent]) {
                if (!visited[child]) {
                    q.add(child);
                    visited[child] = true;
                    level[child] = level[parent] + 1;
                }
            }
        }
        
    }
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input the number of nodes and edges
        System.out.print("Enter your node: ");
        int n = sc.nextInt();
        System.out.print("Enter your edge: ");
        int e = sc.nextInt();
        
        // Initialize adjacency list
        for (int i = 0; i <= n; i++) {
            vector[i] = new Vector<>();
        }
        
        // Read the edges
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            vector[a].add(b);
            vector[b].add(a); 
        }
        
        bfsT(1);
        System.out.println("---------");
        for(int i=0;i<=n;i++){
            System.out.println("Node "+ i + " : " + level[i]);
        }
    }
}
