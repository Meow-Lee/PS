import java.util.*;
import java.io.*;

public class Main {
    static int V, E;
    static int[] parent;

    static class Info implements Comparable<Info> {
        int v1, v2, cost;

        Info(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Info o){
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(stk.nextToken());
        E = Integer.parseInt(stk.nextToken());

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        PriorityQueue<Info> pq = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());

            pq.offer(new Info(a, b, c));
        }

        int count = 0;
        int sum = 0;
        while (count < V - 1) {
            Info cur = pq.poll();
            if (find(cur.v1) != find(cur.v2)) {
                union(cur.v1, cur.v2);
                count++;
                sum += cur.cost;
            }
        }
        System.out.println(sum);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int v) {
        if (parent[v] == v) {
            return v;
        }
        return find(parent[v]);
    }

}