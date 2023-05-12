import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        String[] str = br.readLine().split("");
        
        int ans=0;
        for(int i=0; i<str.length; i++){
            ans += Integer.parseInt(str[i]);
        }
        System.out.println(ans);
    }
}