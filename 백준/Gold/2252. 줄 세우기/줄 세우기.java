import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] lists;
    static int[] degree;
    static StringBuilder sb;
    static Queue<Integer> q;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        lists = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        degree = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            degree[i] = 0;
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(stk.nextToken());
            int B = Integer.parseInt(stk.nextToken());

            lists[A].add(B);
            degree[B]++;
        }

        sb = new StringBuilder();
        q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                q.offer(i);
            }
        }
        pro();
        System.out.println(sb.toString());
    }

    static void pro() {
        while (!q.isEmpty()) {
            int start = q.poll();
            sb.append(start).append(' ');
            for (int cur : lists[start]) {
                degree[cur]--;
                if (degree[cur] == 0) {
                    q.offer(cur);
                }
            }
        }
    }
}