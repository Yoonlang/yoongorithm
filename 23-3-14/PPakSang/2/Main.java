package org.example.tony.D3_14.후보추천하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 3
 * 9
 * 2 1 4 3 5 6 2 7 2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());

        Map<Integer, Person> vote = new HashMap<>();
        Set<Integer> candidates = new HashSet<>();
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < T; i++) {
            int p = Integer.parseInt(temp[i]);

            if (candidates.contains(p)) {
                vote.get(p).vote += 1;
                continue;
            }

            vote.put(p, new Person(i, 1));
            if (candidates.size() != N) {
                candidates.add(p);
                continue;
            }

            int cNum = -1;
            int cTime = Integer.MAX_VALUE;
            int cVote = Integer.MAX_VALUE;
            for (Integer candidate : candidates) {
                Person person = vote.get(candidate);
                if (cVote > person.vote) {
                    cVote = person.vote;
                    cNum = candidate;
                    cTime = person.time;
                    continue;
                }

                if (cVote == person.vote) {
                    if (cTime > person.time) {
                        cVote = person.vote;
                        cNum = candidate;
                        cTime = person.time;
                    }
                }
            }

            candidates.remove(cNum);
            vote.remove(cNum);
            candidates.add(p);
        }

        for (int num : candidates.stream().sorted().collect(Collectors.toList())) {
            System.out.print(num + " ");
        }
    }

    static class Person {
        int time;
        int vote;

        Person(int time, int vote) {
            this.time = time;
            this.vote = vote;
        }
    }
}
