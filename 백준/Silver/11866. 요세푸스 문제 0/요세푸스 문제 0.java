import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static ArrayList<Integer> list;
    static Queue<Integer> q;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        q = new LinkedList<>();
        list = new ArrayList<>(N);
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        while (list.size() != N) {
            pro();
        }
        sb.append("<");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb.toString());
    }

    static void pro() {
        int cnt = 1;
        while (cnt < K) {
            int tmp = q.poll();
            q.add(tmp);
            cnt++;
        }
        list.add(q.poll());
    }
}