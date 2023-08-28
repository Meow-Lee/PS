import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(stk.nextToken());
            int M = Integer.parseInt(stk.nextToken());

            int[][] dp = new int[M + 1][M + 1];
            for (int i = 0; i <= M; i++) {
                dp[i][0] = 1;
                dp[i][1] = i;
                dp[i][i] = 1;
            }

            for (int i = 2; i <= M; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }
            }

            System.out.println(dp[M][N]);
        }
    }
}