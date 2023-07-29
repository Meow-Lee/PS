import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K, X;
    static int[] dist;
    static ArrayList<Node>[] lists;

    static class Node implements Comparable<Node> {
        int v, cost;

        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        X = Integer.parseInt(stk.nextToken());

        lists = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());

            lists[u].add(new Node(v, 1));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));
        dist[X] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (Node next : lists[cur.v]) {
                if (dist[next.v] != Integer.MAX_VALUE) {
                    continue;
                }
                if (dist[next.v] > dist[cur.v] + next.cost) {
                    dist[next.v] = dist[cur.v] + next.cost;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }

        boolean hasCity = false;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                System.out.println(i);
                hasCity = true;
            }
        }
        if (!hasCity) {
            System.out.println(-1);
        }
    }
}