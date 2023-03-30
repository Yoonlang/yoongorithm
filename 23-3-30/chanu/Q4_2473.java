/*
5
-2 6 -97 -6 98

 -97 -2 98
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q4_2473 {

    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());

        arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = stoi(st.nextToken());
        }

        Arrays.sort(arr);

        long optimalValue = Long.MAX_VALUE;
        long[] result = new long[3];

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 2; j < n; j++) {
                int middleIndex = binary(i + 1, j - 1, -(arr[i] + arr[j]));
                long x = arr[i] + arr[j] + arr[middleIndex];

                if (optimalValue > Math.abs(x)) {
                    optimalValue = Math.abs(x);
                    result[0] = arr[i];
                    result[1] = arr[middleIndex];
                    result[2] = arr[j];
                }
            }
        }

        System.out.print(result[0] + " " + result[1] + " " + result[2] + "\n");
    }

    public static int binary(int start, int end, long value) {
        long optimalValue = Long.MAX_VALUE;
        int optimalIndex = -1;

        while (start <= end) {
            int middle = (start + end) / 2;

            if (arr[middle] == value) {
                return middle;
            }

            if (arr[middle] < value) {
                start = middle + 1;
                if (optimalValue > Math.abs(arr[middle] - value)) {
                    optimalValue = Math.abs(arr[middle] - value);
                    optimalIndex = middle;
                }
                continue;
            }

            if (arr[middle] > value) {
                end = middle - 1;

                if (optimalValue > Math.abs(arr[middle] - value)) {
                    optimalValue = Math.abs(arr[middle] - value);
                    optimalIndex = middle;
                }
            }
        }

        return optimalIndex;
    }


    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
