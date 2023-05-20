import java.util.*;
import java.io.*;

public class Main{
    static int[][] board;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static class Pair{
        private int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        board = new int[n+1][m+1];
        dist = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            stk = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(stk.nextToken());
                if(board[i][j]==2){
                    q.offer(new Pair(i, j));
                    dist[i][j]=0;
                    visited[i][j] = true;
                }
                else{
                    dist[i][j]=-1;
                }
            }
        }   

        while(!q.isEmpty()){
            Pair cur = q.poll();
            for(int dir=0; dir<4; dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx<0 || ny<0 || nx>n || ny>m){
                    continue;
                }
                if(board[nx][ny]==0 || visited[nx][ny]){
                    continue;
                }
                dist[nx][ny] = dist[cur.x][cur.y]+1;
                visited[nx][ny] = true;
                q.offer(new Pair(nx, ny));
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]==0){
                    dist[i][j]=0;
                }
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}