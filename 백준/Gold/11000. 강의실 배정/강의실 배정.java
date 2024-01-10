import java.util.*;
import java.io.*;

public class Main {
    static class Pair implements Comparable<Pair> {
        int s, e;

        Pair(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Pair pair) {
            if (this.s == pair.s) {
                return this.e - pair.e;
            }
            return this.s - pair.s;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(stk.nextToken());
            int t = Integer.parseInt(stk.nextToken());

            list.add(new Pair(s, t));
        }
        Collections.sort(list);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int end = 0;
        for (Pair p : list) {
            end = p.e;

            if (!pq.isEmpty() && pq.peek() <= p.s) {
                pq.poll();
            }
            pq.add(end);
        }
        System.out.println(pq.size());
    }
}