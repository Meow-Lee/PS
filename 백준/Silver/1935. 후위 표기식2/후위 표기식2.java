import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        String[] str = br.readLine().split("");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> st = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            if (str[i].charAt(0) >= 65 && str[i].charAt(0) <= 90) {
                int tmp = str[i].charAt(0) - 65;
                st.add((double) arr[tmp]);
            } else {
                double a = st.pop();
                double b = st.pop();
                if (str[i].equals("+")) {
                    st.add(b + a);
                } else if (str[i].equals("-")) {
                    st.add(b - a);
                } else if (str[i].equals("*")) {
                    st.add(b * a);
                } else {
                    st.add(b / a);
                }
            }
        }
        System.out.printf("%.2f", st.peek());
    }
}