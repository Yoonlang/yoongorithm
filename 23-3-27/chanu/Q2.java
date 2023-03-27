import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
aabbbaa

1
 */
public class Q2 {

    static int result = 0;
    static HashMap<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            map.putIfAbsent(s.charAt(i), 0);
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }

        StringBuilder sb = new StringBuilder();
        dfs(sb, s.length());

        System.out.println(result);
    }

    private static void dfs(StringBuilder sb, int n) {
        if (sb.length() == n) {
            result += 1;
            return;
        }

        for (Character key : map.keySet()) {
            if ((sb.length() == 0 || key != sb.charAt(sb.length() - 1)) && map.get(key) > 0) {
                sb.append(key);
                map.put(key, map.get(key) - 1);

                dfs(sb, n);

                sb.deleteCharAt(sb.length() - 1);
                map.put(key, map.get(key) + 1);
            }
        }
    }

    private int stoi(String s) {
        return Integer.parseInt(s);
    }
}
