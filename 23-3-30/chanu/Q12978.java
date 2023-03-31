/*
5
4 5
4 2
2 3
1 2

2

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Q12978 {
    static List<Integer>[] edges;
    static boolean[] visited;
    static final int YES = 1;
    static final int NO = 0;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        edges = new LinkedList[n+1];

        for (int i=0; i<n+1; i++) {
            edges[i] = new LinkedList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = stoi(st.nextToken());
            int n2 = stoi(st.nextToken());
            edges[n1].add(n2);
            edges[n2].add(n1);
        }

        visited = new boolean[n+1];
        dp = new int[n+1][2];

        findNum(1);
        System.out.println(Math.min(dp[1][YES], dp[1][NO]));
    }

    public static void findNum(int x) {
        visited[x] = true;
        dp[x][YES] = 1;

        for (Integer child : edges[x]) {
            if (!visited[child]) {
                findNum(child);
                dp[x][NO] += dp[child][YES];
                dp[x][YES] += Math.min(dp[child][NO], dp[child][YES]);
            }
        }
    }




    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

}
