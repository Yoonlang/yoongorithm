#include <algorithm>
#include <chrono>
#include <ext/pb_ds/assoc_container.hpp>
#include <iostream>
#include <vector>

using namespace std;
using namespace __gnu_pbds;

struct custom_hash {
    static uint64_t splitmix64(uint64_t x) {
        // http://xorshift.di.unimi.it/splitmix64.c
        x += 0x9e3779b97f4a7c15;
        x = (x ^ (x >> 30)) * 0xbf58476d1ce4e5b9;
        x = (x ^ (x >> 27)) * 0x94d049bb133111eb;
        return x ^ (x >> 31);
    }

    size_t operator()(uint64_t x) const {
        static const uint64_t FIXED_RANDOM =
            chrono::steady_clock::now().time_since_epoch().count();
        return splitmix64(x ^ FIXED_RANDOM);
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    gp_hash_table<int, int, custom_hash> A, B, C, D, AB;
    int N, a, b, c, d;
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> a >> b >> c >> d;
        A[a]++;
        B[b]++;
        C[c]++;
        D[d]++;
    }

    for (auto entryA : A) {
        for (auto entryB : B) {
            AB[entryA.first + entryB.first] += entryA.second * entryB.second;
        }
    }

    long long res = 0;
    for (auto entryC : C) {
        for (auto entryD : D) {
            int sum = -1 * (entryC.first + entryD.first);
            int cnt = entryC.second * entryD.second;
            if (AB.find(sum) != AB.end()) {
                res += (long long)AB[sum] * cnt;
            }
        }
    }

    cout << res;

    return 0;
}
