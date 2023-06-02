import java.util.*;
import java.io.*;

public class Main {
    static Queue<Pair> q;
    static ArrayList<Integer> arr;
    static class Pair{
        int num, idx;

        Pair(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(stk.nextToken());
        for (int i = 0; i < t; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());

            arr = new ArrayList<>();
            q = new LinkedList<>();
            stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(stk.nextToken());
                q.offer(new Pair(tmp, j));
                arr.add(tmp);
            }

            int cnt = 0;
            while (true) {
                if (!check()) {
                    q.offer(q.poll());
                    reArrange1();
                } else {
                    Pair cur = q.poll();
                    if (cur.idx == m) {
                        System.out.println(++cnt);
                        break;
                    } else {
                        cnt++;
                    }
                    reArrange2();
                }
            }
        }
    }

    static boolean check() {
        int cur = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (cur < arr.get(i)) {
                return false;
            }
        }
        return true;
    }

    static void reArrange1() {
        arr.add(arr.get(0));
        arr.remove(arr.get(0));
    }

    static void reArrange2() {
        arr.remove(arr.get(0));
    }
}