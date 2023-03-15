package org.example.tony.D3_13.원숭이스포츠;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 100
 * 50 50
 * 25 25
 * 12 13
 * 6 6
 * 3 3
 * 1 2
 * 1 1
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int left = 0;
        int right = 0;
        Queue<Print> q = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        if (N%2 == 0) {
            left = N/2;
            right = N/2;
        } else {
            left = N/2+1;
            right = N/2;
        }
        if (q.size() == 0) {
            q.add(new Print(left, false));
            q.add(new Print(right, true));
        }

        for (int t = 0; t < 7; t++) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Print p = q.poll();
                int pNums = p.nums;

                for (int j = 0; j < pNums; j++) {
                    if (p.team) {
                        sb.append("A");
                    } else {
                        sb.append("B");
                    }
                }

                if (p.nums%2 == 0) {
                    left = p.nums/2;
                    right = p.nums/2;
                } else {
                    left = p.nums/2+1;
                    right = p.nums/2;
                }
                q.add(new Print(left, !p.team));
                q.add(new Print(right, p.team));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static class Print {
        int nums;
        boolean team;

        Print(int nums, boolean team) {
            this.nums = nums;
            this.team = team;
        }
    }
}
