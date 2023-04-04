## First Memo

units : [1, 100]
available_study_time : [1, 10000]

expected_study_time : [1, 1000]
given_score : [1, 1000]

## Finished in > 4:00:00

I did the conditionals right, but I didn't memoize the early returning cases.

When it should return some number, without memoizing the early return, return just returns 0.

### wrong code

```cpp
#include <bits/stdc++.h>

using namespace std;

// units : [1, 100]
// available_study_time : [1, 10000]

// expected_study_time : [1, 1000]
// given_score : [1, 1000]

int units, available_study_time;
int expected_study_time[101];
int given_score[101];
int cache[101][10001];

int best_score(int unit, int time) {
  if (unit >= units) return 0;
  if (time > available_study_time) return 0;

  int& res = cache[unit][time];
  if (res != -1) return res;
  res = 0;

  int next_unit = unit + 1;
  int time_after_studying = time + expected_study_time[unit];

  // I DIDN'T DO THE MEMOIZATION
  if (time_after_studying > available_study_time) return best_score(next_unit, time);
  // return res = best_score(next_unit, time) <= this one is right

  int skipping_this_unit = best_score(next_unit, time);
  int studying_this_unit = best_score(next_unit, time_after_studying) + given_score[unit];

  return res = max(studying_this_unit, skipping_this_unit);
}

int main(void) {
  cin.tie(0);
  ios_base::sync_with_stdio(0);
  memset(cache, -1, sizeof(int) * 101 * 10001);

  cin >> units >> available_study_time;

  for (int i = 0; i < units; i++) {
    cin >> expected_study_time[i] >> given_score[i];
  }

  cout << best_score(0, 0);
  return 0;
}
```
