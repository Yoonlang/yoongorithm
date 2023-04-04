/*
6
-45 22 42 -16
-41 -27 56 30
-36 53 -37 77
-36 30 -75 -46
26 -38 -10 62
-32 -54 -6 45

5
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(bf.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            a[i] = stoi(st.nextToken());
            b[i] = stoi(st.nextToken());
            c[i] = stoi(st.nextToken());
            d[i] = stoi(st.nextToken());
        }

        Map<Integer, Integer> answer = new HashMap<>((int)Math.pow(2,26));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Integer count = answer.get(a[i] + b[j]);
                if (count == null) {
                    count = 0;
                }
                answer.put(a[i] + b[j], count + 1);
            }
        }

        long total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Integer count = answer.get(-(c[i] + d[j]));
                if (count != null) {
                    total += count;
                }
            }
        }

        System.out.println(total);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
