#include <bits/stdc++.h>

using namespace std;

int from, to;

int count_favorite_numbers(long long k) {
  if (k > 777777777) return 0;
  long long add_four_to_the_end = k * 10 + 4;
  long long add_seven_to_the_end = k * 10 + 7;
  if (k > to) return 0;
  if (k < from) return count_favorite_numbers(add_four_to_the_end) + count_favorite_numbers(add_seven_to_the_end);

  int res = count_favorite_numbers(add_four_to_the_end) + count_favorite_numbers(add_seven_to_the_end) + 1;

  return res;
}

int main(void) {
  cin.tie(0);
  ios_base::sync_with_stdio(0);

  cin >> from >> to;

  cout << count_favorite_numbers(0) << "\n";
  return 0;
}