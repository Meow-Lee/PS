import java.util.*;
import java.io.*;
import java.io.IOException;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static int n, m, v;
    static int[][] graph;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        v = Integer.parseInt(stk.nextToken());

        graph = new int[n+1][n+1];
        visited = new int[n+1];
        for(int i=0; i<m; i++){
            stk = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(v);
        sb.append("\n");

        visited = new int[n+1];
        bfs(v);
        System.out.println(sb);
    }

    static void dfs(int start){
        visited[start] = 1;
        sb.append(start+" ");
        for(int i=0; i<=n; i++){
            if(graph[start][i]==1 && visited[i]!=1){
                dfs(i);
            }
        }
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start]=1;
        while(!q.isEmpty()){
            start = q.poll();
            sb.append(start + " ");
            for(int i=0; i<=n; i++){
                if(graph[start][i]==1 && visited[i]!=1){
                    q.offer(i);
                    visited[i]=1;
                }
            }
        }
    }
}