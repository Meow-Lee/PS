import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s= br.readLine();
        String p = br.readLine();

        if(kmpSearch(s, p)==-1){
            System.out.println(0);
        }
        else{
            System.out.println(1);
        }
    }

    public static int kmpSearch(String text, String pattern){
        int[] prefixTable = buildTable(pattern);
        int j=0;
        for(int i=0; i<text.length(); i++){
            while(j>0 && text.charAt(i)!=pattern.charAt(j)){
                j = prefixTable[j-1];
            }
            if(text.charAt(i)==pattern.charAt(j)){
                j++;
            }
            if(j==pattern.length()){
                return i-pattern.length()+1;
            }
        }
        return -1;
    }

    public static int[] buildTable(String pattern){
        int[] prefixTable = new int[pattern.length()];
        int j=0;
        for(int i=1; i<pattern.length(); i++){
            while(j>0 && pattern.charAt(i) != pattern.charAt(j)){
                j = prefixTable[j-1];
            }
            if(pattern.charAt(i)==pattern.charAt(j)){
                prefixTable[i] = j+1;
                j++;
            }
            else{
                prefixTable[i] = 0;
            }
        }
        return prefixTable;
    }
}