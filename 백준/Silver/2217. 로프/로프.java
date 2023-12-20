import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int k = 0;
        int w = 0;
        while (!pq.isEmpty()) {
            int least = pq.poll();
            k++;

            int sum = least * k;
            if (w < sum) {
                w = sum;
            }
        }
        System.out.println(w);
    }
}