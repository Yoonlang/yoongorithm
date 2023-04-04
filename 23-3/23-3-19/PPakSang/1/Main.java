package org.example.tony.D3_19.주몽;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Map<Integer, Integer> nums = new HashMap<>();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int num : arr) {
            nums.put(num, nums.getOrDefault(num, 0)+1);
        }

        int answer = 0;
        for (int num : arr) {
            if (m - num > 100000 || m - num < 0
                    || nums.get(num) == 0) {
                continue;
            }
            int n1 = nums.get(num);
            nums.put(num, nums.get(num)-1);
            int n2 = nums.getOrDefault(m - num, 0);

            answer += Math.min(n1, n2);
            nums.put(num, 0);
            nums.put(m - num, 0);
        }

        System.out.println(answer);
    }
}
