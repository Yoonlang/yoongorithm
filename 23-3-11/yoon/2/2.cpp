#include <iostream>
#include <vector>

using namespace std;

typedef long long ll;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N;

    vector<bool> era(40001, true);
    vector<int> prime;
    vector<ll> dp(40001, 0);
    for(int i = 2; i <= 40000; i++) {
        if(era[i] == true) {
            prime.push_back(i);
            int t = 2;
            while(i * t <= 40000) {
                era[i * t] = false;
                t++;
            }
        }
    }

    dp[0] = 1;
    for(int i = 0; i < prime.size(); i++) {
        for(int j = prime[i]; j <= 40000; j++) {
            dp[j] = (dp[j] + dp[j - prime[i]]) % 123456789;
        }
    }

    cin >> N;
    cout << dp[N];
    return 0;
}
