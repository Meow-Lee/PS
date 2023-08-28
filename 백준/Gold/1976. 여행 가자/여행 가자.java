import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] parent;
    static StringTokenizer stk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                int tmp = Integer.parseInt(stk.nextToken());
                if (tmp == 1) {
                    union(i, j);
                }
            }
        }

        stk = new StringTokenizer(br.readLine(), " ");
        boolean isYes = true;
        int ans = 0;
        for (int i = 0; i < M; i++) {
            int tmp = Integer.parseInt(stk.nextToken());
            if (ans == 0) {
                ans = find(tmp);
            } else {
                if (ans != find(tmp)) {
                    isYes = false;
                    break;
                }
            }
        }

        if (isYes) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }
}