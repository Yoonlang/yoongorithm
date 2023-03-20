#include <algorithm>
#include <iostream>

using namespace std;

int answer = 0;
int N, M, ingreds[100000];

int main() {

  cin >> N >> M;
  for (int i = 0; i < N; i++)
    cin >> ingreds[i];

  sort(ingreds + 0, ingreds + N);

  int left = 0;
  int right = N - 1;

  while (left < right) {
    int test = ingreds[left] + ingreds[right];
    if (test == M) {
      answer += 1;
      left++;
      right--;
    } else if (test < M) {
      left++;
    } else if (test > M) {
      right--;
    }
  }

  cout << answer;

  return 0;
}