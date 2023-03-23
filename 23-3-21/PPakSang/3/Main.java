package org.example.tony.D3_21.행성연결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 3
 * 0 2 3
 * 2 0 1
 * 3 1 0
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Edge>[] conn = new List[n];
        for (int i = 0; i < n; i++) {
            conn[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                conn[i].add(new Edge(j, Integer.parseInt(temp[j])));
            }
        }

        System.out.println(prim(0, conn));
    }

    static long prim(int start, List<Edge>[] conn) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((n1, n2) -> n1.w - n2.w);
        boolean[] visited = new boolean[conn.length];
        visited[start] = true;

        for (Edge e : conn[start]) {
            pq.add(e);
        }

        long answer = 0;
        while(pq.size() > 0) {
            Edge cur = pq.poll();
            if (visited[cur.n]) {
                continue;
            }
            visited[cur.n] = true;
            answer += cur.w;

            for (Edge e : conn[cur.n]) {
                if (visited[e.n]) {
                    continue;
                }
                pq.add(e);
            }
        }

        return answer;
    }

    static class Edge {
        int n;
        int w;

        public Edge(int n, int w) {
            this.n = n;
            this.w = w;
        }
    }
}
