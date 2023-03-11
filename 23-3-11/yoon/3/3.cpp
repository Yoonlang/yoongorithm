#include <iostream>
#include <vector>

using namespace std;

pair<int, int> dfs(vector<vector<int>>& node, vector<bool>& visited, int here) {
    int nodes = 1, edges = node[here].size();
    for(auto next : node[here]) {
        if(visited[next]) continue;
        visited[next] = true;
        auto info = dfs(node, visited, next);
        nodes += info.first;
        edges += info.second;
    }
    return {nodes, edges};
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M;
    cin >> N >> M;
    vector<bool> visited(N + 1);
    vector<vector<int>> node(N + 1);

    int a, b;
    for(int i = 0; i < M; i++) {
        cin >> a >> b;
        node[a].push_back(b);
        node[b].push_back(a);
    }

    int res = 0;
    for(int i = 1; i <= N; i++) {
        if(visited[i]) continue;
        visited[i] = true;
        auto info = dfs(node, visited, i);
        info.second /= 2;
        res += max(0, info.second - info.first + 1);
        res++;
    }
    res--;
    cout << res;
    return 0;
}
