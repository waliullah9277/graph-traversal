import java.util.*;

public class souce_to_destination_dfs {

    static final int N = 100007;
    static Vector<Integer>[] v = new Vector[N];
    static boolean[] visited = new boolean[N];

    public static boolean dfs_call(int s, int d){
        visited[s] = true;
        if(s == d){
            return true;
        }
        for(int child: v[s]){
            if(!visited[child]){
                if(dfs_call(child,d)){
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your node: ");
        int n = sc.nextInt();
        System.out.print("Enter your edge: ");
        int e = sc.nextInt();

        for(int i=0; i<=n; i++){
            v[i] = new Vector<>();
        }

        for(int i=0; i<e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            v[a].add(b);
            v[b].add(a);
        }

        System.out.print("Enter your source: ");
        int s = sc.nextInt();
        System.out.print("Enter your destination: ");
        int d = sc.nextInt();

        if(dfs_call(s,d)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
