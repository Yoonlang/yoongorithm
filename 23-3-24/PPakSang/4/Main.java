package org.example.tony.D3_24.양팔저울;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2
 * 1 4
 * 2
 * 3 2
 *
 * 구슬 N 개로
 *
 * 1 2 3 4 5
 *
 * 한 쪽에서 nCk 를 했을 때 무게 K 반대쪽에서 nC0 ~ nCt 무게 T (단 K > T, K-T 는 측정 가능한 추의 무게)
 *
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] prefixSum = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        Set<Integer> possible = new HashSet<>();
        possible.add(0);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            Set<Integer> next = new HashSet<>(possible);
            for (int sum : possible) {
                if (!(sum + num > 40000)) {
                    next.add(sum + num);
                }

                int exp = sum-num + prefixSum[nums.length-1] - prefixSum[i];
                if (exp > 0 && exp <= 40000) {
                    next.add(sum - num);
                }
            }
            possible = next;
        }

        int m = Integer.parseInt(br.readLine());
        int[] weights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringBuilder sb = new StringBuilder();
         for (int weight : weights) {
             if (possible.contains(weight)) {
                 sb.append("Y ");
                 continue;
             }
             sb.append("N ");
         }
        System.out.println(sb);
    }
}
