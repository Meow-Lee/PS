import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(stk.nextToken());

        for (int i = 0; i < t; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(stk.nextToken());
            int W = Integer.parseInt(stk.nextToken());
            int N = Integer.parseInt(stk.nextToken());

            int x = (N / H) + 1;
            int y = N % H;

            if (y == 0) {
                y = H;
                x -= 1;
            }
            System.out.printf("%d%02d\n", y, x);
        }
    }
}