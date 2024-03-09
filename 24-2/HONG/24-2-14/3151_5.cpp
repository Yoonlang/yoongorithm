#include <algorithm>
#include <iostream>

using namespace std;

int main() {

    long long answer = 0;

    int N;
    cin >> N;

    int arr[10001];
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }

    sort(arr, arr + N);

    for (int i = 0; i < N - 2; i++) {
        for (int j = i + 1; j < N - 1; j++) {

            int find = -(arr[i] + arr[j]);
            int low = j + 1;
            int high = N - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (find < arr[mid]) {
                    high = mid - 1;
                } else if (find > arr[mid]) {
                    low = mid + 1;
                } else {
                    answer += 1;
                    int left = mid - 1;
                    int right = mid + 1;
                    while (low <= left && arr[left] == find) {
                        answer += 1;
                        left -= 1;
                    }
                    while (right <= high && arr[right] == find) {
                        answer += 1;
                        right += 1;
                    }
                    break;
                }
            }
        }
    }

    cout << answer;

    return 0;
}