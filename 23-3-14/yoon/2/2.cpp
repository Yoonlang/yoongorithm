#include <algorithm>
#include <climits>
#include <iostream>
#include <vector>

using namespace std;

typedef pair<int, int> pi;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N, M, t;
    cin >> N >> M;
    vector<pi> pic; // 학생 id, 추천 받은 수

    for (int i = 0; i < M; i++) {
        cin >> t;

        bool flag = true;
        for (auto &p : pic) {
            if (p.first == t) {
                p.second++;
                flag = false;
                break;
            }
        }
        if (flag) {
            if (pic.size() == N) {
                int minn = INT_MAX;
                for (auto p : pic) {
                    minn = min(minn, p.second);
                }
                for (int j = 0; j < N; j++) {
                    if (pic[j].second == minn) {
                        pic.erase(pic.begin() + j);
                        pic.push_back({t, 1});
                        break;
                    }
                }
            } else {
                pic.push_back({t, 1});
            }
        }
    }

    sort(pic.begin(), pic.end());
    for (auto p : pic) {
        cout << p.first << " ";
    }

    return 0;
}
