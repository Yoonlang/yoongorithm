package org.example.tony.D3_18.벼락치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 첫째 줄에는 이번 시험의 단원 개수 N(1 ≤ N ≤ 100)과 시험까지 공부 할 수 있는 총 시간 T(1 ≤ T ≤ 10000)가
 *
 * 1 3 7
 *
 * 1 3 7 1개쓸때
 * 1 2 3 4 6 7 8 10 14 2개쓸때
 *
 *  1 -> 2  / 3 -> 2
 *  1 -> 3
 *
 *  3 -> 2
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int T = Integer.parseInt(temp[1]);

        Map<Integer, Integer> possible = new HashMap<>();
        possible.put(0, 0);
        int answer = 0;
        for (int i = 0; i < N; i++) {
            temp = br.readLine().split(" ");
            int t = Integer.parseInt(temp[0]);
            int s = Integer.parseInt(temp[1]);

            Set <Integer> keys = new HashSet<>(possible.keySet());
            Map <Integer, Integer> prevPossible = new HashMap<>(possible);
            for (int time : keys) {
                if (time + t > T) {
                    continue;
                }

                int prevS = prevPossible.getOrDefault(time + t, 0);
                if (prevS < prevPossible.get(time) + s) {
                    possible.put(time + t, prevPossible.get(time) + s);
                    answer = Math.max(answer, possible.get(time + t));
                }
            }
        }

        System.out.println(answer);
    }
}
