import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] graph;
    static boolean[] visit;
    static StringBuilder sb;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());

        graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            visit = new boolean[n + 1];
            bfs(i);
        }
        System.out.println(sb.toString());
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = false;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= n; i++) {
                if (visit[i] || graph[cur][i] == 0) {
                    continue;
                }
                q.offer(i);
                visit[i] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (visit[i]) {
                sb.append(1).append(' ');
            } else {
                sb.append(0).append(' ');
            }
        }
        sb.append('\n');
    }
}