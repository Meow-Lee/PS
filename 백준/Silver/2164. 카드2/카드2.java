import java.util.*;
import java.io.*;

public class Main {
    static Deque<Integer> dq = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(stk.nextToken());
        for (int i = 1; i <= n; i++) {
            dq.addLast(i);
        }

        while (true) {
            if (dq.size() == 1) {
                break;
            }
            dq.pollFirst();
            int tmp = dq.pollFirst();
            dq.addLast(tmp);
        }
        System.out.println(dq.poll());
    }
}