#include <algorithm>
#include <iostream>
#include <set>
#include <vector>

using namespace std;

typedef pair<int, int> pi;

pi makeSeg(vector<int> &candy, vector<pi> &segTree, int root, int start,
           int end) {
    if (start == end) {
        return segTree[root] = {0, candy[start]};
    }

    int mid = (start + end) / 2;
    auto l = makeSeg(candy, segTree, root * 2, start, mid);
    auto r = makeSeg(candy, segTree, root * 2 + 1, mid + 1, end);
    return segTree[root] = {0, max(l.second, r.second)};
}

int getCandy(vector<int> &candy, vector<pi> &segTree, int find, int root,
             int start, int end) {
    if (start == end) {
        segTree[root].first--;
        return segTree[root].second;
    }

    int mid = (start + end) / 2;
    if (segTree[root].first >= find) {
        segTree[root].first--;
        return getCandy(candy, segTree, find, root * 2, start, mid);
    } else {
        return getCandy(candy, segTree, find - segTree[root].first,
                        root * 2 + 1, mid + 1, end);
    }
}

void handleCandy(vector<int> &candy, vector<pi> &segTree, int value, int num,
                 int root, int start, int end) {
    if (start == end) {
        segTree[root].first += num;
        return;
    }

    int mid = (start + end) / 2;
    if (segTree[root * 2].second < value) {
        handleCandy(candy, segTree, value, num, root * 2 + 1, mid + 1, end);
    } else {
        segTree[root].first += num;
        handleCandy(candy, segTree, value, num, root * 2, start, mid);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N;
    cin >> N;
    set<int> candy1;
    vector<vector<int>> querys(N);

    for (int i = 0; i < N; i++) {
        vector<int> temp;
        int a, b, c;
        cin >> a >> b;
        temp.push_back(a);
        temp.push_back(b);
        if (a != 1) {
            cin >> c;
            temp.push_back(c);
            candy1.insert(b);
        }
        querys[i] = temp;
    }
    vector<int> candy(candy1.begin(), candy1.end());
    candy.insert(candy.begin(), 0);
    int cs = candy.size() - 1;
    vector<pi> segTree(cs * 4);
    makeSeg(candy, segTree, 1, 1, cs);

    for (int i = 0; i < N; i++) {
        if (querys[i][0] == 1) {
            int findValue = querys[i][1];
            cout << getCandy(candy, segTree, findValue, 1, 1, cs) << '\n';
        } else {
            int value = querys[i][1], num = querys[i][2];
            handleCandy(candy, segTree, value, num, 1, 1, cs);
        }
    }

    return 0;
}
