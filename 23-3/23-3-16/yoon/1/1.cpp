#include <algorithm>
#include <iostream>

using namespace std;

typedef long long ll;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int T;
    cin >> T;
    for (int i = 0; i < T; i++) {
        ll N;
        cin >> N;

        ll left = 1;
        ll right = 150000000;

        ll res = 0;
        while (left <= right) {
            ll mid = (left + right) / 2;
            if (mid * (mid + 1) <= 2 * N) {
                res = max(res, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        cout << res << endl;
    }
    return 0;
}
