/*
회전 초밥 벨트에 놓인 접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c

8 30 4 30
7
9
7
30
2
7
9
25

5
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q2 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = stoi(st.nextToken());
        int d = stoi(st.nextToken());
        int k = stoi(st.nextToken());
        int c = stoi(st.nextToken());

        int[] foodNums = new int[n + k];
        HashMap<Integer, Integer> map = new HashMap<>();

        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            foodNums[i] = stoi(bf.readLine());
        }

        for (int i = n; i < n + k; i++) {
            foodNums[i] = foodNums[i-n];
        }

        //init
        for (int i = 0; i < k; i++) {
            Integer count = map.get(foodNums[i]);
            if (count == null) {
                count = 0;
            }
            map.put(foodNums[i], count + 1);
            maxCount = Math.max(maxCount, map.size() + (map.containsKey(c) ? 0 : 1));
        }

        for (int i = k; i < n + k; i++) {
            Integer count = map.get(foodNums[i]);
            if (count == null) {
                count = 0;
            }
            map.put(foodNums[i], count + 1);

            Integer preCount = map.get(foodNums[i-k]);

            map.put(foodNums[i-k], preCount-1);
            if (preCount-1 == 0) {
                map.remove(foodNums[i-k]);
            }

            maxCount = Math.max(maxCount, map.size() + (map.containsKey(c) ? 0 : 1));
        }
        System.out.println(maxCount);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
