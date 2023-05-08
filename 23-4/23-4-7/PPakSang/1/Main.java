package org.example.tony.D4_07.스위치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 4 5
 * 3 1 3 5
 * 1 2
 * 3 3 4 5
 * 1 1
 *
 * 모든 스위치 누르기 -> 램프 중복해서 몇번 켜진지 체크
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);

        List<Integer>[] switches = new List[N];
        for (int i = 0; i < N; i++) {
            switches[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            temp = br.readLine().split(" ");
            int num = Integer.parseInt(temp[0]);


            for (int j = 1; j <= num; j++) {
                int lamp = Integer.parseInt(temp[j]);
                switches[i].add(lamp);
            }
        }

        Map<Integer, Integer> lamps = new HashMap<>();
        for (List<Integer> s : switches) {
            for (int num : s) {
                lamps.put(num, lamps.getOrDefault(num, 0)+1);
            }
        }

        for (List<Integer> s : switches) {
            boolean possible = true;
            for (int num : s) {
                if (lamps.get(num)-1 <= 0) {
                    possible = false;
                }
            }

            if (possible) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }
}
