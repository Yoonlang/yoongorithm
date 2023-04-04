#include <algorithm>
#include <climits>
#include <iostream>
#include <vector>

using namespace std;

typedef long long ll;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N;
    cin >> N;

    int lim = 123;
    vector<ll> num(lim);
    vector<ll> sum(lim, 0);
    vector<int> res(N + 1, INT_MAX);
    res[0] = 0;

    for (int i = 0; i < lim; i++) {
        num[i] = i;
        if (i == 0)
            continue;
        sum[i] = sum[i - 1] + num[i];
    }

    for (int i = 1; i < lim; i++)
        sum[i] += sum[i - 1];

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j < lim; j++) {
            if (sum[j] > i)
                break;
            res[i] =
                min(res[i],
                    res[i - sum[j]] == INT_MAX ? INT_MAX : res[i - sum[j]] + 1);
        }
    }
    cout << res[N];

    return 0;
}
