#include <algorithm>
#include <iostream>
#include <set>
#include <string>
#include <vector>

using namespace std;

int N, P, a, b;
int num[100001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    set<pair<int, int>> s;

    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> a >> b;
        num[a] = b;
        s.insert({b, a});
    }

    string t;
    cin >> P;
    for (int i = 0; i < P; i++) {
        cin >> t >> a;
        if (t == "add") {
            cin >> b;
            s.insert({b, a});
            num[a] = b;
        } else if (t == "recommend") {
            if (a == 1) {
                auto it = s.end();
                it--;
                cout << it->second << '\n';
            } else {
                auto it = s.begin();
                cout << it->second << '\n';
            }
        } else {
            s.erase(s.find({num[a], a}));
        }
    }

    return 0;
}
