package org.example.tony.D4_09.팰린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * qwerty
 * trewq
 *
 * n 번째 까지는 만족하고 나머지 팰린드롬인지
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        for (int i = 0; i < line.length(); i++) {
            int left = i;
            int right = line.length()-1;

            boolean flag = true;
            while (left < right) {
                char c1 = line.charAt(left);
                char c2 = line.charAt(right);

                if (c1 == c2) {
                    left++;
                    right--;
                    continue;
                }

                flag = false;
                break;
            }

            if (flag) {
                System.out.println(line.length()+i);
                return;
            }
        }
    }
}
