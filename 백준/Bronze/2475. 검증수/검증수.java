import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int ans = 0;
        for (int i = 0; i < 5; i++) {
            int tmp = Integer.parseInt(stk.nextToken());
            ans += Math.pow(tmp, 2);
        }
        System.out.println(ans % 10);
    }
}