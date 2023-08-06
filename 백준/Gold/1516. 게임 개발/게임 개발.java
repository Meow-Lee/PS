import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] building;
    static int[] time;
    static int[] fan_in;
    static int[] dp;
    static final int INF = (int) 1e9;
    static Queue<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        building = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            building[i] = new ArrayList<>();
        }
        time = new int[N + 1];
        fan_in = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

            time[i] = Integer.parseInt(stk.nextToken());

            while (true) {
                int idx = Integer.parseInt(stk.nextToken());
                if (idx == -1) {
                    break;
                }
                building[idx].add(i);
                fan_in[i]++;
            }
        }

        q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (fan_in[i] == 0) {
                q.offer(i);
                dp[i] = time[i];
            }
        }
        pro();
        for (int i = 1; i <= N; i++) {
            System.out.println(dp[i]);
        }
    }

    private static void pro() {
        while (!q.isEmpty()) {
            int start = q.poll();
            for (int node : building[start]) {
                fan_in[node]--;
                if (fan_in[node] == 0) {
                    q.offer(node);
                }
                dp[node] = Math.max(dp[node], dp[start] + time[node]);
            }
        }
    }
}