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
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stk.nextToken());


        graph = new int[n+1][n+1];
        visited = new int[n+1];
        for(int i=0; i<m; i++){
            stk = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        v = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v]=1;
        int cnt=0;
        while(!q.isEmpty()){
            int start = q.poll();
            for(int i=0; i<=n; i++){
                if(graph[start][i]==1 && visited[i]!=1){
                    q.offer(i);
                    visited[i]=1;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}