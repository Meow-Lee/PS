import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int money = 1000;
        int[] rest = {500, 100, 50, 10, 5, 1};
        int pay = Integer.parseInt(br.readLine());

        int take = money - pay;
        int cnt = 0;
        for (int i = 0; i < rest.length; i++) {
            if (take >= rest[i]) {
                cnt += take / rest[i];
                take %= rest[i];
            }
        }
        System.out.println(cnt);
    }
}