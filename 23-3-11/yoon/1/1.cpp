#include <iostream>
#include <unordered_map>
#include <string>

using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    unordered_map<string, int> si;
    unordered_map<int, string> is;

    int N, M;
    string t;
    cin >> N >> M;
    for(int i = 1; i <= N; i++){
        cin >> t;
        si.insert({t, i});
        is.insert({i, t});
    }
    for(int i = 0; i < M; i++){
        cin >> t;
        if(si[t]) cout << si[t] << '\n';
        else cout << is[stoi(t)] << '\n';
    }
    return 0;
}
