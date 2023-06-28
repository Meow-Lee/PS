import java.util.*;
import java.io.*;

public class Main {
    static int N, cnt, group_cnt;
    static String[] map;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static void dfs(int x, int y) {
        visit[x][y] = true;
        cnt++;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }
            if (visit[nx][ny]) {
                continue;
            }
            if (map[nx].charAt(ny) == '0') {
                continue;
            }
            dfs(nx, ny);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        map = new String[N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine();
        }

        visit = new boolean[N][N];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && map[i].charAt(j) == '1') {
                    dfs(i, j);
                    list.add(cnt);
                    group_cnt++;
                }
                cnt = 0;
            }
        }
        System.out.println(group_cnt);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}