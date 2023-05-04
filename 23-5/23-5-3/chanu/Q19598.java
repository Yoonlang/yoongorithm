package chanu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*
3
0 40
15 30
5 10

2
*/
public class Q19598 {
    static int n;
    static SortedMap<Integer, Integer> sMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sMap = new TreeMap<>();
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sMap.put(start, sMap.getOrDefault(start, 0) + 1);
            sMap.put(end, sMap.getOrDefault(end, 0) - 1);
        }

        int cur = 0;
        int result = 0;

        for (Integer e : sMap.values()) {
            cur += e;
            result = Math.max(cur, result);
        }

        System.out.println(result);
    }
}
