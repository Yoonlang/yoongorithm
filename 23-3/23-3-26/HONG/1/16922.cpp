#include <algorithm>
#include <iostream>
using namespace std;

int N;
int answer;
int weight[4] = {1, 5, 10, 50};
int pick[20];
int flag[1001];

void dfs(int cnt, int idx, int total) {

    if (cnt == N) {
        if (!flag[total]) {
            flag[total] = 1;
            answer += 1;
        }
        return;
    }

    for (int i = idx; i < 4; i++) {
        pick[cnt] = i;
        dfs(cnt + 1, i, total + weight[i]); // 중복순열
    }
}

int main(void) {

    cin >> N;

    dfs(0, 0, 0);

    cout << answer;

    return 0;
}
