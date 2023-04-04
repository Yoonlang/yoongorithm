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