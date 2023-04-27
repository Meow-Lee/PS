import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int solution(int[][] maps) {
        int answer = 0;
        
        int r = maps.length;
        int c = maps[0].length;
        
        int[][] dist = new int[r][c];
        for(int i=0; i<r; i++){
            Arrays.fill(dist[i], -1);
        }
        dist[0][0] = 1;
        
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(0,0));
        
        while(!q.isEmpty()){
            Point cur = q.poll();

            for(int dir=0; dir<4; dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx<0 || ny<0 || nx>=r || ny>=c){
                    continue;
                }
                if(maps[nx][ny]==0 || dist[nx][ny] != -1){
                    continue;
                }
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                q.add(new Point(nx, ny));
            }
        }
        answer = dist[r-1][c-1];
        
        return answer;
    }
}