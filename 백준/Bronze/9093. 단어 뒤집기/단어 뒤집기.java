import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            Stack<Character> stack = new Stack<>();

            String[] str = br.readLine().split(" ");
            for (int j = 0; j < str.length; j++) {
                String s = str[j];

                if (s.length() == 1) {
                    sb.append(s).append(" ");
                } else {
                    for (int k = 0; k < s.length(); k++) {
                        stack.push(s.charAt(k));
                    }
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                }
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}