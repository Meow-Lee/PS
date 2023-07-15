import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[][] a = new int[N + 1][N + 1];
        int[][] s = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                a[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            s[i][1] = a[i][1];
            for (int j = 2; j <= N; j++) {
                s[i][j] = s[i][j - 1] + a[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(stk.nextToken());
            int y1 = Integer.parseInt(stk.nextToken());
            int x2 = Integer.parseInt(stk.nextToken());
            int y2 = Integer.parseInt(stk.nextToken());

            int sum = 0;
            for (int j = x1; j <= x2; j++) {
                sum += s[j][y2] - s[j][y1 - 1];
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb.toString());
    }
}