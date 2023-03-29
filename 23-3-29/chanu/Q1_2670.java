import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
8
1.1
0.7
1.3
0.9
1.4
0.8
0.7
1.4

1.638
 */
public class Q1_2670 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = stod(br.readLine());
        }
        
        double result = 1;
        double maxResult = 0.001;
        for (int i=0; i<n; i++) {
            if (result * arr[i] < arr[i]) {
                result = arr[i];
            } else {
                result = result * arr[i];
            }

            maxResult = Math.max(maxResult, result);
        }
        System.out.printf("%.3f%n",(double) Math.round(maxResult * 1000) / 1000);

    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static double stod(String s) {
        return Double.parseDouble(s);
    }
}
