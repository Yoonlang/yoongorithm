#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, T, k, s;
    cin >> N >> T;
    vector<vector<int>> dp(N + 1, vector<int>(T + 1));

    for (int i = 1; i <= N; i++) {
        cin >> k >> s;
        for (int j = 1; j <= T; j++) {
            if (k > j) {
                dp[i][j] = dp[i - 1][j];
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - k] + s);
            }
        }
    }

    cout << dp[N][T];

    return 0;
}
