import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int start_idx = 1, end_idx = 1, sum = 1, count = 1;
        while (end_idx < N) {
            if (sum < N) {
                end_idx++;
                sum += end_idx;
            } else if (sum > N) {
                sum -= start_idx;
                start_idx++;
            } else {
                count++;
                end_idx++;
                sum += end_idx;
            }
        }
        System.out.println(count);
    }
}