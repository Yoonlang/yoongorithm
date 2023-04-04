// https://www.acmicpc.net/problem/2217

// log2(100000) -> 16.6
// log2(1000000) -> 100

#include <algorithm>
#include <iostream>

using namespace std;

int main() {

    int answer;
    int n, arr[100001];
    cin >> n;

    for (int i = 1; i <= n; i++)
        cin >> arr[i];

    sort(arr + 1, arr + n + 1, greater<int>());

    int max = arr[1];
    for (int i = 2; i <= n; i++) {
        int max_possible = arr[i] * i;
        if (max_possible > max)
            max = max_possible;
    }

    cout << max;

    return 0;
}