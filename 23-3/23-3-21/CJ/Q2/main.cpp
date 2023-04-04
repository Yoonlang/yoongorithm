#include <bits/stdc++.h>
using namespace std;

int dishes, sushis, discount_dishes, coupon;
int belt[6000000];
int max_sushis = 0;
set<int> eating;
int pieces[3001] = {0};

void get_sushi_types() {
  int sushi_types = eating.size();
  if (eating.find(coupon) == eating.end())
    sushi_types++;
  if (max_sushis < sushi_types) {
    max_sushis = sushi_types;
  }
}

bool next_sushi_found(int sushi) {
  return eating.find(sushi) != eating.end();
}

int main(void) {
  cin.tie(0);
  ios_base::sync_with_stdio(0);
  cin >> dishes >> sushis >> discount_dishes >> coupon;
  for (int i = 0; i < dishes; i++) {
    int sushi;
    cin >> sushi;
    belt[i] = belt[i + dishes] = sushi;
  }

  eating.insert(belt[0]);
  pieces[belt[0]]++;
  
  for (int i = 1; i < discount_dishes; i++) {
    int sushi = belt[i];
    if (!next_sushi_found(sushi))
      eating.insert(sushi);
    pieces[sushi]++;
  }
  get_sushi_types();

  for (int i = 1; i < dishes; i++) {
    int next_dish = i + discount_dishes - 1; // off by one happened here
    int next_sushi = belt[next_dish];

    if (!next_sushi_found(next_sushi))
      eating.insert(next_sushi);
    pieces[next_sushi]++;

    int prev_dish = i - 1;
    int prev_sushi = belt[prev_dish];
    
    pieces[prev_sushi]--;
    if (!pieces[prev_sushi])
      eating.erase(prev_sushi);

    get_sushi_types();
  }

  cout << max_sushis;
  
  return 0;
}