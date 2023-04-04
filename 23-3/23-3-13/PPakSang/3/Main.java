package org.example.tony.D3_13.고냥이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 최대 N개의 종류의 알파벳을 가진 연속된 문자열밖에 인식하지 못한다.
 *
 * abbcaccba
 *
 * Stack
 * Set 을 넣으면서
 *
 * if (set.contains(next Character)) -> 넘어가기
 * else -> Set.size() + 1 > 허용치 -> 거리 갱신 (현재 문자열 위치에서 가장 처음 넣은 문자열 길이)
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        Queue<Integer> q = new LinkedList<>();
        Map<Character, Integer> nums = new HashMap<>();

        int cnt = 0;
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            int cNum = nums.getOrDefault(c, 0);

            if (cNum != 0) {
                nums.put(c, cNum+1);
                q.add(i);
                continue;
            }

            q.add(i);
            cnt++;
            if (cnt > n) {
                while (true) {
                    int idx = q.poll();
                    answer = Math.max(answer, i - idx);
                    char prevC = str.charAt(idx);
                    int prevNum = nums.get(prevC)-1;

                    nums.put(prevC, prevNum);
                    if ((prevNum) == 0) {
                        cnt--;
                        break;
                    }
                }
            }
            nums.put(c, 1);
        }

        answer = Math.max(answer, str.length() - q.poll());

        System.out.println(answer);
    }
}
