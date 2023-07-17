import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            q.offer(Integer.parseInt(br.readLine()));
        }


        int ans = 0, sum = 0, cnt = 0;
        while (!q.isEmpty()) {
            sum += q.poll();
            cnt++;
            if (cnt == 2) {
                cnt = 0;
                ans += sum;
                q.offer(sum);
                sum = 0;
            }
        }
        System.out.println(ans);
    }
}