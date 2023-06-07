import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        boolean check = false;
        String[] arr = br.readLine().split(" ");

        for (int i = 1; i < 8; i++) {
            int tmp = Math.abs(Integer.parseInt(arr[i]) - Integer.parseInt(arr[i - 1]));
            if (tmp != 1) {
                check = true;
                break;
            } else {
                if (arr[0].equals("1")) {
                    flag = true;
                } else {
                    flag = false;
                }
            }
        }

        if (check) {
            sb.append("mixed");
        } else if (flag) {
            sb.append("ascending");
        } else {
            sb.append("descending");
        }
        System.out.println(sb.toString());
    }
}