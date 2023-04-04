/*
3 4 8
....
.T..
....

4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2_1189 {

    static char[][] map;
    static boolean[][] visited;
    static int[][] dir = {{1,0}, {-1, 0}, {0,-1}, {0,1}};

    static int count;
    static int K;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] =  br.readLine().toCharArray();
        }

        visited[N-1][0] = true;
        dfs(N-1, 0, 1);

        System.out.println(count);

    }

    public static void dfs(int y, int x, int level) {
        //도착했으면? 레벨 같으면?
        if (isArrived(y,x)) {
            if (level == K) {
                count += 1;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nexty = y + dir[i][0];
            int nextx = x + dir[i][1];

            if (canGo(nexty, nextx) && !visited[nexty][nextx]) {
                visited[nexty][nextx] = true;
                dfs(nexty, nextx, level + 1);
                visited[nexty][nextx] = false;
            }
        }
    }

    public static boolean isArrived(int y, int x) {
        return y == 0 && x == M - 1;
    }

    public static boolean canGo(int y, int x) {

        if (x < 0 || x >= M || y < 0 || y >= N) {
            return false;
        }

        return map[y][x] != 'T';
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }


}
