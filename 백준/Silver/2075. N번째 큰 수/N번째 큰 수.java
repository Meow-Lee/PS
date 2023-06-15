import java.util.*;
import java.io.*;

public class Main {
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // max heap
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                pq.offer(Integer.parseInt(stk.nextToken()));
            }
        }

        solve(n);
    }

    static void solve(int num) {
        int cnt = 0;
        int tmp = 0;
        while (cnt != num) {
            tmp = pq.poll();
            cnt++;
        }
        System.out.println(tmp);
    }
}