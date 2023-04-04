package org.example.tony.D3_16.징검다리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 첫 징검다리는 점프해서 아무 것이나 밟을 수 있다. 이 점프가 첫 점프이다.
 * 두 번째 점프부터는 이전에 점프한 거리보다 1 이상 더 긴 거리를 뛰어야만 한다.
 * N번 징검다리는 반드시 밟아야 한다.
 * N번 징검다리를 밟은 후 강 건너로 이동할 땐 점프를 하지 않으므로 위의 규칙이 적용되지 않는다.
 *
 * (a + b) * (idxB - idxA + 1) / 2
 * 1 2 3 4 5 6 7 8
 * 1 3(1~2) 6(1~3) 10(1~4) 15 (d[i] - d[j]) -> j~(i+1) 합
 * 2 5(2~3) 9 14
 * 3 7 12 18
 *
 * 1 100
 *
 * 1 100
 *
 * 4
 * 1
 * 2
 * 100 50
 * 1000000
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            long n = Long.parseLong(br.readLine());

            long left = 1;
            long right = (long)Math.sqrt(2*n);

            long result = 1;
            while (left <= right) {
                long mid = (left + right) / 2;
                long a = (1+mid)*mid/2;
                if (a <= n) {
                    result = Math.max(result, mid);
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
            System.out.println(result);
        }
    }
}
