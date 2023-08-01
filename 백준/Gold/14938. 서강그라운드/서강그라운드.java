import java.util.*;
import java.io.*;

public class Main {
    static int N, M, R;
    static int[] items;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());

        items = new int[N + 1];
        stk = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(stk.nextToken());
        }

        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                map[i][j] = (int) 1e9;
            }
        }
        for (int i = 1; i <= R; i++) {
            stk = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int l = Integer.parseInt(stk.nextToken());

            map[a][b] = l;
            map[b][a] = l;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 1; j <= N; j++) {
                if (map[i][j] <= M) {
                    count += items[j];
                }
            }
            sum = Math.max(sum, count);
        }

        System.out.println(sum);
    }
}