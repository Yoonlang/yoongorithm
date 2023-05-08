/*
4 6 8
1 2
1 3
1 6
2 3
2 6
3 6
4 5
5 6

1
2
3
6
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2026 {

    static boolean[] visited;
    static LinkedList<Integer>[] edges;
    static int k;
    static int n;
    static int f;

    static int[] degree;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        edges = new LinkedList[n + 1];
        visited = new boolean[n + 1];
        degree = new int[n + 1];
        for (int i=0; i<n + 1; i++) {
            edges[i] = new LinkedList<>();
        }

        for (int i=0; i<f; i++) {
            st = new StringTokenizer(bf.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            edges[n1].add(n2);
            edges[n2].add(n1);
            degree[n1] += 1;
            degree[n2] += 1;
        }

        boolean done = false;
        for (int i = 1; i < n + 1; i++) {
            visited[i] = true;
            if (dfs(i, 1)) {
                done = true;
                break;
            }
            visited[i] = false;
        }

        if (!done) {
            System.out.println(-1);
        }



    }

    static boolean dfs(int cur, int count) {

        if (degree[cur] < k - 1) {
            return false;
        }

        if (count == k) {
            for (int i = 1; i< n + 1; i++) {
                if (visited[i]) {
                    System.out.println(i);
                }
            }
            return true;
        }

        for (int i = cur + 1; i< n + 1; i++) {
            if (!isFriend(i)) {
                continue;
            }

            visited[i] = true;
            if (dfs(i, count + 1)) {
                visited[i] = false;
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

    static boolean isFriend(int x) {
        for (int i = 0; i< n + 1; i++) {
            if (visited[i] && !edges[x].contains(i)) {
                return false;
            }
        }
        return true;
    }
}
