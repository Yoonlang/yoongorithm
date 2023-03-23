package org.example.tony.D3_22.퍼레이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 엣지 방문 기록을 세자
 * 모든 엣지 돌면서 노드 다 방문 가능하면 YES
 *
 * union find?
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int V = Integer.parseInt(temp[0]);
        int E = Integer.parseInt(temp[1]);

        int[] group = new int[V+1];
        for (int i = 1; i <= V; i++) {
            group[i] = i;
        }

        List<Integer>[] conn = new List[V+1];

        for (int i = 1; i <= V; i++) {
            conn[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            temp = br.readLine().split(" ");
            int n1 = Integer.parseInt(temp[0]);
            int n2 = Integer.parseInt(temp[1]);

            conn[n1].add(n2);
            conn[n2].add(n1);

            union(n1, n2, group);
        }

        int query = find(1, group);
        for (int i = 1; i <= V; i++) {
            if (find(i, group) != query) {
                System.out.println("NO");
                return;
            }
        }

        int cnt = 0;
        for (int i = 1; i <= V; i++) {
            if (conn[i].size() % 2 == 1) {
                cnt++;
            }
        }

        if (cnt == 0 || cnt == 2) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }

    static int find(int n, int[] group) {
        if (group[n] == n) {
            return n;
        }
        return group[n] = find(group[n], group);
    }

    static void union(int n1, int n2, int[] group) {
        int g1 = find(n1, group);
        int g2 = find(n2, group);

        group[g1] = g2;
    }
}
