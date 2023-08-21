import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        int[] arr = new int[N];
        boolean[] visit = new boolean[N];
        stk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);

        int[] print = new int[M];
        backTracking(arr, visit, print, 0, 0);
    }

    private static void backTracking(int[] arr, boolean[] visit, int[] print, int start, int count) {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(print[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                print[count] = arr[i];
                backTracking(arr, visit, print, i + 1, count + 1);
                visit[i] = false;
            }
        }
    }
}