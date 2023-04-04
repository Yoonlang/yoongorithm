package org.example.tony.D3_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * pretty
 * women
 * walking
 * down
 * the
 * street
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String a = br.readLine();
            if (a == null) {
                return;
            }
            String b = br.readLine();

            Map<Character, Integer> aMap = new HashMap<>();
            List<String> result = new ArrayList<>();
            for (int i = 0; i < a.length(); i++) {
                char c = a.charAt(i);
                aMap.put(c, aMap.getOrDefault(c, 0)+1);
            }

            for (int i = 0; i < b.length(); i++) {
                char c = b.charAt(i);
                int num = aMap.getOrDefault(c, 0);
                if (num == 0) {
                    continue;
                }
                aMap.put(c, num-1);
                result.add(String.valueOf(c));
            }

            result.sort(Comparator.naturalOrder());
            String answer = String.join("", result);
            System.out.println(answer);
        }
    }
}
