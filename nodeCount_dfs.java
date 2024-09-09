import java.util.*;

public class nodeCount_dfs {

    static final int N = 100007;
    static Vector<Integer>[] v = new Vector[N];
    static boolean[] visited = new boolean[N];

    
    public static int dfs_call(int s, int d, int count) {
        visited[s] = true;

        
        if (s == d) {
            return count;
        }

        for (int child : v[s]) {
            if (!visited[child]) {
                int result = dfs_call(child, d, count + 1);
                return result;
            }
        }

        return -1; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your node: ");
        int n = sc.nextInt();
        System.out.print("Enter your edge: ");
        int e = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            v[i] = new Vector<>();
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            v[a].add(b);
            v[b].add(a);
        }

        System.out.print("Enter your source: ");
        int s = sc.nextInt();
        System.out.print("Enter your destination: ");
        int d = sc.nextInt();

        
        int result = dfs_call(s, d, 1);
        if(result != -1){
            System.out.println("Yes, number of nodes in the path: " + result);
        }
        else{
            System.out.println("No path founds!");
        }
    }
}
