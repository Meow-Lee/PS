import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();

        long sum = 0, cnt = 1;
        while (sum <= s) {
            sum+=cnt;
            cnt++;
        }
        System.out.println(cnt-2);
    }
}