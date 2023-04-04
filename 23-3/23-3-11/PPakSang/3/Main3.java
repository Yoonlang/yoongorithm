package org.example.tony.D3_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 연결되지 않은 두 뉴런을 연결하거나 이미 연결된 두 뉴런의 연결을 끊는다.
 *
 * 뉴런의 연결 정보가 주어졌을 때, 모든 뉴런을 하나의 트리 형태로 연결하기 위하여 필요한 최소 연산 횟수를 구하는 프로그램을 작성하시오.
 *
 * 1 2
 * 1 3
 *
 * 2 3 (이미 같은 그룹이면 끊어내기)
 *
 */

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        int[] group = new int[n+1];
        for (int i = 0; i <= n; i++) {
            group[i] = i;
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            temp = br.readLine().split(" ");
            int n1 = Integer.parseInt(temp[0]);
            int n2 = Integer.parseInt(temp[1]);

            int g1 = find(n1, group);
            int g2 = find(n2, group);

            if (g1 == g2) {
                answer++;
            } else {
                union(g1, g2, group);
            }
        }

        Set<Integer> groups = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            groups.add(find(i, group));
        }

        System.out.println(answer+groups.size()-1);
    }

    public static void union(int n1, int n2, int[] group) {
        int g1 = find(n1, group);
        int g2 = find(n2, group);

        if (g1 > g2) {
            group[n1] = n2;
        } else {
            group[n2] = n1;
        }
    }

    public static int find(int n, int[] group) {
        if (n == group[n]) {
            return n;
        }
        return group[n] = find(group[n], group);
    }
}
