import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1254 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int l = s.length();

        for (int i = 0; i < l; i++) {
            if (isPalindrom(s.substring(i))) {
                System.out.println(i + l);
                break;
            }
        }
    }

    static boolean isPalindrom(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start += 1;
            end -= 1;
        }

        return true;
    }
}
