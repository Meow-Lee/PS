import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] card;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        card = new int[n];
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(card);

        m = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            sb.append(search(Integer.parseInt(stk.nextToken()))).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static int search(int target) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (card[mid] == target) {
                return 1;
            }
            if (card[mid] < target) {
                left = mid + 1;
            }
            if (card[mid] > target) {
                right = mid - 1;
            }
        }
        return 0;
    }
}