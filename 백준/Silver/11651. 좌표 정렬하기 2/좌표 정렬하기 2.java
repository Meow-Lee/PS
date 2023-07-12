import java.util.*;
import java.io.*;

public class Main {
    static class Pair implements Comparable<Pair>{
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.y == o.y) {
                return this.x - o.x;
            }
            return this.y - o.y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Pair[] list = new Pair[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            list[i] = new Pair(x, y);
        }
        Arrays.sort(list);

        for (Pair cur : list) {
            System.out.println(cur.x + " " + cur.y);
        }
    }
}