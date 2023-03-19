#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

void dfs(vector<int> &v, int idx, string s) {
    if (idx == 9)
        return;

    s += '4';
    v.push_back(stoi(s));

    dfs(v, idx + 1, s);

    s.pop_back();
    s += '7';
    v.push_back(stoi(s));
    dfs(v, idx + 1, s);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<int> v;
    dfs(v, 0, "");

    sort(v.begin(), v.end());

    int A, B;
    cin >> A >> B;

    int aIdx = lower_bound(v.begin(), v.end(), A) - v.begin();
    int bIdx = upper_bound(v.begin(), v.end(), B) - v.begin();

    cout << (bIdx - aIdx);

    return 0;
}
