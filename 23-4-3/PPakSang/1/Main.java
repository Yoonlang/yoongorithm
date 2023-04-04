package org.example.tony.D4_03.에라토스테네스체;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 7 3
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int K = Integer.parseInt(temp[1]);

        boolean[] primes =  new boolean[N+1];

        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            if (primes[i]) continue;
            cnt++;
            if (cnt == K) {
                System.out.println(i);
                return;
            }
            for (int j = i*i; j <= N; j += i) {
                if(!primes[j]) {
                    primes[j] = true;
                    cnt++;
                }
                if (cnt == K) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}
