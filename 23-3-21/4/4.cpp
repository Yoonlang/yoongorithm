#include <iostream>
#include <queue>
#include <tuple>
#include <vector>

using namespace std;

typedef pair<int, int> pi;
typedef tuple<int, int, int> ti;

vector<int> parent(1001);

int fp(int a) {
    if (a == parent[a])
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
    int N, M, a, b, c;
    cin >> N >> M;

    priority_queue<ti, vector<ti>, greater<>> pqG;
    priority_queue<ti, vector<ti>> pqL;

    for (int i = 0; i <= N; i++)
        parent[i] = i;

    for (int i = 0; i <= M; i++) {
        cin >> a >> b >> c;
        pqG.push({c == 0 ? 1 : 0, a, b});
        pqL.push({c == 0 ? 1 : 0, a, b});
    }

    int resG = 0, resL = 0;
    while (!pqG.empty()) {
        auto [weight, a, b] = pqG.top();
        pqG.pop();
        if (check(a, b)) {
            join(a, b);
            resG += weight;
        }
    }

    for (int i = 0; i <= N; i++)
        parent[i] = i;

    while (!pqL.empty()) {
        auto [weight, a, b] = pqL.top();
        pqL.pop();
        if (check(a, b)) {
            join(a, b);
            resL += weight;
        }
    }

    cout << ((resL * resL) - (resG * resG));

    return 0;
}
