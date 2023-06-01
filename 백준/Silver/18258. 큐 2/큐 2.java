import java.util.*;
import java.io.*;

public class Main {
    static Queue<Integer> q = new LinkedList<>();
    static int last;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            String str = stk.nextToken();
            if (str.equals("push")) {
                int tmp = Integer.parseInt(stk.nextToken());
                push(tmp);
            } else if (str.equals("pop")) {
                pop();
            } else if (str.equals("size")) {
                size();
            } else if (str.equals("empty")) {
                empty();
            } else if (str.equals("front")) {
                front();
            } else {
                back();
            }
        }
        System.out.println(sb.toString());
    }

    static void push(int x) {
        q.offer(x);
        last = x;
    }

    static void pop() {
        if (q.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            int n = q.poll();
            sb.append(n).append("\n");
        }
    }

    static void size() {
        sb.append(q.size()).append("\n");
    }

    static void empty() {
        if (q.isEmpty()) {
            sb.append(1).append("\n");
        } else {
            sb.append(0).append("\n");
        }
    }

    static void front() {
        if (q.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            sb.append(q.peek()).append("\n");
        }
    }

    static void back() {
        if (q.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            sb.append(last).append("\n");
        }
    }
}