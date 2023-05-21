#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

const int mod = 1000000;
int dp[5001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
#ifndef ONLINE_JUDGE
    freopen("data.txt", "r", stdin);
#endif

    string s;
    cin >> s;
    dp[0] = 0;
    dp[1] = 1;
    if (s[0] == '0') {
        cout << 0;
        return 0;
    }
    for (int i = 1; i < s.size(); i++) {
        int l = i + 1;
        string temp = "";
        temp += s[i - 1];
        temp += s[i];
        if (s[i] == '0') {
            int t = stoi(temp);
            if (t != 10 && t != 20) {
                cout << 0;
                return 0;
            }
            dp[l] += dp[l - 2];
            dp[l] %= mod;
            if (l - 2 == 0)
                dp[l] = 1;
            continue;
        }

        if (11 <= stoi(temp) && stoi(temp) <= 26) {
            dp[l] += dp[l - 2];
            if (dp[l - 2] == 0)
                dp[l]++;
            dp[l] %= mod;
        }
        dp[l] += dp[l - 1];
        dp[l] %= mod;
    }

    cout << dp[s.size()];

    return 0;
}
