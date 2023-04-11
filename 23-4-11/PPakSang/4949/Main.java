package org.example.tony.D4_11.균형잡힌세상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line.equals(".")) break;
            Stack<Character> stack = new Stack<>();

            boolean possible = true;
            outer: for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                switch (c) {
                    case '(': {
                        stack.add(c);
                        break;
                    }
                    case ')': {
                        if (stack.isEmpty() || stack.pop() != '(') {
                            possible = false;
                            break outer;
                        }
                        break;
                    }
                    case '[': {
                        stack.add(c);
                        break;
                    }
                    case ']': {
                        if (stack.isEmpty() || stack.pop() != '[') {
                            possible = false;
                            break outer;
                        }
                        break;
                    }
                }
            }

            if (possible && stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
