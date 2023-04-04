package org.example.tony.D3_23.치즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 8 9
 * 0 0 0 0 0 0 0 0 0
 * 0 0 0 1 1 0 0 0 0
 * 0 0 0 1 1 0 1 1 0
 * 0 0 1 1 1 1 1 1 0
 * 0 0 1 1 1 1 1 0 0
 * 0 0 1 1 0 1 1 0 0
 * 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0
 *
 * 빈 공간 BFS 치즈 만나면 치즈 +1
 *
 * 10000
 *
 * 00
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                 map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        int result = 1;
        while (true) {
            RValue r = melt(map);
            if (!r.result) {
                break;
            }
            map = r.map;
            result++;
        }
        System.out.println(result);
    }

    static int N;
    static int M;
    static int[] dirX = new int[]{1, -1, 0, 0};
    static int[] dirY = new int[]{0, 0, 1, -1};
    static RValue melt(int[][] map) {
        boolean result = false;

        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(0, 0));

        while(q.size() > 0) {
            Position cur = q.poll();

            for (int k = 0; k < 4; k++) {
                int nX = cur.x + dirX[k];
                int nY = cur.y + dirY[k];

                if (inRange(nX, nY)) {
                    if (map[nX][nY] != 0) {
                        map[nX][nY]++;
                        continue;
                    }
                    if (visited[nX][nY]) {
                        continue;
                    }

                    visited[nX][nY] = true;
                    q.add(new Position(nX, nY));
                }
            }
        }

        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int v = map[i][j];
                if (v == 1 || v == 2) {
                    result = true;
                    newMap[i][j] = 1;
                }
            }
        }
        return new RValue(newMap, result);
    }

    static boolean inRange(int x, int y) {
        if (x < 0 || x >= N) return false;
        if (y < 0 || y >= M) return false;
        return true;
    }

    static class RValue {
        int[][] map;
        boolean result;

        public RValue(int[][] map, boolean result) {
            this.map = map;
            this.result = result;
        }
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
