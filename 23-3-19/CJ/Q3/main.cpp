#include <bits/stdc++.h>
using namespace std;

#define HAPPY first
#define SAD second

int life;
vector<pair<int, int> > days;
int min_number = INT_MIN;
int max_number = INT_MAX;

int min_happy_until[1000001];
int max_sad_until[1000001];

int max_happy_from[1000001];
int min_sad_from[1000001];

int get_next_min(int feeling) {
  if (feeling == 0) return min_number++;
  return feeling;
}

int get_next_max(int feeling) {
  if (feeling == 0) return max_number--;
  return feeling;
}

void compute_days() {
  int min_happy = INT_MAX;
  int max_sad = INT_MIN;

  for (int i = 0; i < life; i++) {
    min_happy = min(min_happy, get_next_max(days[i].HAPPY));
    min_happy_until[i] = min_happy;
    max_sad = max(max_sad, get_next_min(days[i].SAD));
    max_sad_until[i] = max_sad;
  }

  int max_happy = INT_MIN;
  int min_sad = INT_MAX;

  for (int i = life - 1; i >= 0; i--) {
    max_happy = max(max_happy, get_next_min(days[i].HAPPY));
    max_happy_from[i] = max_happy;
    min_sad = min(min_sad, get_next_max(days[i].SAD));;
    min_sad_from[i] = min_sad;
  }
}

int main(void) {
  cin.tie(0);
  ios_base::sync_with_stdio(0);

  cin >> life;

  for (int i = 0; i < life; i++) {
    int happy, sad;
    cin >> happy >> sad;
    days.push_back(make_pair(happy, sad));
  }

  compute_days();

  int res = -1;
  for (int i = 0; i < life - 1; i++) {
    bool is_young_day = (min_happy_until[i] > max_happy_from[i + 1]) && (max_sad_until[i] < min_sad_from[i + 1]);
    if (is_young_day) {
      res = i + 1;
    }
  }
  cout << res;

  return 0;
}