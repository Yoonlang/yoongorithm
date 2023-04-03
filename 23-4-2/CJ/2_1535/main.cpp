#include <bits/stdc++.h>
using namespace std;

// KnapSack?

int people; // [, 20]
vector<int> damages;
vector<int> joys;
int cache[21][101];

int max_joy(int person, int health) {
    if (health <= 0)
        return INT_MIN;
    if (person >= people)
        return 0;

    int &ret = cache[person][health];
    if (ret != -1)
        return ret;
    ret = 0;

    int pass_this_person = max_joy(person + 1, health);
    ret = max(ret, pass_this_person);

    int greet_this_person =
        max_joy(person + 1, health - damages[person]) + joys[person];
    ret = max(ret, greet_this_person);

    return ret;
}

int main(int argc, char *argv) {
    cin >> people;

    int damage, joy;
    for (int i = 0; i < people; i++) {
        cin >> damage;
        damages.push_back(damage);
    }
    for (int i = 0; i < people; i++) {
        cin >> joy;
        joys.push_back(joy);
    }
    memset(cache, -1, sizeof(int) * 21 * 101);
    cout << max_joy(0, 100);

    return 0;
}