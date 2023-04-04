import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*

8
1 2
1 3
1 4
2 5
2 6
4 7
4 8

3
 */
public class Q4_2533 {

    static boolean[] visited;
    static List<Integer>[] edges;
    static int[][] dp;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        edges = new LinkedList[n+1];

        for (int i = 0; i < n+1; i++) {
            edges[i] = new LinkedList<>();
        }


        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        visited = new boolean[n+1];
        dp = new int[n+1][2];

        find(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    public static void find(int x) {
        visited[x] = true;
        dp[x][1] = 1;
        for (int child : edges[x]) {
            if(!visited[child]){
                find(child);
                dp[x][1] += Math.min(dp[child][0], dp[child][1]);
                dp[x][0] += dp[child][1];
            }
        }
    }
    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
