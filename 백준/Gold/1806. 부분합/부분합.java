import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(stk.nextToken());
        int S = Integer.parseInt(stk.nextToken());

        int[] a = new int[N];
        stk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }

        int left = 0, right = 1, sum = a[0], len = Integer.MAX_VALUE;
        while (true) {
            if (sum >= S) {
                sum -= a[left];
                left++;
                len = Math.min(len, right - left + 1);
            } else if (right == N) {
                break;
            } else {
                sum += a[right];
                right++;
            }
        }

        if (len == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(len);
        }
    }
}