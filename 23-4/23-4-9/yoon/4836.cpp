#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string line;
    while (getline(cin, line)) {
        vector<string> dances;
        string temp = "";
        for (auto c : line) {
            if (c == ' ') {
                dances.push_back(temp);
                temp = "";
            } else {
                temp.push_back(c);
            }
        }
        dances.push_back(temp);

        bool isTwirl = false;
        bool isDip = false;

        int err = 0;
        vector<bool> errors(6, false);
        for (int i = 0; i < dances.size(); i++) {
            if (dances[i] == "twirl")
                isTwirl = true;
            if (dances[i] == "dip")
                isDip = true;
            if (dances[i] == "dip") {
                bool isOK = false;
                if (i + 1 < dances.size() && dances[i + 1] == "twirl") {
                    isOK = true;
                }
                if (i - 1 >= 0 && dances[i - 1] == "jiggle") {
                    isOK = true;
                }
                if (i - 2 >= 0 && dances[i - 2] == "jiggle") {
                    isOK = true;
                }
                if (!isOK) {
                    dances[i] = "DIP";
                    if (errors[1] == false)
                        err++;
                    errors[1] = true;
                }
            }
        }

        if (dances.size() < 3 || dances[dances.size() - 1] != "clap" ||
            dances[dances.size() - 2] != "stomp" ||
            dances[dances.size() - 3] != "clap") {
            errors[2] = true;
            err++;
        }

        if (isTwirl) {
            bool isHop = false;
            for (auto dance : dances) {
                if (dance == "hop")
                    isHop = true;
            }
            if (!isHop) {
                errors[3] = true;
                err++;
            }
        }

        if (dances[0] == "jiggle") {
            errors[4] = true;
            err++;
        }

        if (!isDip) {
            errors[5] = true;
            err++;
        }

        cout << "form ";
        if (err == 0) {
            cout << "ok: " << line;
        } else if (err == 1) {
            cout << "error ";
            for (int i = 1; i <= 5; i++) {
                if (errors[i])
                    cout << i;
            }
            cout << ": ";
            for (auto dance : dances) {
                cout << dance << " ";
            }
        } else {
            vector<int> er;
            for (int i = 1; i <= 5; i++) {
                if (errors[i]) {
                    er.push_back(i);
                }
            }
            cout << "errors " << er[0];
            for (int i = 1; i < er.size() - 1; i++) {
                cout << ", " << er[i];
            }
            cout << " and " << er[er.size() - 1] << ": ";

            for (auto dance : dances) {
                cout << dance << " ";
            }
        }

        cout << '\n';
    }

    return 0;
}
