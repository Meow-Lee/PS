import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] list = new long[n];
        for(int i=0; i<n; i++){
            list[i] = sc.nextLong();
        }
        Arrays.sort(list);
        long num = list[0];
        int cnt = 1, ans = 1;
        for (int i = 1; i < list.length; i++) {
            if (list[i] == list[i-1]) {
                cnt++;
            } else {
                cnt = 1;
            }

            if (ans < cnt) {
                ans = cnt;
                num = list[i];
            }
        }
        System.out.println(num);
    }
}