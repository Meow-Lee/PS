import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String str = "666";
        int cnt=0, num=0;
        
        while(cnt != n){
            num++;
            String s = Integer.toString(num);
            if(s.contains(str)){
                cnt++;
            }
        }
        System.out.println(num);
    }
}