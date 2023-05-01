import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
6 6 16
0 0 0 0 1 1
0 0 0 0 0 2
1 1 1 0 1 0
0 0 0 0 0 0
0 1 1 1 1 1
0 0 0 0 0 0

10
 */
public class Q17836 {
    static int n;
    static int m;
    static int t;
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] newVisited;
    static int[][] dir = {{-1,0}, {1,0}, {0,1}, {0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        newVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs();

        if (result > t || result == -1) {
            System.out.println("Fail");
        } else {
            System.out.println(result);
        }
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();

        boolean flag = isKnife(0,0);

        q.add(new Node(0,0,0, flag));
        checkIn(0, 0, flag);

        while(!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = node.y + dir[i][0];
                int nx = node.x + dir[i][1];
                if (!canGo(ny,nx)) {
                    continue;
                }
                boolean nFlag = isKnife(ny,nx) || node.flag;
                if (canVisit(ny,nx,nFlag)) {
                    if (ny == n-1 && nx == m-1) {
                        return node.t + 1;
                    }
                    checkIn(ny,nx, nFlag);
                    q.add(new Node(ny,nx,node.t+1, nFlag));
                }
            }
        }
        return -1;
    }

    private static boolean canVisit(int y, int x, boolean nFlag) {
        if (nFlag) {
            return !newVisited[y][x];
        }
        return (!visited[y][x]) && (map[y][x] != 1);
    }

    static boolean canGo(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }

    static void checkIn(int y, int x, boolean flag) {
        if (flag) {
            newVisited[y][x] = true;
        } else {
            visited[y][x] = true;
        }
    }

    static boolean isKnife(int y, int x) {
        return map[y][x] == 2;
    }


    static class Node {
        int y,x,t;
        boolean flag;

        public Node(int y, int x, int t, boolean flag) {
            this.y = y;
            this.x = x;
            this.t = t;
            this.flag = flag;
        }
    }
}
