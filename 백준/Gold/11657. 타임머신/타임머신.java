import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static long[] distance;
    static Edge[] edges;
    static class Edge {
        int start, end, w;

        Edge(int start, int end, int w) {
            this.start = start;
            this.end = end;
            this.w = w;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        distance = new long[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        edges = new Edge[M + 1];
        for (int i = 1; i <= M; i++) {
            stk = new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(stk.nextToken());
            int B = Integer.parseInt(stk.nextToken());
            int C = Integer.parseInt(stk.nextToken());

            edges[i] = new Edge(A, B, C);
        }

        distance[1] = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= M; j++) {
                Edge cur = edges[j];
                if (distance[cur.start] != Integer.MAX_VALUE && distance[cur.end] > distance[cur.start] + cur.w) {
                    distance[cur.end] = distance[cur.start] + cur.w;
                }
            }
        }

        boolean isCycle = false;
        for (int i = 1; i <= M; i++) {
            Edge cur = edges[i];
            if (distance[cur.start] != Integer.MAX_VALUE && distance[cur.end] > distance[cur.start] + cur.w) {
                isCycle = true;
                break;
            }
        }

        if (isCycle) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    System.out.println(-1);
                } else {
                    System.out.println(distance[i]);
                }
            }
        }
    }
}