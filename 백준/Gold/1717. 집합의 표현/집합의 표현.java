import java.util.*;
import java.io.*;

public class Main{
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        parent = new int[n+1];
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }

        for(int i=0; i<m; i++){
            stk = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(stk.nextToken());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            if(k==0){
                union(a, b);
            }
            else{
                if(find(a) == find(b)){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
        }
    }

    public static void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if(a != b){
            parent[b] = a;
        }
    }

    public static int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}