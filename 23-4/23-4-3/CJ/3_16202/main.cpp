#include <bits/stdc++.h>

#define GRAPH second
#define X first
#define Y second
#define WEIGHT first

using namespace std;

typedef pair<int, int> pii;
typedef pair<int, pii> pipii;
typedef priority_queue<pipii, vector<pipii>, greater<pipii>> pqpipii;

int nodes; // [2, 1000]
int edges; // [1, min(10_000, N * (N-1) / 2)]
int turns; // [1, 100]

pqpipii graph;
int parents[1001];

int highest_ancestor(int node) {
    int parent = node;
    while (parents[parent] != parent) {
        parent = parents[parent];
    }
    return parent;
}

bool already_in_same_tree(pipii top) {
    int x = top.GRAPH.X;
    int y = top.GRAPH.Y;

    return highest_ancestor(x) == highest_ancestor(y);
}

bool merge_successful(pipii top) {
    if (already_in_same_tree(top))
        return false;

    int x = top.GRAPH.X;
    int y = top.GRAPH.Y;

    if (highest_ancestor(x) < highest_ancestor(y)) {
        parents[highest_ancestor(y)] = highest_ancestor(x);
    } else {
        parents[highest_ancestor(x)] = highest_ancestor(y);
    }
    return true;
}

void print_parents() {
    for (int i = 1; i <= nodes; i++)
        cout << parents[i] << " ";
    cout << "\n";
}

bool is_MST_made() {
    int the_only_parent = highest_ancestor(1);
    for (int i = 2; i <= nodes; i++) {
        if (highest_ancestor(i) != the_only_parent)
            return false;
    }
    return true;
}

void init_parents() {
    for (int i = 1; i <= nodes; i++)
        parents[i] = i;
}

int make_MST() {
    pqpipii graph_copy(graph);
    init_parents();
    int sum = 0;

    while (!graph_copy.empty()) {
        auto top = graph_copy.top();
        graph_copy.pop();

        // This merging step is where I got lost
        if (merge_successful(top)) {
            sum += top.WEIGHT;
        }
    }

    if (is_MST_made())
        return sum;
    return 0;
}

void delete_lowest_edge() { graph.pop(); }

int main(void) {
    cin >> nodes >> edges >> turns;

    for (int i = 1; i <= edges; i++) {
        int x, y;
        cin >> x >> y;
        graph.push({i, {min(x, y), max(x, y)}});
    }

    while (turns--) {
        cout << make_MST() << " ";
        delete_lowest_edge();
    }

    return 0;
}
