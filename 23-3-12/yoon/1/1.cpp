#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    string a, b;
    while(1) {
        int alp[27] = {0};
        int alp2[27] = {0};
        getline(cin, a);
        getline(cin, b);
        if(cin.eof()) break;
        for(auto c : a) {
            alp[c - 'a']++;
        }
        for(auto c : b) {
            alp2[c - 'a']++;
        }

        for(int i = 0; i < 27; i++) {
            if(alp[i] > 0 && alp2[i] > 0) {
                for(int j = 0; j < min(alp[i], alp2[i]); j++) {
                    cout << (char)(i + 'a');
                }
            }
        }
        cout << '\n';
    }

    return 0;
}
