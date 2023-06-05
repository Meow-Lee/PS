import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(stk.nextToken());

        int num = 1;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            while (num <= tmp) {
                st.push(num++);
                sb.append("+").append("\n");
            }
            if (tmp == st.peek()) {
                st.pop();
                sb.append("-").append("\n");
            } else {
                sb = new StringBuilder();
                sb.append("NO");
                break;
            }
        }
        System.out.println(sb.toString());
    }
}