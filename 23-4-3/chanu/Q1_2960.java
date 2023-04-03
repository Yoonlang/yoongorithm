/*
7 3

6
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1_2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int count = 0;
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        for (int i = 2; i < n + 1; i++) {
            if (prime[i]) {
                count += 1;
                if (count == k) {
                    System.out.println(i);
                    return;
                }
                for (int j = i; j * i < n + 1; j++) {

                    if (prime[i * j]) {
                        prime[i * j] = false;
                        count +=1;
                    }

                    if (count == k) {
                        System.out.println(i * j);
                        return;
                    }
                }
            }

        }
    }
}
