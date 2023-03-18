#include <bits/stdc++.h>

using namespace std;

int length;
int cache[101][101][101];

int result(int distance, int one_person, int the_other) {
  if (one_person < 0) return 0;
  if (distance <= the_other) return 0;
  if (one_person >= the_other) return 0;
  if (distance == 2) return 1;
  if (distance <= 1) return 0;

  int& res = cache[distance][one_person][the_other];
  if (res != -1) return res;

  res = 0;
  res += result(distance - 1, one_person, the_other) % 10007;
  res += result(distance - 1, one_person - 1, the_other) % 10007;
  res += result(distance - 1, one_person, the_other - 1) % 10007;
  res += result(distance - 1, one_person - 1, the_other - 1) % 10007;

  return res % 10007;
}

int main(void) {
  cin.tie(0);
  ios_base::sync_with_stdio(0);

  cin >> length;

  memset(cache, -1, sizeof(int) * 101 * 101 * 101);

  int answer = 0;
  for (int i = 0; i < length - 1; i++) {
    for (int j = i + 1; j < length; j++) {
      answer += result(length, i, j) % 10007;
    }
  }
  cout << answer * 2 % 10007;
  return 0;
}