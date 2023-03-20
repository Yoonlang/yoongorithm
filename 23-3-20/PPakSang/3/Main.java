package org.example.tony.D3_20.수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 서로 다른 두 개의 소수의 합으로 나타낼 수 있는 경우
 * M 으로 나누어 떨어지지 않을때까지 나눈 수가 두 개의 소수의 곱인 경우, 이 때, 두 개의 소수가 같아도 된다.
 *
 * 9 9 7 6 5 1만 5천
 * 두 개의 소수의 합 98765
 * 두 개의 소수의 곱
 *
 * 10만 까지의 소수
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int k = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        boolean[] prime = new boolean[98766];
        for (int i = 2; i*i <= 98765; i++) {
            for (int j = i*i; j <= 98765; j += i) {
                prime[j] = true;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= 98765; i++) {
            if (!prime[i]) {
                primes.add(i);
            }
        }

        Set<Integer> nums = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            visited[i] = true;
            play(1, k, i, nums);
            visited[i] = false;
        }

        System.out.println(nums.size());

        Set<Integer> sum = new HashSet<>();
        Set<Integer> prod = new HashSet<>();

        for (int i = 0; i < primes.size(); i++) {
            for (int j = i; j < primes.size(); j++) {
                int p1 = primes.get(i);
                int p2 = primes.get(j);

                long res = (long) p1 *p2;
                if (res <= 98765) {
                    prod.add((int)res);
                }
                if (p1 != p2 && p1 + p2 <= 98765) {
                    sum.add(p1+p2);
                }
            }
        }


        int answer = 0;
        for (int num : nums) {
            if (!sum.contains(num)) {
                continue;
            }
            int last = num;
            while (last%m == 0) {
                last = last/m;
            }
            if (!prod.contains(last)) {
                continue;
            }
            answer++;
        }

        System.out.println(answer);
    }

    static boolean[] visited = new boolean[10];
    static void play(int cur, int max, int prev, Set<Integer> nums) {
        if (cur == max) {
            nums.add(prev);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            play(cur+1, max, prev*10 + i, nums);
            visited[i] = false;
        }
    }
}
