import java.util.*;
import java.io.*;

public class Main {
    static int N, cnt;
    static int[] pos;
    static boolean[] flag_a;
    static boolean[] flag_b;
    static boolean[] flag_c;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        cnt = 0;
        pos = new int[N];
        flag_a = new boolean[N];
        flag_b = new boolean[2 * N - 1];
        flag_c = new boolean[2 * N - 1];

        backtracking(0);

        System.out.println(cnt);
    }

    private static void backtracking(int j) {
        for (int i = 0; i < N; i++) {
            if (!flag_a[i] && !flag_b[i + j] && !flag_c[j - i + N - 1]) {
                pos[j] = i;

                if (j == N - 1) {
                    cnt++;
                } else {
                    flag_a[i] = flag_b[i + j] = flag_c[j - i + N - 1] = true;
                    backtracking(j + 1);
                    flag_a[i] = flag_b[i + j] = flag_c[j - i + N - 1] = false;
                }
            }
        }
    }
}