#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

vector<int> parent(3001);

int fp(int a) {
    if (parent[a] == a)
        return a;
    return parent[a] = fp(parent[a]);
}

bool check(int a, int b) {
    int pa = fp(a);
    int pb = fp(b);
    if (pa == pb)
        return false;
    return true;
}

void join(int a, int b) {
    int pa = fp(a);
    int pb = fp(b);
    parent[pa] = pb;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int V, E, a, b;
    cin >> V >> E;
    vector<int> map(V + 1, 0);
    unordered_map<int, pair<int, int>> res;

    for (int i = 1; i <= V; i++) {
        parent[i] = i;
    }

    for (int i = 0; i < E; i++) {
        cin >> a >> b;
        map[a]++;
        map[b]++;

        if (check(a, b)) {
            join(a, b);
        }
    }

    for (int i = 1; i <= V; i++) {
        map[i] & 1 ? res[fp(i)].second++ : res[fp(i)].first++;
    }

    if (res.size() > 1) {
        cout << "NO";
        return 0;
    }

    for (auto entry : res) {
        if (entry.second.second == 0 || entry.second.second == 2) {
            cout << "YES";
            return 0;
        }
    }

    cout << "NO";
    return 0;
}
