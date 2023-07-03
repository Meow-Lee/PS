import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static int[] dist = new int[100001];
    static boolean[] visit = new boolean[100001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        bfs();
        System.out.println(dist[k]);
    }
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visit[n] = true;
        dist[n] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur - 1 >= 0 && !visit[cur - 1]) {
                visit[cur-1]=true;
                dist[cur - 1] = dist[cur] + 1;
                q.offer(cur - 1);
            }
            if (cur + 1 <= 100000 && !visit[cur + 1]) {
                visit[cur + 1] = true;
                dist[cur + 1] = dist[cur] + 1;
                q.offer(cur + 1);
            }
            if (cur * 2 <= 100000 && !visit[cur * 2]) {
                visit[cur * 2] = true;
                dist[cur * 2] = dist[cur] + 1;
                q.offer(cur * 2);
            }
        }
    }
}