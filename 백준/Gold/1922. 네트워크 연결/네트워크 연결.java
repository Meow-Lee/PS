import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] parent;

    static class Info implements Comparable<Info> {
        int a,b, cost;

        Info(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Info info) {
            return this.cost - info.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        PriorityQueue<Info> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());

            pq.offer(new Info(a, b, c));
        }

        int cost = 0;
        int edgeCount = 0;
        while (edgeCount < N - 1) {
            Info cur = pq.poll();
            if (find(cur.a) != find(cur.b)) { // 사이클이 없고 서로 연결 가능
                union(cur.a, cur.b);
                edgeCount++;
                cost += cur.cost;
            }
        }
        System.out.println(cost);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }


}