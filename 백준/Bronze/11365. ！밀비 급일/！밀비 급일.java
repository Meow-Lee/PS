import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String str = br.readLine();
            if(str.equals("END")){
                break;
            }
            StringBuilder rev = new StringBuilder(str);
            rev = rev.reverse();
            sb.append(rev + "\n");
        }
        System.out.println(sb);
    }
}