import java.util.*;
import java.io.*;

public class Main {
    static int[] a;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        a = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(a);

        int M = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int ans = search(Integer.parseInt(stk.nextToken()));
            System.out.println(ans);
        }
    }

    private static int search(int target) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == target) {
                return 1;
            }
            if (a[mid] > target) {
                right = mid - 1;
            }
            if (a[mid] < target) {
                left = mid + 1;
            }
        }
        return 0;
    }
}