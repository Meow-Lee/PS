import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        String s = stk.nextToken();
        int i = Integer.parseInt(br.readLine());

        System.out.println(s.charAt(i-1));
    }
}