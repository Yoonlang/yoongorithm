package org.example.tony.D3_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * 1 0 0
 * 1 0 0
 * 2 0 2
 *
 * 1 먼저 진행 -> 갯수 같으면 1 선공
 *
 * 일단 이길 수 있으면 무조건 이기는게 맞고
 * 상대방이 한 수 더 둬서 이길 수 있으면 그거 막는게 맞고
 *
 */

public class Main4 {
    public static void main(String[] args) throws IOException {
        int[][] map = new int[3][3];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = 0;
        int o = 0;
        for (int i = 0; i < 3; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(temp[j]);

                if (map[i][j] == 1) {
                    x++;
                } else if (map[i][j] == 2){
                    o++;
                }
            }
        }

        // false X, true O
        boolean turn = false;
        if (x != o) {
            turn = true;
        }

        String[] answers = new String[]{"L", "D", "W"};
        System.out.println(answers[play(map, turn)+1]);
    }

    static int play(int[][] map, boolean turn) {
        int player = turn ? 2 : 1;
        // return 1 내가 이겼다. 0 비겼다. -1 내가 졌다
        int result = 2;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[i][j] != 0) {
                    continue;
                }

                map[i][j] = player;
                if (check(map, i, j)) {
                    map[i][j] = 0;
                    return 1;
                }
                // 1 상대가 이겼다. 0 비겼다. -1 내가 이겼다
                result = Math.min(result, play(map, !turn));
                map[i][j] = 0;
            }
        }

        if (result == 2) {
            result = 0;
        }
        return result*-1;
    }

    static int[][] dirX = new int[][]{{0, 0}, {1, -1}, {1, -1}, {1, -1}};
    static int[][] dirY = new int[][]{{1, -1}, {0, 0}, {1, -1}, {-1, 1}};
    static boolean check(int[][] map, int x, int y) {
        int player = map[x][y];
        for (int i = 0; i < 4; i++) {
            int[] dX = dirX[i];
            int[] dY = dirY[i];

            int cnt = 0;
            for (int j = 0; j < 2; j++) {
                int nX = x + dX[j];
                int nY = y + dY[j];


                if (inRange(nX, nY) && (map[nX][nY] == player)) {
                    cnt++;

                    int nnX = nX + dX[j];
                    int nnY = nY + dY[j];

                    if (inRange(nnX, nnY) && (map[nnX][nnY] == player)) {
                        cnt++;
                    }
                }
            }

            if (cnt == 2) {
                return true;
            }
        }
        return false;
    }

    static boolean inRange(int x, int y) {
        if (x < 0 || x >= 3) return false;
        if (y < 0 || y >= 3) return false;
        return true;
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
