package org.example.tony.D3_14.음식물피하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 뭉치는 쓰레기 끼리 다 모으기
 *
 * 3 4 5
 * 3 2
 * 2 2
 * 3 1
 * 2 3
 * 1 1
 */

public class Main {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        int K = Integer.parseInt(temp[2]);

        boolean[][] map = new boolean[N+1][M+1];

        for (int i = 0; i < K; i++) {
            temp = br.readLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);

            map[x][y] = true;
        }

        int answer = 0;
        boolean[][] visited = new boolean[N+1][M+1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (visited[i][j] || !map[i][j]) {
                    continue;
                }

                answer = Math.max(answer, bfs(i, j, visited, map));
            }
        }

        System.out.println(answer);
    }

    static int[] dirX = new int[]{1, -1, 0, 0};
    static int[] dirY = new int[]{0, 0, 1, -1};
    static int bfs(int x, int y, boolean[][] visited, boolean[][] map) {
        Queue<Position> q = new LinkedList<>();


        int result = 1;
        q.add(new Position(x, y));
        visited[x][y] = true;
        while(q.size()>0) {
            Position p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nX = p.x + dirX[i];
                int nY = p.y + dirY[i];

                if (!inRange(nX, nY) || !map[nX][nY] || visited[nX][nY]) {
                    continue;
                }

                visited[nX][nY] = true;
                result++;
                q.add(new Position(nX, nY));
            }
        }

        return result;
    }

    static boolean inRange(int x, int y) {
        if (x < 0 || x > N) return false;
        if (y < 0 || y > M) return false;
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
