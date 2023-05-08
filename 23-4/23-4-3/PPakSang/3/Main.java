package org.example.tony.D4_03.MST게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * MST 게임은 그래프에서 간선을 하나씩 제거하면서 MST의 비용을 구하는 게임이다. MST의 비용이란 MST를 이루고 있는 가중치의 합을 의미한다. 각 턴의 점수는 해당 턴에서 찾은 MST의 비용이 된다.
 * 이 과정은 K턴에 걸쳐서 진행되며, 첫 턴에는 입력으로 주어진 그래프의 MST 비용을 구해야 한다.
 * 각 턴이 종료된 후에는 그 턴에서 구한 MST에서 가장 가중치가 작은 간선 하나를 제거한다.
 * 한 번 제거된 간선은 이후의 턴에서 사용할 수 없다.
 * 어떤 턴에서 MST를 만들 수 없다면, 그 턴의 점수는 0이다. 당연히 이후 모든 턴의 점수도 0점이다. 첫 턴에 MST를 만들 수 없는 경우도 있다.
 *
 * 500000
 *
 * 6 6 2
 * 1 2
 * 2 3
 * 1 3
 * 4 5
 * 5 6
 * 4 6
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        int K = Integer.parseInt(temp[2]);

        List<Edge> conn = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            temp = br.readLine().split(" ");
            int n1 = Integer.parseInt(temp[0]);
            int n2 = Integer.parseInt(temp[1]);

            conn.add(new Edge(n1, n2, i+1));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            int result = play(i, conn, N);
            if (result == 0) {
                while (i < K) {
                    sb.append(0);
                    sb.append(" ");
                    i++;
                }
                break;
            }
            sb.append(result);
            sb.append(" ");
        }
        System.out.println(sb);
    }

    static int play(int start, List<Edge> conn, int N) {
        int result = 0;
        int cnt = 0;

        int[] group = new int[N+1];
        for (int i = 0; i <= N; i++) {
            group[i] = i;
        }
        for (int i = start; i < conn.size(); i++) {
            Edge e = conn.get(i);
            int g1 = find(e.n1, group);
            int g2 = find(e.n2, group);

            if (g1 == g2) continue;
            union(g1, g2, group);
            cnt++;
            result += i+1;
        }

        if (cnt != N-1) return 0;
        return result;
    }

    static class Edge {
        int n1;
        int n2;
        int w;

        public Edge(int n1, int n2, int w) {
            this.n1 = n1;
            this.n2 = n2;
            this.w = w;
        }
    }

    static void union(int n1, int n2, int[] group) {
        int g1 = find(n1, group);
        int g2 = find(n2, group);

        group[g2] = g1;
    }

    static int find(int n1, int[] group) {
        if (group[n1] == n1) {
            return n1;
        }
        return group[n1] = find(group[n1], group);
    }
}
