import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] list;
    static int[] dist;
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(stk.nextToken());
        int b = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stk.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = -1;
        }
        visit = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            list[x].add(y);
            list[y].add(x);
        }

        bfs(a);

        System.out.println(dist[b]);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;
        visit[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int o : list[cur]) {
                if (!visit[o]) {
                    q.offer(o);
                    dist[o] = dist[cur] + 1;
                    visit[o] = true;
                }
            }
        }
    }
}