// 참고
// https://velog.io/@dzf4444/%EB%B0%B1%EC%A4%80-2073-%EC%88%98%EB%8F%84%EB%B0%B0%EA%B4%80-%EA%B3%B5%EC%82%AC

#include <algorithm>
#include <climits>
#include <iostream>
#include <vector>

using namespace std;

typedef pair<int, int> pi;
int D, P, l, c;
int dp[100001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
#ifndef ONLINE_JUDGE
    freopen("data.txt", "r", stdin);
#endif

    dp[0] = 1;
    cin >> D >> P;
    for (int i = 1; i <= P; i++) {
        cin >> l >> c;

        for (int j = D; j >= l; j--) {
            if (dp[j - l]) {
                if (j == l) {
                    dp[j] = max(dp[j], c);
                } else {
                    dp[j] = max(dp[j], min(dp[j - l], c));
                }
            }
        }
    }
    cout << dp[D];
    return 0;
}
