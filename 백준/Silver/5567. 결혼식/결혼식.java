import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] list;
    static int[] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stk.nextToken());

        list = new ArrayList[n + 1];
        dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        bfs(1);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        for (int i = 1; i <= n; i++) {
            dist[i] = -1;
        }
        dist[start] = 0;

        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (dist[cur] >= 1 && dist[cur] <= 2) {
                cnt++;
            }
            if (dist[cur] == 2) {
                continue;
            }

            for (int o : list[cur]) {
                if (dist[o] == -1) {
                    q.offer(o);
                    dist[o] = dist[cur] + 1;
                }
            }
        }
        System.out.println(cnt);
    }
}