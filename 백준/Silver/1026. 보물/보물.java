import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }

        int[] b = new int[N];
        stk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            b[i] = Integer.parseInt(stk.nextToken());
        }

        int min = 0;
        Arrays.sort(a);
        Arrays.sort(b);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += a[i] * b[N - 1 - i];
        }
        System.out.println(sum);
    }
}