#include <iostream>
#include <string>
#include <unordered_set>
#include <vector>

using namespace std;

typedef long long ll;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int maxNum = 98766;
    vector<bool> era(maxNum, true);
    vector<int> prime;
    unordered_set<int> mixedPrime[6];
    unordered_set<ll> timedPrime;

    for (int i = 2; i < maxNum; i++) {
        if (era[i]) {
            prime.push_back(i);
            for (int j = i + i; j < maxNum; j += i) {
                era[j] = false;
            }
        }
    }

    for (int i = 0; i < prime.size(); i++) {
        for (int j = i + 1; j < prime.size(); j++) {
            int mixed = prime[i] + prime[j];
            string s = to_string(mixed);
            int length = s.size();
            if (mixed >= maxNum)
                break;
            vector<bool> nums(10, false);
            bool flag = false;
            for (auto c : s) {
                if (nums[c - '0']) {
                    flag = true;
                    break;
                }
                nums[c - '0'] = true;
            }
            if (!flag)
                mixedPrime[length].insert(mixed);
        }
    }

    for (int i = 0; i < prime.size(); i++) {
        for (int j = i + 1; j < prime.size(); j++) {
            ll timed = prime[i] * (ll)(prime[j]);
            if (timed >= maxNum)
                break;
            timedPrime.insert(timed);
        }
    }

    for (int i = 0; i < prime.size(); i++) {
        ll timed = prime[i] * (ll)(prime[i]);
        if (timed >= maxNum)
            break;
        timedPrime.insert(timed);
    }

    int K, M, res = 0;
    cin >> K >> M;
    for (auto num : mixedPrime[K]) {
        while (1) {
            if (num % M != 0)
                break;
            num /= M;
        }
        if (timedPrime.find(num) != timedPrime.end())
            res++;
    }

    cout << res;

    return 0;
}