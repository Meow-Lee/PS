import java.util.*;
import java.io.*;

public class Main{
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(stk.nextToken());

        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for(int i=1; i<=n+1; i++){
            tree.add(new ArrayList<>());
        }

        for(int i=1; i<n; i++){
            stk = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            tree.get(x).add(y);
            tree.get(y).add(x);
        }
        visited = new boolean[n+1];
        parent = new int[n+1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        while(!q.isEmpty()){
            int v = q.poll();
            for(int node : tree.get(v)){
                if(!visited[node]){
                    visited[node]=true;
                    q.add(node);
                    parent[node] = v;
                }
            }
        }

        for(int i=2; i<=n; i++){
            System.out.println(parent[i]);
        }
    }
}