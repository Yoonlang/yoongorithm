package org.example.tony.D3_13.서강그라운드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 첫째 줄에는 지역의 개수 n (1 ≤ n ≤ 100)과 예은이의 수색범위 m (1 ≤ m ≤ 15), 길의 개수 r (1 ≤ r ≤ 100)이 주어진다.
 *
 * 둘째 줄에는 n개의 숫자가 차례대로  각 구역에 있는 아이템의 수 t (1 ≤ t ≤ 30)를 알려준다.
 *
 * 세 번째 줄부터 r+2번째 줄 까지 길 양 끝에 존재하는 지역의 번호 a, b, 그리고 길의 길이 l (1 ≤ l ≤ 15)가 주어진다.
 *
 * 각 노드에서 부터 갈 수 있는 최대 거리의 합
 *
 * 각 이동마다 이동 거리, 점수 합
 * 같은 공간에 왔는데
 * 1. 점수 합이 더 높다 -> 무조건 갱신
 * 2. 이동 거리가 더 남았다 -> 무조건 갱신
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");


        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        int r = Integer.parseInt(temp[2]);

        List<Edge>[] conn = new List[n+1];
        int[] score = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            conn[i] = new ArrayList<>();
        }

        temp = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(temp[i-1]);
        }

        for (int i = 0; i < r; i++) {
            temp = br.readLine().split(" ");
            int n1 = Integer.parseInt(temp[0]);
            int n2 = Integer.parseInt(temp[1]);
            int w = Integer.parseInt(temp[2]);

            conn[n1].add(new Edge(n2, w));
            conn[n2].add(new Edge(n1, w));
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, play(i, conn, score, m));
        }
        System.out.println(answer);
    }

    static int play(int start, List<Edge>[] conn, int[] scores, int r) {
        PriorityQueue<Position> pq = new PriorityQueue<>((p1, p2) -> p1.dist - p2.dist);
        int[] visited = new int[scores.length+1];
        Arrays.fill(visited, Integer.MAX_VALUE);

        pq.add(new Position(start, 0));
        visited[start] = 0;

        while (pq.size() > 0) {
            Position cur = pq.poll();
            if (visited[cur.n] < cur.dist) {
                continue;
            }

            for (Edge next : conn[cur.n]) {
                if (visited[next.n] == Integer.MAX_VALUE || cur.dist+next.w < visited[next.n]) {
                    visited[next.n] = cur.dist+next.w;
                    pq.add(new Position(next.n, visited[next.n]));
                }
            }
        }

        int result = 0;
        for (int i = 1; i < visited.length; i++) {
            if (visited[i] <= r) {
                result += scores[i];
            }
        }

        return result;
    }

    static class Edge {
        int n;
        int w;

        Edge(int n, int w) {
            this.n = n;
            this.w = w;
        }
    }

    static class Position {
        int n;
        int dist;

        public Position(int n, int dist) {
            this.n = n;
            this.dist = dist;
        }
    }
}
