import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] city;
    static final int INF = (int) 1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        city = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                city[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());

            city[a][b] = Math.min(city[a][b], c);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    city[i][j] = Math.min(city[i][j], city[i][k] + city[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (city[i][j] == INF) {
                    System.out.print("0 ");
                } else {
                    System.out.print(city[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}