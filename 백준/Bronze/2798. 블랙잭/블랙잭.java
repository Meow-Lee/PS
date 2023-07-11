import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        int[] card = new int[N];
        stk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(stk.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int tot = card[i] + card[j] + card[k];
                    if (tot <= M) {
                        sum = Math.max(sum, tot);
                    }
                }
            }
        }
        System.out.println(sum);
    }
}