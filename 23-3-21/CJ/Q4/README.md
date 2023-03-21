## First Memo

up_slope > dotted
down_slope > line

enterance > 0

shortest path to go through all the buildings
but as small up_slopes as possible

going up k up_slope -> fatigue k^2

going down_slope back up doesn't count as going up_slope

ANSWER > difference between largest fatigue and smallest fatigue

kinda fills like a MST problem?

For all combinations of MST, get the highest and the lowest?

INPUT

buildings : [1, 1_000]
roads: [1, 500 * 999] (buildings \* (buildings - 1) / 2)

A B C => from, to, is_up_slope

What should I do? Do a greedy one? or check all the combinations?

If I were to check all the combinations, the solution will be O(N^3), which might be affordable. Then, let's go

## Finished in > 3:00:00

At first, I tried to get the all combinations, and record biggest and smallest values, however that caused TLE.

Thus, I tried to divide the Maximum Spanning Tree case and the Minimum Spanning Tree case.

At a point of a Spanning Tree, I tried to make priority_queue or vector of next buildings to go. However, that caused exceeded memory limit.

I thought it through again. Because MST can be calculated in a greedy way, instead of long list, I just kept _a (one)_ lowest slope value and the corresponding building number.

That solved the memory issue, but still got TLE.

The time complexity of my solution was just O(N^3), which wasn't that large. So I thought if I could cut some iteration, my solution might pass.

Therefore, I added a early break at the outer for-loop. I could do this because the MST can be obtained with greedy approach. Then, got AC!

```cpp
#include <bits/stdc++.h>
#define SLOPE first
#define TO second

using namespace std;

int buildings, roads;
vector<pair<int, int> > campus_map[1001];
int visited[1001];


int get_max_fatigue() {
  int max_fatigue = 0;

  int max_slope = -1;
  int next_building = 0;
  for (int here = 0; here <= buildings; here++) {
    if (visited[here]) {
      for (auto connected_building : campus_map[here]) {
        int to = connected_building.TO;
        int slope = connected_building.SLOPE;
        if (!visited[to])
          if (slope > max_slope) {
            max_slope = slope;
            next_building = to;
          }
      }
    }
    // Just adding the line below made this solution TLE to AC
    if (max_slope == 1) break;
  }

  if (next_building == 0) return 0;

  visited[next_building] = 1;
  int fatigue = get_max_fatigue();
  max_fatigue = max(max_fatigue, fatigue + max_slope);

  return max_fatigue;
}

int get_min_fatigue() {
  int min_fatigue = INT_MAX;

  int min_slope = 2;
  int next_building = 0;
  for (int here = 0; here <= buildings; here++) {
    if (visited[here]) {
      for (auto connected_building : campus_map[here]) {
        int to = connected_building.TO;
        int slope = connected_building.SLOPE;
        if (!visited[to])
          if (slope < min_slope) {
            min_slope = slope;
            next_building = to;
          }
      }
    }
    // Just adding the line below made this solution TLE to AC
    if (min_slope == 0) break;
  }

  if (next_building == 0) return 0;

  visited[next_building] = 1;
  int fatigue = get_min_fatigue();
  min_fatigue = min(min_fatigue, fatigue + min_slope);

  return min_fatigue;
}

int main(void) {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  cin >> buildings >> roads;

  for (int i = 0; i <= roads; i++) {
    int from, to, is_up_slope;
    cin >> from >> to >> is_up_slope;
    campus_map[from].push_back({!is_up_slope, to});
    campus_map[to].push_back({!is_up_slope, from});
  }

  memset(visited, 0, sizeof(int) * 1001);
  visited[0] = 1;
  int max_fatigue = get_max_fatigue();
  // cout << max_fatigue << " ";

  memset(visited, 0, sizeof(int) * 1001);
  visited[0] = 1;
  int min_fatigue = get_min_fatigue();
  // cout << min_fatigue << " ";

  cout << max_fatigue * max_fatigue - min_fatigue * min_fatigue;

  return 0;
}
```
