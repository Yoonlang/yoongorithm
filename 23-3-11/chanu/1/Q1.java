import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q1 {
    public static void main(String[] args) throws IOException {
        HashMap<Integer, String> map = new HashMap<>();
        HashMap<String, Integer> reversedNap = new HashMap<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N+1; i++) {
            String input = bf.readLine();
            map.put(i, input);
            reversedNap.put(input, i);
        }

        for (int i = 0; i < M; i++) {
            String input = bf.readLine();
            if ('0' <= input.charAt(0) && input.charAt(0) <= '9') {
                int cmd = Integer.parseInt(input);
                System.out.println(map.get(cmd));
            } else {
                System.out.println(reversedNap.get(input));
            }
        }
    }
}
