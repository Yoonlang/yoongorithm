#include <iostream>
#include <tuple>
#include <vector>

using namespace std;

typedef tuple<int, int, vector<int>, vector<int>> ti;
// 현재 이 건물이 몇 개 지어졌는지, 이전 태크게 몇 개 지어졌는지,
// 이전 태크, 다음 태크

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, K, a, b;
    cin >> N >> M >> K;

    vector<ti> v(N);

    for (int i = 0; i < M; i++) {
        cin >> a >> b;
        a--;
        b--;
        get<2>(v[b]).push_back(a);
        get<3>(v[a]).push_back(b);
    }

    for (int i = 0; i < K; i++) {
        cin >> a >> b;
        b--;
        if (a == 1) {
            if (get<1>(v[b]) == get<2>(v[b]).size()) {
                if (get<0>(v[b]) == 0) {
                    for (auto next : get<3>(v[b])) {
                        get<1>(v[next])++;
                    }
                }
                get<0>(v[b])++;
            } else {
                cout << "Lier!";
                return 0;
            }
        } else {
            if (get<0>(v[b]) == 0) {
                cout << "Lier!";
                return 0;
            }
            get<0>(v[b])--;
            if (get<0>(v[b]) == 0) {
                for (auto next : get<3>(v[b])) {
                    get<1>(v[next])--;
                }
            }
        }
    }

    cout << "King-God-Emperor";
    return 0;
}
