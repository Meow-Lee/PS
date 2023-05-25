import java.util.*;
import java.io.*;

class Main {
    static class Info implements Comparable<Info> {
        int idx, val;

        @Override
        public int compareTo(Info o) {
            return val - o.val;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        Info[] A = new Info[n];
        int[] A1 = new int[n];

        stk = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            A[i] = new Info();
            A[i].idx = i;
            A[i].val = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(A);
        for(int i=0; i<n; i++){
            A1[A[i].idx] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            sb.append(A1[i] + " ");
        }
        System.out.println(sb.toString());
    }
}