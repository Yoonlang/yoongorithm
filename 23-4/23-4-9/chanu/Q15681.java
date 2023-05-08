/*
9 5 9
1 3
4 3
5 4
5 6
6 7
2 3
9 6
6 8
1
2
3
4
5
6
7
8
9


1
2
3
4
5
6
7
8
9
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Q15681 {

    static List<Integer>[] edges;
    static int[] dp;
    static int N;
    static int R;
    static int Q;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        edges = new LinkedList[N+1];
        for (int i = 0; i < N + 1; i++) {
            edges[i] = new LinkedList<>();
        }
        visited = new boolean[N + 1];
        dp = new int[N+1];
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            edges[n1].add(n2);
            edges[n2].add(n1);
        }
        visited[R] = true;
        dfs(R);

        for (int i = 0; i < Q; i++) {
            System.out.println(dp[Integer.parseInt(bf.readLine())]);
        }
    }

    static void dfs(int x) {
        dp[x] = 1;

        for (Integer e : edges[x]) {
            if (!visited[e]) {
                visited[e] = true;
                dfs(e);
                dp[x] += dp[e];
            }
        }
    }
}
