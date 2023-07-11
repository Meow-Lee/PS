import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            if (c > b && c > a) {
                check(a, b, c);
            } else if (a > b && a > c) {
                check(b, c, a);
            } else {
                check(a, c, b);
            }
        }
    }

    private static void check(int a, int b, int c) {
        if (Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2)) {
            System.out.println("right");
        } else {
            System.out.println("wrong");
        }
    }
}