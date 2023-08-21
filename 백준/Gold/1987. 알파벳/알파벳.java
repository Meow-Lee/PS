import java.util.*;
import java.io.*;

public class Main {
    static int R, C, count;
    static char[][] map;
    static boolean[] alpha;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static class Point {
        int x, y, cost;

        Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());

        map = new char[R + 1][C + 1];
        alpha = new boolean[26];
        for (int i = 1; i <= R; i++) {
            String str = br.readLine();
            for (int j = 1; j <= C; j++) {
                map[i][j] = str.charAt(j - 1);
            }
        }

        alpha[map[1][1] - 'A'] = true;
        dfs(1, 1, 1);

        System.out.println(count);
    }

    private static void dfs(int x, int y, int cnt) {
        count = Math.max(count, cnt);
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx <= 0 || ny <= 0 || nx > R || ny > C) {
                continue;
            }
            if (alpha[map[nx][ny] - 'A']) {
                continue;
            }
            alpha[map[nx][ny] - 'A'] = true;
            dfs(nx, ny, cnt + 1);
            alpha[map[nx][ny] - 'A'] = false;
        }
    }
}