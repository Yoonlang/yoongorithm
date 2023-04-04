#include <iostream>
#include <vector>

using namespace std;

typedef long long ll;
typedef pair<ll, ll> pi;

pi getIncl(vector<pi> &pos, int a, int b) {
    auto i = pos[a];
    auto j = pos[b];
    return {i.first - j.first, i.second - j.second};
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, a, b;
    cin >> N;
    vector<pi> pos(N);
    for (int i = 0; i < N; i++) {
        cin >> a >> b;
        pos[i] = {a, b};
    }

    int res = 0;
    pi incl1, incl2, incl3;
    for (int i = 0; i < N; i++) {
        for (int j = i + 1; j < N; j++) {
            for (int k = j + 1; k < N; k++) {
                incl1 = getIncl(pos, i, j);
                incl2 = getIncl(pos, j, k);
                incl3 = getIncl(pos, k, i);
                if (incl1.first * incl2.first ==
                        -1 * incl1.second * incl2.second ||
                    incl2.first * incl3.first ==
                        -1 * incl2.second * incl3.second ||
                    incl3.first * incl1.first ==
                        -1 * incl3.second * incl1.second)
                    res++;
            }
        }
    }

    cout << res;

    return 0;
}
