import java.util.*;
import java.io.*;

public class Main {
    static Set<String> set = new HashSet<>();
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            set.add(str);
        }

        for (int i = 0; i < m; i++) {
            String tmp = br.readLine();
            solve(tmp);
        }

        System.out.println(cnt);
    }

    static void solve(String s) {
        if (set.contains(s)) {
            cnt++;
        }
    }
}