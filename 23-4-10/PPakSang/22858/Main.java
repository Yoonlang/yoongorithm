package org.example.tony.D4_10.원상복구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 첫번째 줄에는 카드의 개수
 * $N$과 카드를 섞은 횟수인
 * $K$가 공백으로 구분되어 주어진다.
 *
 * 두번째 줄에는
 * $K$번 카드를 섞은 후 카드의 배치를 의미하는
 * $S_i$가 공백으로 구분되어 총
 * $N$개 주어진다.
 *
 * 세번째 줄에는 총 N개의
 * $D_i$이 공백으로 구분되어 주어진다.
 *
 * 4 3 1 2 5
 *
 *
 *
 * 1 2 3 4 5
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int K = Integer.parseInt(temp[1]);

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] map = new int[N];
        for (int i = 0; i < N; i++) {
            map[i] = i;
        }
        int[] order = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)-1).toArray();
        for (int i = 0; i < K; i++) {
            int[] nOrder = new int[N];
            for (int j = 0; j < N; j++) {
                nOrder[order[j]] = map[j];
            }
            map = nOrder;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(nums[map[i]] + " ");
        }
    }
}
