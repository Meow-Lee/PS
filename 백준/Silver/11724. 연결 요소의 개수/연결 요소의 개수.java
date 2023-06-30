import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        visit = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    static void dfs(int start) {
        visit[start] = true;

        for (int i : list[start]) {
            if (!visit[i]) {
                dfs(i);
            }
        }
    }
}