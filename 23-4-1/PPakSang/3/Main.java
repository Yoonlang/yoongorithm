package org.example.tony.D4_01.제곱수의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 300
 * 90000
 */


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i*i <= N; i++) {
            nums.add(i);
        }

        Set<Integer> possible = new HashSet<>();
        possible.add(0);

        int answer = 0;
        while (true) {
            answer++;
            Set<Integer> next = new HashSet<>();
            for (int p : possible) {
                for (int num : nums) {
                    int t = p + num*num;
                    if (t > N) break;
                    if (t == N) {
                        System.out.println(answer);
                        return;
                    }
                    next.add(t);
                }
            }
            possible = next;
        }
    }
}
