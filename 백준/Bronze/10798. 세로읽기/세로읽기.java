import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] str = new String[5][15];

        for(int i=0; i<5; i++){
            String[] s = br.readLine().split("");
            for(int j=0; j<15; j++){
                if(j<s.length){
                    str[i][j] = s[j];
                }
                else{
                    str[i][j]="X";
                }
            }
        }

        for(int i=0; i<15; i++){
            for(int j=0; j<5; j++){
                if(str[j][i]=="X"){
                    continue;
                }
                System.out.print(str[j][i]);
            }
        }
    }
}