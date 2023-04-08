#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

typedef long long ll;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    ll N, C, W;

    cin >> N >> C >> W;
    vector<int> trees(N);
    for (int i = 0; i < N; i++)
        cin >> trees[i];

    ll res = 0;
    for (int tl = 1; tl <= 10000; tl++) {
        ll c = 0, k = 0;
        for (auto tree : trees) {
            ll tempC = 0, tempK = 0;
            tempK += tree / tl;
            if (tree % tl == 0) {
                tempC += tree / tl - 1;
            } else {
                tempC += tree / tl;
            }
            if (tempK * tl * W - tempC * C > 0) {
                c += tempC;
                k += tempK;
            }
        }
        res = max(res, k * W * tl - c * C);
    }

    cout << res;

    return 0;
}
