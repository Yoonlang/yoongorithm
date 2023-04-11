package org.example.tony.D4_11.소수최소공배수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        boolean[] prime = new boolean[1000001];
        for (int i = 2; i*i <= 1000000; i++) {
            if (prime[i]) continue;

            for (int j = i*i; j <= 1000000; j+=i) {
                prime[j] = true;
            }
        }

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long answer = 1;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!prime[i] && !set.contains(i)) {
                set.add(i);
                answer *= i;
            }
        }
        if (answer == 1) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }
}
