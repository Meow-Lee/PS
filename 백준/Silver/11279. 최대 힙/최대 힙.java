import java.util.*;
import java.io.*;

public class Main {
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            solve(tmp);
        }
        System.out.println(sb.toString());
    }

    static void solve(int num) {
        if (num == 0) {
            if (pq.isEmpty()) {
                sb.append("0").append("\n");
            } else {
                int a = pq.poll();
                sb.append(a).append("\n");
            }
        } else {
            pq.offer(num);
        }
    }
}