#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, d, k, c, t;
    cin >> N >> d >> k >> c;
    vector<int> list(N * 2);
    for (int i = 0; i < N; i++) {
        cin >> t;
        list[i] = t;
        list[i + N] = t;
    }

    unordered_map<int, int> map;
    map[c]++;
    map[list[0]]++;
    int i = 0, j = 0, res = 0;
    while (i < N * 2 && j < N * 2) {
        if (j - i + 1 == k) {
            res = max(res, (int)map.size());
            map[list[i]]--;
            if (map[list[i]] == 0)
                map.erase(list[i]);
            i++;
        } else {
            j++;
            map[list[j]]++;
        }
    }

    cout << res;

    return 0;
}
