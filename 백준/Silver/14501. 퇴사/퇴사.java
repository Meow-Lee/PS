import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int ans;
    static int[] t;
    static int[] p;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(stk.nextToken());
        t = new int[n+1];
        p = new int[n+1];
        for(int i=1; i<=n; i++){
            stk = new StringTokenizer(br.readLine(), " ");
            t[i] = Integer.parseInt(stk.nextToken());
            p[i] = Integer.parseInt(stk.nextToken());
        }
        sol(1, 0);
        System.out.println(ans);
    }

    static void sol(int day, int sum){
        if(day==n+1){
            if(ans<sum){
                ans = sum;
            }
            return;
        }
        if(day>n+1){
            return;
        }

        sol(day+t[day], sum+p[day]);
        sol(day+1, sum);
    }
}