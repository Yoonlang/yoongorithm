package org.example.tony.D3_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  소수나라의 화폐를 이용하여 N원을 정확히 만들 수 있는 방법의 가짓수
 *  구매하려고하는 물건의 값 N(2 ≤ N ≤ 40,000, N은 정수)이 주어진다.
 */

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] notPrime = new boolean[n+1];
        int[] dp = new int[n+1];

        for (int i = 2; i*i <= n; i++) {
            for (int j = i*i; j <= n; j += i) {
                notPrime[j] = true;
            }
        }

        dp[0] = 1;
        for (int money = 2; money <= n; money++) {
            if (notPrime[money]) continue;

            for (int i = money; i <= n; i++) {
                dp[i] = (dp[i] + dp[i-money])%123456789;
            }
        }

        System.out.println(dp[n]);
    }
}
