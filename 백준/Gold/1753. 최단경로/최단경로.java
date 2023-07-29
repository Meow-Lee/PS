import java.util.*;
import java.io.*;

public class Main {
    static int V, E, K;
    static boolean[] visit;
    static int[] distance;
    static ArrayList<Info>[] lists;
    static PriorityQueue<Info> pq;
    static class Info implements Comparable<Info> {
        int end, w;

        Info(int end, int w) {
            this.end = end;
            this.w = w;
        }

        @Override
        public int compareTo(Info info) {
            if (this.w == info.w) {
                return this.end - info.end;
            }
            return this.w - info.w;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(stk.nextToken());
        E = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(br.readLine());

        lists = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            stk = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());

            lists[u].add(new Info(v, w));
        }

        visit = new boolean[V + 1];
        distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        pq = new PriorityQueue<>();

        distance[K] = 0;
        pq.offer(new Info(K, 0));

        while (!pq.isEmpty()) {
            Info cur = pq.poll();
            if (visit[cur.end]) {
                continue;
            }
            visit[cur.end] = true;
            for (Info next : lists[cur.end]) {
                if (distance[next.end] > distance[cur.end] + next.w) {
                    distance[next.end] = distance[cur.end] + next.w;
                    pq.offer(new Info(next.end, distance[next.end]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }
}