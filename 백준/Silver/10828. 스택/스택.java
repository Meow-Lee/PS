import java.util.*;
import java.io.*;

public class Main {
    static Stack<Integer> stack = new Stack<>();
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
            } else {
                top();
            }
        }
    }

    static void push(int x) {
        stack.push(x);
    }

    static void pop() {
        if (stack.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(stack.peek());
            stack.pop();
        }
    }

    static void size() {
        System.out.println(stack.size());
    }

    static void empty() {
        if (stack.isEmpty()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static void top() {
        if (stack.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(stack.peek());
        }
    }
}