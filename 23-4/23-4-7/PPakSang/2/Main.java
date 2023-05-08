package org.example.tony.D4_07.나무꾼이다솜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *  N과 나무를 자를 때 드는 비용 C와 나무 한 단위의 가격 W이
 *
 *  근데 나무 길이 20이고 자르는데 10억이면
 *  어차피 한번 자르는데 비용들고,
 * 3 1 10
 * 26
 * 103
 * 59
 *
 * 3 10 10
 * 26
 * 103
 * 59
 *
 * 13 13
 * 6 7 6 7
 * 3 3 3 4 3 3 3 4
 * 1 2 1 2 1 2 2 2 1 2 1 2 1 2 2 2
 *
 * 3 100 10
 * 26
 * 103
 * 59
 *
 *
 *
 * 1880
 *
 * 1680
 *
 *
 * 29
 * 10 10 9
 * 30
 * 10 10 10
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int C = Integer.parseInt(temp[1]);
        int W = Integer.parseInt(temp[2]);

        List<Integer> trees = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            trees.add(num);
        }

        long answer = 0;
        for (int i = 1; i <= 10000; i++) {
            long cost = 0;
            for (int num : trees) {
                // 같은 단위로 자르는 횟수
                long cnt = num / i;

                // 얻은 나무 갯수
                long profit = num / i;

                // 딱 맞춰서 자르면 한번 덜 잘라도 된다
                if (num%i == 0) cnt--;

                long res = (i*profit*W)-(cnt*C);
                if (res > 0) cost += res;
            }
            answer = Math.max(answer, cost);
        }

        System.out.println(answer);
    }
}
