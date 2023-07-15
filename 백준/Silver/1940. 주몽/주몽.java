import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] a = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(a);

        int start_idx = 0, end_idx = N - 1, count = 0;
        while (start_idx < end_idx) {
            if (a[start_idx] + a[end_idx] < M) {
                start_idx++;
            } else if (a[start_idx] + a[end_idx] > M) {
                end_idx--;
            } else {
                start_idx++;
                end_idx--;
                count++;
            }
        }
        System.out.println(count);
    }
}