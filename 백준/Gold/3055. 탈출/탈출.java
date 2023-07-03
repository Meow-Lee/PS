import java.util.*;
import java.io.*;

public class Main {
    static int r, c;
    static String[] map;
    static int[][] dist_water, dist_escape;
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());

        map = new String[r];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine();
        }

        bfs_water();
        bfs_escape();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i].charAt(j) == 'D') {
                    if (dist_escape[i][j] == 0) {
                        System.out.println("KAKTUS");
                    } else {
                        System.out.println(dist_escape[i][j]);
                    }
                }
            }
        }
    }

    static void bfs_water() {
        Queue<Pair> q = new LinkedList<>();
        visit = new boolean[r][c];
        dist_water = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i].charAt(j) == '*') {
                    q.offer(new Pair(i, j));
                    visit[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                    continue;
                }
                if (visit[nx][ny] || map[nx].charAt(ny) != '.') {
                    continue;
                }
                q.offer(new Pair(nx, ny));
                visit[nx][ny] = true;
                dist_water[nx][ny] = dist_water[cur.x][cur.y] + 1;
            }
        }
    }
    static void bfs_escape() {
        Queue<Pair> q = new LinkedList<>();
        visit = new boolean[r][c];
        dist_escape = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i].charAt(j) == 'S') {
                    q.offer(new Pair(i, j));
                    visit[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                    continue;
                }
                if (visit[nx][ny]) {
                    continue;
                }
                if (map[nx].charAt(ny) != '.' && map[nx].charAt(ny) != 'D') {
                    continue;
                }
                if (dist_water[nx][ny] != 0 && dist_water[nx][ny] <= dist_escape[cur.x][cur.y] + 1) {
                    continue;
                }
                q.offer(new Pair(nx, ny));
                visit[nx][ny] = true;
                dist_escape[nx][ny] = dist_escape[cur.x][cur.y] + 1;
            }
        }
    }
}