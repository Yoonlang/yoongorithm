#include <algorithm>
#include <iostream>
#include <string>
#include <unordered_set>
#include <vector>

using namespace std;

int N;
bool map[51][51];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    string s;

    for (int i = 0; i < N; i++) {
        cin >> s;
        for (int j = 0; j < N; j++) {
            map[i][j] = s[j] == 'Y' ? 1 : 0;
        }
    }

    int res = 0;
    for (int i = 0; i < N; i++) {
        // 각 사람에 대해서
        unordered_set<int> set;
        for (int j = 0; j < N; j++) {
            if (i == j)
                continue;
            if (map[i][j]) {
                set.insert(j);
                for (int k = 0; k < N; k++) {
                    if (i == k || j == k)
                        continue;
                    if (map[j][k])
                        set.insert(k);
                }
            }
        }
        res = max(res, (int)set.size());
    }

    cout << res;

    return 0;
}
