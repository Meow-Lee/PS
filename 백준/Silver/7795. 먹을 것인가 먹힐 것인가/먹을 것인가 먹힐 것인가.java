import java.util.*;
import java.io.*;

class Main {
    static int t, n, m;
    static int[] A;
    static int[] B;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        t = Integer.parseInt(stk.nextToken());
        for (int i = 0; i < t; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(stk.nextToken());
            m = Integer.parseInt(stk.nextToken());

            A = new int[n];
            B = new int[m];

            stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                A[j] = Integer.parseInt(stk.nextToken());
            }

            stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                B[j] = Integer.parseInt(stk.nextToken());
            }

            Arrays.sort(B);
            int sum=0;
            for (int j = 0; j < A.length; j++) {
                sum += search(0, m - 1, A[j]);
            }
            System.out.println(sum);
        }
    }

    static int search(int L, int R, int target) {
        int cnt = 0;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (B[mid] < target) {
                L = mid + 1;
                cnt = mid + 1;
            }
            else{
                R = mid - 1;
            }
        }
        return cnt;
    }
}