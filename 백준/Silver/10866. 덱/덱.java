import java.util.*;
import java.io.*;

public class Main {
    static Deque<Integer> dq = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            String str = stk.nextToken();
            if (str.equals("push_front")) {
                int tmp = Integer.parseInt(stk.nextToken());
                push_front(tmp);
            } else if (str.equals("push_back")) {
                int tmp = Integer.parseInt(stk.nextToken());
                push_back(tmp);
            } else if (str.equals("pop_front")) {
                pop_front();
            } else if (str.equals("pop_back")) {
                pop_back();
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

    static void push_front(int x) {
        dq.addFirst(x);
    }

    static void push_back(int x) {
        dq.addLast(x);
    }

    static void pop_front() {
        if (dq.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            sb.append(dq.pollFirst()).append("\n");
        }
    }

    static void pop_back() {
        if (dq.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            sb.append(dq.pollLast()).append("\n");
        }
    }
    static void size() {
        sb.append(dq.size()).append("\n");
    }
    static void empty() {
        if (dq.isEmpty()) {
            sb.append(1).append("\n");
        } else {
            sb.append(0).append("\n");
        }
    }
    static void front() {
        if (dq.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            sb.append(dq.peekFirst()).append("\n");
        }
    }
    static void back() {
        if (dq.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            sb.append(dq.peekLast()).append("\n");
        }
    }
}