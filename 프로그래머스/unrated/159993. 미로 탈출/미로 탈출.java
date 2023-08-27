import java.util.*;
class Solution {
    static int n, m;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static class Place{
        int x,y,dist;
        Place(int x, int y, int dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        int start_x = 0, start_y = 0;
        int levor_x = 0, levor_y = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maps[i].charAt(j)=='S'){
                    start_x = i;
                    start_y = j;
                }
                if(maps[i].charAt(j)=='L'){
                    levor_x = i;
                    levor_y=j;
                }
            }
        }
        
        boolean[][] levor = new boolean[n][m];
        levor[start_x][start_y]=true;
        int to_levor = bfs('L', maps, levor, start_x, start_y);
        if(to_levor == -1){
            return -1;
        }
        
        boolean[][] exit = new boolean[n][m];
        exit[levor_x][levor_y] = true;
        int to_exit = bfs('E', maps, exit, levor_x, levor_y);
        if(to_exit == -1){
            return -1;
        }
        
        return to_levor + to_exit;
    }
    static int bfs(char ch, String[] maps, boolean[][] visited, int x, int y){
        Queue<Place> q = new LinkedList<>();
        q.offer(new Place(x, y, 0));
        
        while(!q.isEmpty()){
            Place cur = q.poll();
            if(maps[cur.x].charAt(cur.y)==ch){
                return cur.dist;
            }
            for(int dir=0; dir<4; dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx<0 || ny<0 || nx>=n || ny>=m){
                    continue;
                }
                if(visited[nx][ny] || maps[nx].charAt(ny)=='X'){
                    continue;
                }
                q.offer(new Place(nx,ny,cur.dist+1));
                visited[nx][ny]=true;
            }
        }
        return -1;
    }
}