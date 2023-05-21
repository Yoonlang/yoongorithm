/*
3 3
32 83 75
24 96 56
71 88 12

632
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q18430 {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int result = 0;
    static int[][][] blocks = {{},
            {{0,-1},{0,0},{1,0}},
            {{-1,0},{0,0},{0,-1}},
            {{0,0}, {-1,0},{1,0}},
            {{0,0},{1,0},{0,1}}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0,0);
        System.out.println(result);
    }

    public static void dfs(int y, int x, int w) {

        if (y == n) {
            result = Math.max(result, w);
            System.out.println(w);
            return;
        }

        for (int i = y; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == y && j < x) {
                    continue;
                }

                for (int k = 0; k < 5; k++) {
                    if (!canPick(i,j,k)) {
                        continue;
                    }

                    int nw = w;
                    System.out.printf("%d %d %d %d: %b\n",i,j,k,w,canPick(i,j,k));
                    System.out.println(Arrays.deepToString(visited));
                    for (int[] block: blocks[k]) {
                        int ny = i + block[0];
                        int nx = j + block[1];
                        visited[ny][nx] = true;
                        nw += map[ny][nx];
                    }
                    if (k != 0) {
                        nw += map[i][j];
                    }

                    if (x == m-1) {
                        dfs(i+1, 0, nw);
                    } else {
                        dfs(i, j+1, nw);
                    }

                    for (int[] block: blocks[k]) {
                        int ny = i + block[0];
                        int nx = j + block[1];
                        visited[ny][nx] = false;
                    }
                }
            }
        }
    }

    public static boolean canPick(int y, int x, int number) {
        for (int i = 0; i < 5; i++) {
            for (int[] block: blocks[number]) {
                int ny = y + block[0];
                int nx = x + block[1];

                if (0 > ny || ny >= n || 0 > nx || nx >= m) {
                    return false;
                }
                if (visited[ny][nx]) {
                    return false;
                }
            }
        }
        return true;
    }


}
