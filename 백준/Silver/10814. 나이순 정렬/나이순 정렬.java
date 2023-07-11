import java.util.*;
import java.io.*;

public class Main {
    static int N;

    static class Info implements Comparable<Info> {
        int age, num;
        String name;

        Info(int age, String name, int num) {
            this.age = age;
            this.name = name;
            this.num = num;
        }

        @Override
        public int compareTo(Info o) {
            if (this.age == o.age) {
                return this.num - o.num;
            }
            return this.age - o.age;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        ArrayList<Info> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

            int age = Integer.parseInt(stk.nextToken());
            String name = stk.nextToken();

            list.add(new Info(age, name, i + 1));
        }
        Collections.sort(list);

        for (Info o : list) {
            System.out.println(o.age + " " + o.name);
        }
    }
}