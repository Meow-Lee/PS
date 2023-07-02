import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());

        list = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            stk = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            list[a].add(b);
            list[b].add(a);
        }
        bfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int node : list[cur]) {
                if (visit[node]) {
                    continue;
                }
                q.offer(node);
                parent[node] = cur;
                visit[node] = true;
            }
        }
    }
}