package org.example.tony.D3_15.연산자끼워넣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/**
 * 2
 * 5 6
 * 0 0 1 0
 */

public class Main {
    static int maxV = Integer.MIN_VALUE;
    static int minV = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] operators = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        operate(0, N-1, operators, nums, new int[N-1]);
        System.out.println(maxV);
        System.out.println(minV);
    }

    static void operate(int cur, int max, int[] operators, int[] num, int[] selected) {
        if (cur == max) {
            Stack<Integer> nums = new Stack<>();
            Stack<Integer> ops = new Stack<>();
            nums.add(num[0]);
            for (int i = 0; i < max; i++) {
                switch (selected[i]) {
                    case 0:
                        nums.add(num[i+1]);
                        ops.add(0);
                        break;
                    case 1: {
                        nums.add(-num[i+1]);
                        ops.add(0);
                        break;
                    }
                    case 2: {
                        int prev = nums.pop();
                        nums.push(prev*num[i+1]);
                        break;
                    }
                    case 3: {
                        int prev = nums.pop();
                        nums.push(prev/num[i+1]);
                        break;
                    }
                }
            }

            int value = 0;
            int size = ops.size();
            for (int i = 0; i < size; i++) {
                int op = ops.pop();
                int num1 = nums.pop();
                int num2 = nums.pop();
                if (op == 0) {
                    nums.push(num1+num2);
                } else {
                    nums.push(num1-num2);
                }
            }
            value = nums.pop();
            maxV = Math.max(maxV, value);
            minV = Math.min(minV, value);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] == 0) {
                continue;
            }
            selected[cur] = i;
            operators[i]--;
            operate(cur+1, max, operators, num, selected);
            operators[i]++;
        }
    }
}
