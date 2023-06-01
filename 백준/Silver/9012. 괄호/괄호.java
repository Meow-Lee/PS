import java.util.*;
import java.io.*;

public class Main {
    static Stack<String> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");

            vps(str);
        }
    }

    static void vps(String[] str) {
        stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("(")) {
                stack.push(str[i]);
            } else {
                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                } else {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}