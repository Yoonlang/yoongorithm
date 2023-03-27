import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q3 {
    public static void main(String[] arg) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());

        int[] duration = new int[n];
        for (int i = 0; i < n; i++) {
            duration[i] = stoi(br.readLine());
        }

        System.out.println(binary(duration, m));
    }

    private static long binary(int[] duration, int m) {
        int n = duration.length;
        long result = Long.MAX_VALUE;;
        long start = 0;
        long end = (long) Arrays.stream(duration).max().getAsInt() * (long) m;

        while (start <= end) {
            long mid = (start + end) / 2;
            long total = 0;

            for (int i = 0; i < n; i++) {
                total += mid / duration[i];
                if (total >= m) {
                    break;
                }
            }

            if (total >= m) {
                end = mid - 1;
                result = Math.min(result, mid);
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }

}
