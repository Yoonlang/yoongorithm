/*
3
NYY
YNY
YYN

2
 */

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q1058 {
    static String[] map;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new String[n];
        for (int i = 0; i<n; i++) {
            map[i] = bf.readLine();
        }

        // bfs
        int maxValue = Integer.MIN_VALUE;
//        for (int i = 0; i<n; i++) {
//            maxValue = Math.max(maxValue, bfs(i));
//        }

        //플와
        int[][] dist = new int[n][n];

        for (int i = 0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i].charAt(j) == 'Y') {
                    dist[i][j] = 1;
                } else {
                    dist[i][j] = 1000000;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i<n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        for (int i = 0; i<n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= 2) {
                    count += 1;
                }
            }
            maxValue = Math.max(maxValue, count);
        }

        System.out.println(maxValue);
    }

   static int bfs(int x) {
        int result = 0;
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.add(new Node(x, 0));
        visited[x] = true;

        while(!q.isEmpty()) {
            Node node = q.poll();

            if (node.level >= 2) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (!visited[j] && map[node.node].charAt(j) == 'Y') {
                    result += 1;
                    visited[j] = true;
                    q.add(new Node(j,node.level + 1));
                }
            }
        }

        return result;
    }

    static class Node {
        int node;
        int level;

        public Node(int node, int level) {
            this.node = node;
            this.level = level;
        }
    }

}
