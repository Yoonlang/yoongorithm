#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool check(vector<vector<int>> map) {
    for(int i = 0; i < 3; i++) {
        for(int j = 1; j < 3; j++) {
            if(map[i][j] != map[i][0] || map[i][j] == 0) break;
            if(j == 2) return true;
        }

        for(int j = 1; j < 3; j++) {
            if(map[j][i] != map[0][i] || map[j][i] == 0) break;
            if(j == 2) return true;
        }
    }
    if(map[0][0] == map[1][1] && map[1][1] == map[2][2] && map[0][0] != 0) return true;
    if(map[0][2] == map[1][1] && map[1][1] == map[2][0] && map[0][2] != 0) return true;

    return false;
}

int game(vector<vector<int>> map, int x, int o) {
    bool isX = x == o ? true : false;
    
    if(x + o == 9) return 0;

    int res = 2;
    for(int i = 0; i < 3; i++) {
        for(int j = 0; j < 3; j++) {
            if(map[i][j] == 0) {
                map[i][j] = isX ? 1 : 2;
                isX ? x++ : o++;
                if(check(map)) {
                    return isX ? 1 : -1;
                }
                else {
                    int g = game(map, x, o);
                    if(res == 2) res = g;
                    else res = isX ? max(res, g) : min(res, g);
                }
                isX ? x-- : o--;
                map[i][j] = 0;
            }
        }
    }
    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<vector<int>> map(3, vector<int>(3));
    
    int x = 0, o = 0;
    for(int i = 0; i < 3; i++) {
        for(int j = 0; j < 3; j++) {
            cin >> map[i][j];  
            if(map[i][j] == 1) x++;
            else if(map[i][j] == 2) o++;
        }
    }

    int result = game(map, x, o);
    if(x > o) result *= -1;
    
    switch(result) {
        case 1:
            cout << 'W';
            break;
        case 0:
            cout << 'D';
            break;
        case -1:
            cout << 'L';
    }
    return 0;
}
