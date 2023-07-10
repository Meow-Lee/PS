import java.util.*;
import java.io.*;

public class Main {
    static int M, N, cnt, ans = Integer.MAX_VALUE;
    static String[] board;
    static char[][] checkBoard;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        board = new String[N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine();
        }

        selectBoard();
        if (ans == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }

    private static void check() {
        startWithW();
        startWithB();
    }

    private static void startWithB() {
        cnt = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    if (checkBoard[i][j] != 'B') {
                        cnt++;
                    }
                }
                if (i % 2 == 0 && j % 2 != 0) {
                    if (checkBoard[i][j] != 'W') {
                        cnt++;
                    }
                }
                if (i % 2 != 0 && j % 2 != 0) {
                    if (checkBoard[i][j] != 'B') {
                        cnt++;
                    }
                }
                if (i % 2 != 0 && j % 2 == 0) {
                    if (checkBoard[i][j] != 'W') {
                        cnt++;
                    }
                }
            }
        }
        ans = Math.min(ans, cnt);
    }

    private static void startWithW() {
        cnt = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    if (checkBoard[i][j] != 'W') {
                        cnt++;
                    }
                }
                if (i % 2 == 0 && j % 2 != 0) {
                    if (checkBoard[i][j] != 'B') {
                        cnt++;
                    }
                }
                if (i % 2 != 0 && j % 2 != 0) {
                    if (checkBoard[i][j] != 'W') {
                        cnt++;
                    }
                }
                if (i % 2 != 0 && j % 2 == 0) {
                    if (checkBoard[i][j] != 'B') {
                        cnt++;
                    }
                }
            }
        }
        ans = Math.min(ans, cnt);
    }

    private static void selectBoard() {
        for (int i = 0; i < N; i++) {
            if (N - i < 8) {
                break;
            }
            for (int j = 0; j < M; j++) {
                if (M - j < 8) {
                    break;
                }
                makeBoard(i, j);
                check();
                cnt = 0;
            }
        }
    }

    private static void makeBoard(int x, int y) {
        checkBoard = new char[8][8];
        int idx_x = 0, idx_y = 0;
        for (int i = x; i < x+8; i++) {
            for (int j = y; j < y + 8; j++) {
                checkBoard[idx_x][idx_y] = board[i].charAt(j);
                idx_y++;
            }
            idx_y = 0;
            idx_x++;
        }
    }
}