package org.example.tony.D3_18.영우는사기꾼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 4 4 5
 * 1 2
 * 1 3
 * 2 4
 * 3 4
 * 1 1
 * 1 2
 * 1 3
 * 2 1
 * 1 4
 *
 * 1->2
 * 1->3
 * 2->4
 * 3->4
 *
 * 1 건설
 * 2 파괴
 *
 * 한 건물 건설 -> 의존 관계 있는 건물이 있는지 확인
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        int K = Integer.parseInt(temp[2]);

        List<Integer>[] conn = new List[N+1];
        List<Integer>[] dependency = new List[N+1];
        for (int i = 0; i <= N; i++) {
            conn[i] = new ArrayList<>();
            dependency[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            temp = br.readLine().split(" ");

            int n1 = Integer.parseInt(temp[0]);
            int n2 = Integer.parseInt(temp[1]);

            conn[n2].add(n1);
            dependency[n1].add(n2);
        }

        Set<Integer> possible = new HashSet<>();
        Map<Integer, Integer> build = new HashMap<>();
        for (int i = 0; i < K; i++) {
            temp = br.readLine().split(" ");

            int operator = Integer.parseInt(temp[0]);
            int num = Integer.parseInt(temp[1]);

            if (operator == 1) {
                if (!possible.contains(num)) {
                    for (int node : conn[num]) {
                        if (build.getOrDefault(node, 0) == 0) {
                            System.out.println("Lier!");
                            return;
                        }
                    }
                }
                build.put(num, build.getOrDefault(num, 0)+1);
                possible.add(num);
            } else {
                if (build.getOrDefault(num, 0) == 0) {
                    System.out.println("Lier!");
                    return;
                }
                build.put(num, build.get(num)-1);
                if (build.get(num) == 0) {
                    for (int node : dependency[num]) {
                        possible.remove(node);
                    }
                }
            }
        }
        System.out.println("King-God-Emperor");
    }
}
