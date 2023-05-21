#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int res, N, total;
int num[100001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
#ifndef ONLINE_JUDGE
    freopen("data.txt", "r", stdin);
#endif

    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> num[i];
        num[i + N] = num[i];
        total += num[i];
    }
    int i = 0, j = 0, ans = 0;
    while (i < N && j < 2 * N) {
        if (ans > res) {
            ans -= num[i];
            i++;
        } else {
            ans += num[j];
            j++;
        }
        res = max(res, min(ans, total - ans));
    }

    cout << res;
    return 0;
}
