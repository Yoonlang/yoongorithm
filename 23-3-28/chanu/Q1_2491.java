/*
9
4 1 3 3 2 2 9 2 3

4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1_2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = stoi(st.nextToken());
        }

        int maxValue = 0;
        int maxCount = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {

            if (maxValue > arr[i]) {
                count = 1;
                maxValue = arr[i];
                continue;
            }

            count += 1;
            maxValue = arr[i];

            if (count > maxCount) {
                maxCount = count;
            }
        }

        int minValue = Integer.MAX_VALUE;
        count = 0;
        for (int i = 0; i < n; i++) {

            if (minValue < arr[i]) {
                count = 1;
                minValue = arr[i];
                continue;
            }

            count += 1;
            minValue = arr[i];

            if (count > maxCount) {
                maxCount = count;
            }
        }

        System.out.println(maxCount);




    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
