import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int ans = 0;
        if (N < 5 && N % 3 != 0) {
            System.out.println(-1);
        } else {
            while (N > 0) {
                if (N % 5 == 0) {
                    ans += N / 5;
                    N %= 5;
                } else {
                    N -= 3;
                    ans++;
                }
            }
            if (N != 0) {
                System.out.println(-1);
            } else {
                System.out.println(ans);
            }
        }
    }
}