#include <algorithm>
#include <iostream>

using namespace std;

int main() {

  int N, M;
  cin >> N >> M;

  int arr[10001] = {0};
  cin >> arr[1];
  for (int i = 2; i <= N; i++) {
    cin >> arr[i];
    arr[i] += arr[i - 1];
  }

  int left = 1;
  int right = 1;
  int sum = 0;
  int answer = 0;

  while (left <= N && right <= N) {
    sum = arr[right] - arr[left - 1];
    if (sum == M) {
      answer += 1;
      right += 1;
    } else if (sum < M) {
      right += 1;
    } else if (sum > M) {
      left += 1;
    }
  }

  cout << answer;

  return 0;
}