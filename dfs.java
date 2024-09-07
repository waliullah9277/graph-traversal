import java.util.*;

public class dfs {

    static final int N = 100007;
    static Vector<Integer>[] v = new Vector[N];
    static boolean[] visited = new boolean[N];

    public static void dfsCall(int s){
        visited[s] = true;
        System.out.println(s);
        
        for(int child: v[s]){
            if(!visited[child]){
                dfsCall(child);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your node: ");
        int n = sc.nextInt();
        System.out.print("Enter your edge: ");
        int e = sc.nextInt();

        for(int i=0;i<=n;i++){
            v[i] = new Vector<>();
        }

        for(int i=0; i<e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            v[a].add(b);
            v[b].add(a);
        }

        dfsCall(1);
    }
}
