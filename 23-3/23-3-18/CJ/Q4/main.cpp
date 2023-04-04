#include <bits/stdc++.h>

using namespace std;

// building_types
// buliding_relations
// games
// => [1: 100_000]

// for building_relations lines
// before -> after

// for games lines
// 1 (make) building
// 2 (destroy) building

// King-God-Emperor
// => iff "built properly" || "destroy only the built"
// Lier!
// => iff "built inproperly" || "destroy not yet built"

int building_types, building_relations, games;
vector<int> build_prerequisites[100001];
vector<int> build_precedents[100001];
int buildings[100001];
bool already_checked[100001];

bool is_built(int building) {
  return buildings[building] > 0;
}

bool is_build(int command) {
  return command == 1;
}
bool is_destroy(int command) {
  return command == 2;
}
bool is_requisites_done(int building) {
  if (build_prerequisites[building].empty())
    return true;
  for (auto requisite : build_prerequisites[building]) {
    if (!(buildings[requisite] > 0))
      return false;
  }
  return true;
}

int main(void) {
  cin.tie(0);
  ios_base::sync_with_stdio(0);

  cin >> building_types >> building_relations >> games;

  for (int i = 0; i < building_relations; i++) {
    int before, after;
    cin >> before >> after;
    build_prerequisites[after].push_back(before);
    build_precedents[before].push_back(after);
  }

  for (int i = 0; i < games; i++) {
    int command, building;
    cin >> command >> building;
    
    if (is_build(command)) {
      if (!already_checked[building] && !is_requisites_done(building)) {
        cout << "Lier!\n";
        return 0;
      }
      already_checked[building] = true;
      buildings[building]++;
    }
    if (is_destroy(command)) {
      if (!(buildings[building] > 0)) {
        cout << "Lier!\n";
        return 0;
      }
      buildings[building]--;
      if (buildings[building] == 0) {
        for (auto precedent : build_precedents[building])
          already_checked[precedent] = false;
      }
    }
  }
  cout << "King-God-Emperor\n";
  return 0;
}