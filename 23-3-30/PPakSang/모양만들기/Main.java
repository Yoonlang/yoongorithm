package org.example.tony.D3_30.모양만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 5 4
 * 1 1 0 0
 * 1 0 1 0
 * 1 0 1 0
 * 0 1 1 0
 * 1 0 0 1
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);

        boolean[][] map = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                if (Integer.parseInt(temp[j]) == 1) {
                    map[i][j] = true;
                }
            }
        }

        int group = 1;
        int[][] visited = new int[n][m];
        Map<Integer, Integer> gSize = new HashMap<>();
        gSize.put(0, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] != 0 || !map[i][j]) continue;
                int res = play(i, j, group, visited, map);
                gSize.put(group, res);
                group++;
            }
        }


        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!map[i][j]) {
                    int res = 1;
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int nX = i + dirX[k];
                        int nY = j + dirY[k];

                        if (inRange(nX, nY)) set.add(visited[nX][nY]);
                    }

                    for (int g : set) res += gSize.get(g);
                    answer = Math.max(answer, res);
                }
            }
        }

        System.out.println(answer);
        //4방 탐색 너비 합
    }

    static int n;
    static int m;

    static int[] dirX = new int[]{1, -1, 0, 0};
    static int[] dirY = new int[]{0, 0, 1, -1};
    static int play(int x, int y, int num, int[][] visited, boolean[][] map) {
        int result = 1;
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(x, y));
        visited[x][y] = num;

        while (q.size() > 0) {
            Position p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nX = p.x + dirX[i];
                int nY = p.y + dirY[i];

                if (inRange(nX, nY) && visited[nX][nY] == 0 && map[nX][nY]) {
                    visited[nX][nY] = num;
                    result++;
                    q.add(new Position(nX, nY));
                }
            }
        }
        return result;
    }

    static boolean inRange(int x, int y) {
        if (x < 0 || x >= n) return false;
        if (y < 0 || y >= m) return false;
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
