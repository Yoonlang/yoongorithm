/*
5 5
1 3
1 4
4 5
4 3
3 2

3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q3 {

    static LinkedList<Integer>[] edge;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());

        edge = new LinkedList[n + 1];

        for (int i = 0; i < n+1; i++) {
            edge[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int n1 = stoi(st.nextToken());
            int n2 = stoi(st.nextToken());

            edge[n1].add(n2);
            edge[n2].add(n1);
        }

        int minCount = Integer.MAX_VALUE;
        int minNum = 0;
        for (int i = 1; i < n+1; i++) {
            boolean[] visited = new boolean[n + 1];
            int count = bfs(i, visited);
            if (minCount > count) {
                minCount = count;
                minNum = i;
            }
        }

        System.out.println(minNum);
    }

    private static int bfs(int n, boolean[] visited) {
        Queue<Node> q = new LinkedList<>();
        int total = 0;
        visited[n] = false;
        q.add(new Node(n, 0));

        while(!q.isEmpty()) {
            Node node = q.poll();
            for(Integer next : edge[node.index]) {
                if (!visited[next]) {
                    total += node.level + 1;
                    q.add(new Node(next, node.level + 1));
                    visited[next] = true;
                }
            }
        }
        return total;
    }

    private static int dfs(boolean[] visited, int n, int level) {
        int total = level;
        for (Integer next: edge[n]) {
            if (!visited[next]) {
                visited[next] = true;
                total += dfs(visited, next, level + 1);
            }
        }

        return total;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }

    private static class Node {
        int index;
        int level;

        public Node(int index, int level) {
            this.index = index;
            this.level = level;
        }
    }
}
