import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<Pair> list;
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            list.add(new Pair(x, y));
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1.x == o2.x) {
                return o1.y - o2.y;
            }
            return o1.x - o2.x;
        } );

        for (Pair cur : list) {
            System.out.println(cur.x + " " + cur.y);
        }
    }
}