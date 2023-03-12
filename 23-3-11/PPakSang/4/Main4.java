package org.example.tony.D3_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

/**
 * 다음 수 연산하고 진행
 * 다음 수 진행하고 연산
 */

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[(n+1)/2];
        char[] operators = new char[n/2];
        String line = br.readLine();
        for (int i = 0; i < n; i++) {
            char c = line.charAt(i);

            if (i%2 == 0) {
                nums[i/2] = c-'0';
            } else {
                operators[i/2] = c;
            }
        }
        System.out.println(play(nums[0], 1, n/2, nums, operators));
    }

    static int play(int prev, int cur, int max, int[] nums, char[] operators) {
        if (cur == max) {
            return calc(prev, nums[cur], operators[cur-1]);
        }
        if (cur > max) {
            return prev;
        }
        int result1 = 0;
        int result2 = 0;
        switch (operators[cur-1]) {
            case '+': {
                result1 = play(prev + nums[cur],cur+1, max, nums, operators);
                result2 = play(prev + calc(nums[cur], nums[cur+1], operators[cur]), cur+2, max, nums, operators);
                break;
            }
            case '-': {
                result1 = play(prev - nums[cur],cur+1, max, nums, operators);
                result2 = play(prev - calc(nums[cur], nums[cur+1], operators[cur]), cur+2, max, nums, operators);
                break;
            }
            case '*': {
                result1 = play(prev * nums[cur], cur+1, max, nums, operators);
                result2 =  play(prev * calc(nums[cur], nums[cur+1], operators[cur]), cur+2, max, nums, operators);
                break;
            }
        }
        return Math.max(result1, result2);
    }

    static int calc(int num1, int num2, char operator) {
        switch (operator) {
            case '+': {
                return num1 + num2;
            }
            case '-': {
                return num1 - num2;
            }
            case '*': {
                return num1 * num2;
            }
        }
        throw new RuntimeException("");
    }
}
