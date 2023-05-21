/*
4 4
####
#JF#
#..#
#..#

3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q4179 {
    static int n;
    static int m;
    static char[][] map;
    static boolean[][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int result = bfs();
        if (result == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result + 1);
        }
    }

    static int bfs() {

        Queue<Node> fq = new LinkedList<>();
        Queue<Node> jq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'J') {
                    if (isEnd(i, j)) {
                        return 0;
                    }
                    jq.add(new Node(i,j,0));
                    visited[i][j] = true;
                }
                if (map[i][j] == 'F') {
                    fq.add(new Node(i,j,0));
                }
            }
        }

        while(!jq.isEmpty()) {
            while(!fq.isEmpty() && jq.peek().depth == fq.peek().depth) {
                Node fn = fq.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = fn.y + dir[i][0];
                    int nx = fn.x + dir[i][1];
                    if(!isIn(ny,nx) || !canGo(ny, nx)) {
                        continue;
                    }
                    map[ny][nx] = 'F';
                    fq.add(new Node(ny, nx, fn.depth + 1));
                }
            }
            Node jn = jq.poll();
            for (int i = 0; i < 4; i++) {
                int ny = jn.y + dir[i][0];
                int nx = jn.x + dir[i][1];
                if(!canGo(ny, nx) || visited[ny][nx]) {
                    continue;
                }
                if (isEnd(ny, nx)) {
                    return jn.depth + 1;
                }
                visited[ny][nx] = true;
                jq.add(new Node(ny, nx, jn.depth + 1));
            }
        }
        return -1;
    }

    static boolean isIn(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }

    static boolean isEnd(int y, int x) {
        return y == 0 || y == n-1 || x == 0 || x == m-1;
    }
    static boolean canGo(int y, int x) {
        return map[y][x] != 'F' && map[y][x] != '#';
    }

    static class Node {
        int y,x,depth;

        public Node(int y, int x, int depth) {
            this.y = y;
            this.x = x;
            this.depth = depth;
        }
    }
}
