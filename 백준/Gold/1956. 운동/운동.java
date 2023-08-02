import java.util.*;
import java.io.*;

public class Main {
    static int V, E;
    static int[][] city;
    static final int INF = (int) 1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(stk.nextToken());
        E = Integer.parseInt(stk.nextToken());

        city = new int[V + 1][V + 1];
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    continue;
                }
                city[i][j] = INF;
            }
        }

        for (int i = 0; i < E; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());

            city[a][b] = c;
        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (city[i][k] != INF && city[k][j] != INF) {
                        city[i][j] = Math.min(city[i][j], city[i][k] + city[k][j]);
                    }
                }
            }
        }

        int ans = INF;
        boolean isPresent = false;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    continue;
                }
                if (city[i][j] != INF && city[j][i] != INF) { //사이클 여부
                    ans = Math.min(ans, city[i][j] + city[j][i]);
                    isPresent = true;
                }
            }
        }

        if (isPresent) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }
}