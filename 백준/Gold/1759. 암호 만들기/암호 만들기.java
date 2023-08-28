import java.util.*;
import java.io.*;

public class Main {
    static int L, C;
    static String[] alpha;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        L = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());

        alpha = br.readLine().split(" ");
        Arrays.sort(alpha);
        visit = new boolean[C];

        combination("", 0, 0);
    }

    private static void combination(String str, int count, int start) {
        if (count == L) {
            if (check(str)) {
                System.out.println(str);
            }
            return;
        }
        for (int i = start; i < alpha.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                combination(str + alpha[i], count + 1, i + 1);
                visit[i] = false;
            }
        }
    }

    private static boolean check(String str) {
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                cnt1++;
            } else {
                cnt2++;
            }
        }

        if (cnt1 >= 1 && cnt2 >= 2) {
            return true;
        }
        return false;
    }
}