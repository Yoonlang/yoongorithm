package org.example.tony.D4_04.파이프옮기기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 3
 * 0 0 0
 * 0 0 0
 * 0 0 0
 */

public class Main {
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        dp = new int[N][N][3];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            map[i] = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();
        }

        play(0, 1, 0, map);
        System.out.println(dp[0][1][0]);
    }

    static int N;
    static int[][] dirX = new int[][]{{0, 1, -1}, {0, 1, 1}, {-1, 1, 1}};
    static int[][] dirY = new int[][]{{1, 1, -1}, {1, 1, 0}, {-1, 1, 0}};
    static int play(int x, int y, int dir, int[][] map) {
        if (x == N-1 && y == N-1) return 1;
        if (dp[x][y][dir] != 0) return dp[x][y][dir];

        int[] dX = dirX[dir];
        int[] dY = dirY[dir];

        int result = 0;
        for (int i = 0; i < 3; i++) {
            if (dX[i] == -1) continue;

            int nX = x + dX[i];
            int nY = y + dY[i];

            if (!inRange(nX, nY)) continue;
            if (map[nX][nY] == 1) {
                continue;
            }

            if (i == 1) {
                if (map[x+1][y] == 1 || map[x][y+1] == 1) {
                    continue;
                }
            }

            result += play(nX, nY, i, map);
        }

        return dp[x][y][dir] = result;
    }

    static boolean inRange(int x, int y) {
        if (x < 0 || x >= N) return false;
        if (y < 0 || y >= N) return false;
        return true;
    }
}
