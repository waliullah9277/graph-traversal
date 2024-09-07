import java.util.*;

class nodeCount_bfs {
    static final int N = 100007;
    static Vector<Integer>[] v = new Vector[N];
    static boolean[] visited = new boolean[N];
    static int[] level = new int[N];
    
    public static int bfs(int s, int d){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        level[s] = 0;
        
        while(!q.isEmpty()){
            int parent = q.poll();
            // System.out.println(parent);
            
            if (parent == d)
                // return true;
                return level[parent] + 1;
            
            for(int child: v[parent]){
                if(!visited[child]){
                    q.add(child);
                    visited[child] = true;
                    level[child] = level[parent] + 1;
                }
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
        
        int res = bfs(s,d);
        System.out.println("The source " + s + " to destination " + d + " node is: "+res);
    }
}
