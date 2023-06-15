import java.util.*;
import java.io.*;

public class Main {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            solve(tmp);
        }
        System.out.println(sb.toString());
    }

    static void solve(int num) {
        if (num == 0) {
            if (pq.isEmpty()) {
                sb.append("0\n");
            } else {
                sb.append(pq.poll()).append("\n");
            }
        } else {
            pq.offer(num);
        }
    }
}