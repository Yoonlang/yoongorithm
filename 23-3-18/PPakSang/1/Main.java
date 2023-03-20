package org.example.tony.D3_18.수찾기;

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
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        br.readLine();
        int[] check = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder();
        for (int num : check) {
            if (set.contains(num)) {
                sb.append("1\n");
                continue;
            }
            sb.append("0\n");
        }

        System.out.println(sb);
    }
}
