import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[] arr = new int[N + 1];
        stk = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int[] sum = new int[N + 1];
        sum[1] = arr[1];
        for (int i = 2; i <= N; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            System.out.println(sum[y] - sum[x - 1]);
        }
    }
}