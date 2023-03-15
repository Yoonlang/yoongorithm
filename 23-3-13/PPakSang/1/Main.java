package org.example.tony.D3_13.칸토어집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 0 end
 *
 * 3/3 = 1
 * 0 1 2
 *
 * 9/3 = 3
 * 0 2
 * 3 5
 * 6 8
 *
 * left = 0 ~ 0 + div-1
 * middle = left+1 ~ left+1 + div-1
 * right = middle+1 ~ middle+1 + div-1
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }

            int num = Integer.parseInt(line);
            int nums = (int)Math.pow(3, num);

            play(0, nums-1, sb, false);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void play(int left, int right, StringBuilder sb, boolean blank) {
        if (blank) {
            for (int i = left; i <= right; i++) {
                sb.append(" ");
            }
            return;
        }
        if (right == left) {
            sb.append("-");
            return;
        }

        int div = (right-left+1)/3;
        int nLeft = left;
        int mid = left+div;
        int nRight = mid+div;
        play(nLeft, left+div-1, sb, false);
        play(mid, mid+div-1, sb, true);
        play(nRight, nRight+div-1, sb, false);
    }
}
