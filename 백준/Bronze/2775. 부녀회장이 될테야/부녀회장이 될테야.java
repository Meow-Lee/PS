import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[][] dp = new int[15][15];
        for (int i = 1; i < 15; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                int sum = 0;
                for (int k = 1; k <= j; k++) {
                    sum += dp[i - 1][k];
                }
                dp[i][j] = sum;
            }
        }

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(dp[k][n]);
        }
    }
}