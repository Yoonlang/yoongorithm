package org.example.tony.D3_25.앱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 5 60
 * 30 10 20 35 40
 * 3 0 3 5 4
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int N = Integer.parseInt(temp[0]);
        int T = Integer.parseInt(temp[1]);

        List<App> apps = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            apps.add(new App(0, 0));
        }

        int[] memories = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] cost = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < N; i++) {
            App app = apps.get(i);
            app.memory = memories[i];
            app.cost = cost[i];
        }

        int answer = Integer.MAX_VALUE;
        Set<App> possible = new HashSet<>();
        Map<Integer, Integer> size = new HashMap<>();
        possible.add(new App(0, 0));
        size.put(0, 0);
        for (int i = 0; i < N; i++) {
            App cur = apps.get(i);

            Set<App> next = new HashSet<>(possible);
            for (App app : possible) {
                if (app.memory + cur.memory >= T) {
                    answer = Math.min(answer, app.cost + cur.cost);
                    continue;
                }

                // 같은 비용에 더 많은 메모리 확보
                // 같은 메모리에 더 적은 비용 확보
                App nApp = new App(app.memory + cur.memory, app.cost + cur.cost);
                if (next.contains(nApp)) {
                    if (size.get(nApp.cost) < nApp.memory) {
                        size.put(nApp.cost, nApp.memory);
                        next.remove(nApp);
                        next.add(nApp);
                    }
                    continue;
                }

                next.add(nApp);
                size.put(nApp.cost, nApp.memory);
            }
            possible = next;
        }
        System.out.println(answer);
    }

    static class App {
        int memory;
        int cost;

        public App(int memory, int cost) {
            this.memory = memory;
            this.cost = cost;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            App app = (App) o;
            return cost == app.cost;
        }

        @Override
        public int hashCode() {
            return Objects.hash(cost);
        }
    }
}
