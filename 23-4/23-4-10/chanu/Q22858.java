/*
5 2
4 1 3 5 2
4 3 1 2 5

1 4 5 3 2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q22858 {
    public static <Hashmap> void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] d = new int[n+1];
        int[] p = new int[n+1];
        int[] s = new int[n+1];

        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i < n + 1; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i < n + 1; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            for (int j = 1; j < n + 1; j++) {
                s[d[j]] = p[j];
            }
            for (int j = 1; j < n + 1; j++) {
                p[j] = s[j];
            }
        }

        for (int j = 1; j < n + 1; j++) {
            System.out.print(p[j]);
            System.out.print(" ");
        }
        System.out.println();
    }
}
