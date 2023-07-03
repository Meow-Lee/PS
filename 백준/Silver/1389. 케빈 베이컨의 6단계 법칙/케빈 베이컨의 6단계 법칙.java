import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] list;
    static int[] dist;

    static class Info implements Comparable<Info> {
        int sum, num;

        Info(int sum, int num) {
            this.sum = sum;
            this.num = num;
        }

        @Override
        public int compareTo(Info info) {
            if (this.sum == info.sum) {
                return this.num - info.num;
            }
            return this.sum - info.sum;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        list = new ArrayList[n + 1];
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

        ArrayList<Info> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            bfs(i);
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += dist[j];
            }
            arr.add(new Info(sum, i));
        }
        Collections.sort(arr);

        System.out.println(arr.get(0).num);
    }

    static void bfs(int start) {
        dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int o : list[cur]) {
                if (dist[o] == -1) {
                    q.offer(o);
                    dist[o] = dist[cur] + 1;
                }
            }
        }
    }
}