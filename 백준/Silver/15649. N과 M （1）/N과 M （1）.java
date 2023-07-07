import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] selected;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        selected = new int[m + 1];
        rec_func(1);

        System.out.println(sb.toString());
    }

    static void rec_func(int k) {
        if (k == m + 1) {
            for (int i = 1; i <= m; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            for (int i = 1; i <= n; i++) {
                boolean isUsed = false;
                for (int j = 1; j < k; j++) {
                    if (selected[j] == i) {
                        isUsed = true;
                    }
                }
                if (!isUsed) {
                    selected[k] = i;
                    rec_func(k + 1);
                    selected[k] = 0;
                }
            }
        }
    }
}