import java.util.*;
import java.io.*;

public class Main {
    static Map<String, String> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            map.put(str, String.valueOf(i));
            map.put(String.valueOf(i), str);
        }

        for (int i = 0; i < m; i++) {
            String tmp = br.readLine();
            solve(tmp);
        }

        System.out.println(sb.toString());
    }

    static void solve(String s) {
        if (map.containsKey(s)) {
            sb.append(map.get(s)).append("\n");
        }
    }
}