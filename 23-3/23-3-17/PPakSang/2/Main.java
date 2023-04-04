package org.example.tony.D3_17.선수과목;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 6 4
 * 1 2
 * 1 3
 * 2 5
 * 4 5
 *
 * 1 (2, 3)
 * 2 (5)
 * 4 5
 *
 * 1 2 2 1 3 1
 *
 * 누군가에게 선택 된 애들은 일단 배제
 * 각 노드 간 탐색 하면서 몇 번째에
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int e = Integer.parseInt(temp[1]);

        List<Integer>[] conn = new List[n+1];
        for (int i = 0; i < n+1; i++) {
            conn[i] = new ArrayList<>();
        }

        boolean[] visited = new boolean[n+1];
        for (int i = 0; i < e; i++) {
            temp = br.readLine().split(" ");
            int n1 = Integer.parseInt(temp[0]);
            int n2 = Integer.parseInt(temp[1]);

            conn[n2].add(n1);
            visited[n1] = true;
        }

        dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                play(i, conn);
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(dp[i]+" ");
        }
    }

    static int[] dp;
    static int play(int start, List<Integer>[] conn) {
        if (dp[start] != 0) {
            return dp[start]+1;
        }

        int result = 1;
        for (int i : conn[start]) {
            int root = play(i, conn);
            result = Math.max(result, root);
        }
        dp[start] = result;
        return result+1;
    }
}
