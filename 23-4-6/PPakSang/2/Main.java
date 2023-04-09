package org.example.tony.D4_06.뱀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 6
 * 3
 * 3 4
 * 2 5
 * 5 3
 * 3
 * 3 D
 * 15 L
 * 17 D
 *
 * 뱀의 꼬리 끝 정보가 있어야하고, 몸통 길이도 다 있어야하네 Queue?
 */

public class Main {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < K; i++) {
            String[] temp = br.readLine().split(" ");
            int r = Integer.parseInt(temp[0]) - 1;
            int c = Integer.parseInt(temp[1]) - 1;

            map[r][c] = 1;
        }

        Map<Integer, Character> actions = new HashMap<>();
        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            String[] temp = br.readLine().split(" ");
            int T = Integer.parseInt(temp[0]);
            char dir = temp[1].charAt(0);
            actions.put(T, dir);
        }

        int time = 0;
        Head head = new Head(new Position(0, 0), 2);
        while (true) {
            time++;
            Position cur = head.p;

            int nX = cur.r + dirX[head.dir];
            int nY = cur.c + dirY[head.dir];

            if (!inRange(nX, nY) || map[nX][nY] == -1) {
                System.out.println(time);
                return;
            }

            Position next = new Position(nX, nY);
            head.check(next);

            if (actions.containsKey(time)) {
                if (actions.get(time) == 'L') {
                    head.dir = dirMap[head.dir+1];
                } else if (actions.get(time) == 'D') {
                    head.dir = dirMap[head.dir-1];
                }
            }
        }
    }

    static int N;
    static boolean inRange(int x, int y) {
        if (x < 0 || x >= N) return false;
        if (y < 0 || y >= N) return false;
        return true;
    }

    static int[] dirMap = new int[]{4, 1, 2, 3, 4, 1};
    // 북 동 남 서
    static int[] dirX = new int[]{-1, 1, 0, -1, 0};
    static int[] dirY = new int[]{-1, 0, 1, 0, -1};
    static class Head {
        Position p;
        int dir;
        Queue<Position> body;

        Head(Position p, int dir) {
            body = new LinkedList<>();
            body.add(p);
            this.p = p;
            this.dir = dir;
        }

        void check(Position p) {
            int o = map[p.r][p.c];
            if (o == 0) {
                move(p);
            } else if (o == 1) {
                large(p);
            }
        }

        void large(Position p) {
            body.add(p);
            this.p = p;
            map[p.r][p.c] = -1;
        }

        void move(Position p) {
            large(p);
            removeTail();
        }
        void removeTail() {
            Position p = body.remove();
            map[p.r][p.c] = 0;
        }
    }

    static class Position {
        int r;
        int c;

        Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
