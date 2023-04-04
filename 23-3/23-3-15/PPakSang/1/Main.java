package org.example.tony.D3_15.퇴사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 7
 * 3 10
 * 5 20
 * 1 10
 * 1 20
 * 2 15
 * 4 40
 * 2 200
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] values = new int[N+1];
        Map<Integer, Schedule> schedule = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String[] temp = br.readLine().split(" ");
            int T = Integer.parseInt(temp[0]);
            int V = Integer.parseInt(temp[1]);

            schedule.put(i, new Schedule(T, V));
            values[i] = 0;
        }

        int answer = 0;
        int prevMax = 0;
        for (int i = 1; i <= N; i++) {
            Schedule today = schedule.get(i);
            int prev = values[i];
            prevMax = Math.max(prevMax, prev);
            int nDay = i + today.t - 1;
            if (nDay > N) {
                continue;
            }

            answer = Math.max(answer, prevMax + today.v);
            //일을 수행할 수 있다
            if (nDay + 1 <= N) {
                if (values[nDay + 1] < prevMax + today.v) {
                    values[nDay + 1] = today.v + prevMax;
                }
            }
        }


        System.out.println(answer);
    }

    static class Schedule {
        int t;
        int v;

        public Schedule(int t, int v) {
            this.t = t;
            this.v = v;
        }
    }
}
