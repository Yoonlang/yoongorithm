#include <algorithm>
#include <climits>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int N, res = INT_MAX;
string origin, dest;

void change(string &s, int idx) {
    for (int i = 0; i < 3; i++) {
        s[idx - 1 + i] = s[idx - 1 + i] == '1' ? '0' : '1';
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
#ifndef ONLINE_JUDGE
    freopen("data.txt", "r", stdin);
#endif

    cin >> N >> origin >> dest;
    int len = origin.length();

    string o = origin;
    int r = 1;
    o[0] = o[0] == '1' ? '0' : '1';
    o[1] = o[1] == '1' ? '0' : '1';
    for (int i = 1; i < len - 1; i++) {
        if (o[i - 1] != dest[i - 1]) {
            r++;
            change(o, i);
        }
    }
    if (o[len - 2] != dest[len - 2] && o[len - 1] != dest[len - 1]) {
        r++;
        res = min(res, r);
    }
    if (o[len - 2] == dest[len - 2] && o[len - 1] == dest[len - 1]) {
        res = min(res, r);
    }

    o = origin;
    r = 0;
    for (int i = 1; i < len - 1; i++) {
        if (o[i - 1] != dest[i - 1]) {
            r++;
            change(o, i);
        }
    }
    if (o[len - 2] != dest[len - 2] && o[len - 1] != dest[len - 1]) {
        r++;
        res = min(res, r);
    }
    if (o[len - 2] == dest[len - 2] && o[len - 1] == dest[len - 1]) {
        res = min(res, r);
    }

    cout << (res == INT_MAX ? -1 : res);

    return 0;
}
