import java.util.*;
import java.io.*;

public class Main{
    static int[] alpha;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(stk.nextToken());
        String a = "abcdefghijklmnopqrstuvwxyz";
        char[] abc = a.toCharArray();

        for(int i=0; i<t; i++){
            alpha = new int[26];
            String s = br.readLine();
            char[] ch = s.toCharArray();
            
            for(int j=0; j<ch.length; j++){
                if(ch[j]==' '){
                    continue;
                }
                alpha[ch[j]-97]++;
            }

            int max=0, cnt=0, idx=0;
            for(int j=0; j<alpha.length; j++){
                if(max < alpha[j]){
                    max = alpha[j];
                    idx = j;
                }
            }

            for(int j=0; j<alpha.length; j++){
                if(j==idx){
                    continue;
                }
                if(max==alpha[j]){
                    cnt++;
                    break;
                }
            }

            if(cnt>0){
                System.out.println("?");
            }
            else{
                System.out.println(abc[idx]);
            }
        }
    }
}