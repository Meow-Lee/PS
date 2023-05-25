import java.util.*;
import java.io.*;

class Main {
    static class Info implements Comparable<Info>{
        String name;
        int kor, eng, math;

        @Override
        public int compareTo(Info o) {
            if (kor != o.kor) {
                return o.kor - kor;
            }
            if (eng != o.eng) {
                return eng - o.eng;
            }
            if (math != o.math) {
                return o.math - math;
            }
            return name.compareTo(o.name);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        Info[] list = new Info[n];
        for(int i=0; i<n; i++){
            list[i] = new Info();
            stk = new StringTokenizer(br.readLine(), " ");
            list[i].name = stk.nextToken();
            list[i].kor = Integer.parseInt(stk.nextToken());
            list[i].eng = Integer.parseInt(stk.nextToken());
            list[i].math = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.length; i++){
            sb.append(list[i].name+"\n");
        }
        System.out.println(sb.toString());
    }
}