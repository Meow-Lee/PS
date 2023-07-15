import java.util.*;
import java.io.*;

public class Main {
    static int[] curArr;
    static int[] checkArr;
    static int checkResult;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int S = Integer.parseInt(stk.nextToken());
        int P = Integer.parseInt(stk.nextToken());

        char[] arr = br.readLine().toCharArray();
        curArr = new int[4];
        checkArr = new int[4];
        stk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            int tmp = Integer.parseInt(stk.nextToken());
            if (tmp == 0) {
                checkResult++;
            }
            checkArr[i] = tmp;
        }

        for (int i = 0; i < P; i++) {
            add(arr[i]);
        }

        int count = 0;
        if (checkResult == 4) {
            count++;
        }

        for (int i = P; i < S; i++) {
            int j = i - P;
            add(arr[i]);
            remove(arr[j]);
            if (checkResult == 4) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void remove(char c) {
        switch (c) {
            case 'A':
                if (curArr[0] == checkArr[0]) {
                    checkResult--;
                }
                curArr[0]--;
                break;
            case 'C':
                if (curArr[1] == checkArr[1]) {
                    checkResult--;
                }
                curArr[1]--;
                break;
            case 'G':
                if (curArr[2] == checkArr[2]) {
                    checkResult--;
                }
                curArr[2]--;
                break;
            case 'T':
                if (curArr[3] == checkArr[3]) {
                    checkResult--;
                }
                curArr[3]--;
                break;
        }
    }

    private static void add(char c) {
        switch (c) {
            case 'A':
                curArr[0]++;
                if (curArr[0] == checkArr[0]) {
                    checkResult++;
                }
                break;
            case 'C':
                curArr[1]++;
                if (curArr[1] == checkArr[1]) {
                    checkResult++;
                }
                break;
            case 'G':
                curArr[2]++;
                if (curArr[2] == checkArr[2]) {
                    checkResult++;
                }
                break;
            case 'T':
                curArr[3]++;
                if (curArr[3] == checkArr[3]) {
                    checkResult++;
                }
                break;
        }
    }
}