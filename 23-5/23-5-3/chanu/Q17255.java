package chanu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/*
9111

4
 */
public class Q17255 {
        static String inputString;
        static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputString = br.readLine();
        dfs(inputString);
        System.out.println(count);
    }

    static void dfs(String s) {
        if (s.length() == 1) {
            count++;
            return;
        }

        Set<Character> set = s.chars().mapToObj(i -> (char)i).collect(Collectors.toSet());

        if (set.size() == 1){
            count++;
            return;
        }
        dfs(s.substring(1));
        dfs(s.substring(0, s.length()-1));
    }


}

