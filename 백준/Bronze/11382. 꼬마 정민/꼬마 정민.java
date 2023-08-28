import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        long A = Long.parseLong(stk.nextToken());
        long B = Long.parseLong(stk.nextToken());
        long C = Long.parseLong(stk.nextToken());

        System.out.println(A + B + C);
    }
}