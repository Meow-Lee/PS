import java.util.*;
import java.io.*;

public class Main {
    static Deque<Integer> dq = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        for (int i = 0; i < n; i++) {
            dq.addLast(i + 1);
        }
        System.out.print("<");
        while (true) {
            if (dq.size() == 0) {
                break;
            }
            for (int i = 0; i < k; i++) {
                dq.addLast(dq.pollFirst());
            }

            if (dq.size() > 1) {
                System.out.print(dq.pollLast() + ", ");
            } else {
                System.out.print(dq.pollLast());
            }
        }
        System.out.print(">");
    }
}