package org.example.tony.D3_24.스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 *
 * 1 2 5 7
 *
 * 1 2 3 4 5 6 7 8
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cur = 0;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > cur) {
                while (num > cur) {
                    stack.push(++cur);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
                continue;
            }

            if (stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
                continue;
            }

            System.out.println("NO");
            return;
        }

        System.out.println(sb);
    }
}
