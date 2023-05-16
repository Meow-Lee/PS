import java.util.*;
import java.io.*;

public class Main{
    static int[][] board;
    static int[][] dist;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        board = new int[n][m];
        dist = new int[n][m];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                board[i][j] = s.charAt(j)-'0';
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0));
        dist[0][0] = 1;
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int dir=0; dir<4; dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx<0 || ny<0 || nx>=n || ny>=m){
                    continue;
                }
                if(board[nx][ny]==0 || dist[nx][ny]>0){
                    continue;
                }
                q.offer(new Node(nx,ny));
                dist[nx][ny] = dist[cur.x][cur.y]+1;
            }
        }
        System.out.println(dist[n-1][m-1]);
    }

    public static class Node{
        int x,y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}