package org.example.tony.D4_08.나의인생에는수학과함께;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = temp[j].charAt(0);
            }
        }

        Result r = play(0, 0, '+', 0, true);
        System.out.println(r.max + " " + r.min);
    }

    static int N;
    static char[][] map;
    static int[] dirX = new int[]{0, 1};
    static int[] dirY = new int[]{1, 0};
    static int[][] visited;
    static Result play(int x, int y, char op, int res, boolean turn) {
        if (x == N-1 && y == N-1) {
            int v = calc(op, res, map[x][y] - '0');
            return new Result(v, v);
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Result r1;
        if (turn) {
            res = calc(op, res, map[x][y] - '0');
            for (int i = 0; i < 2; i++) {
                int nX = x + dirX[i];
                int nY = y + dirY[i];

                if (!inRange(nX, nY)) continue;
                r1 = play(nX, nY, op, res, false);
                max = Math.max(r1.max, max);
                min = Math.min(r1.min, min);
            }
        } else {
            for (int i = 0; i < 2; i++) {
                int nX = x + dirX[i];
                int nY = y + dirY[i];

                if (!inRange(nX, nY)) continue;
                r1 = play(nX, nY, map[x][y], res, true);
                max = Math.max(r1.max, max);
                min = Math.min(r1.min, min);
            }
        }
        return new Result(max, min);
    }

    static class Result {
        int max;
        int min;

        Result(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }

    static boolean inRange(int x, int y) {
        if (x < 0 || x >= N) return false;
        if (y < 0 || y >= N) return false;
        return true;
    }

    static int calc(char op, int n1, int n2) {
        switch (op) {
            case '+': {
                return n1 + n2;
            }
            case '-': {
                return n1 - n2;
            }
            case '*': {
                return n1*n2;
            }
        }
        return -1;
    }

}
