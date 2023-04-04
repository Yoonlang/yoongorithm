package org.example.tony.D3_18.금민수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 1000000 5000000 64
 *
 * a 자리 ~ b 자리
 *
 * 4/7 4/7 4/7 4/7
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int low = Integer.parseInt(temp[0]);
        int high = Integer.parseInt(temp[1]);

        Set<Integer> GMS = new HashSet<>();
        createGMS(0, 9, 0, GMS);

        int answer = 0;
        for (int num : GMS) {
            if (num >= low && num <= high) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static void createGMS(int cur, int max, int prev, Set<Integer> GMS) {
        GMS.add(prev);
        if (cur == max) {
            return;
        }

        createGMS(cur+1, max, prev*10 + 4, GMS);
        createGMS(cur+1, max, prev*10 + 7, GMS);
    }

}
