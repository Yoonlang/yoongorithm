#include <bits/stdc++.h>

using namespace std;

// input_length <= 1000
// food_length <= 15
// food_name <= 15 char-long-string

typedef struct Tree* TreePointer;
typedef struct Tree {
  string value;
  vector<TreePointer> children;
} Tree;

int input_length;
Tree* base;

bool has_common_ancester(Tree* parent, Tree* node) {
  return !(parent->value.compare(node->value));
}

void attach_to_lowest_common_ancester(Tree* parent, Tree* node) {
  for (auto child : parent->children) {
    if (has_common_ancester(child, node)) {
      return attach_to_lowest_common_ancester(child, node->children[0]);
    }
  }

  parent->children.push_back(node);
}

bool cmp(TreePointer a, TreePointer b) {
  return (a->value.compare(b->value)) <= 0;
}

void print_node(Tree* node, int depth) {
  if (!node) return;
  if (node->value.empty()) return;

  for (int i = 0; i < depth; i++) {
    cout << "--";
  }
  cout << node->value << "\n";

  sort(node->children.begin(), node->children.end(), cmp);
  for (auto child : node->children) {
    print_node(child, depth + 1);
  }
}

int main(void) {
  cin.tie(0);
  ios_base::sync_with_stdio(0);

  base = new Tree();

  cin >> input_length;
  for (int i = 0; i < input_length; i++) {
    int food_length;
    cin >> food_length;

    Tree* sub_tree = new Tree();
    TreePointer leaf_ptr = &(*sub_tree);

    for (int j = 0; j < food_length; j++) {
      Tree* node = new Tree();
      cin >> node->value;
      leaf_ptr->children.push_back(node);
      leaf_ptr = &(*node);
    }
    sub_tree = sub_tree->children[0];

    if (base->children.empty()) {
      base->children.push_back(sub_tree);
    } else {
      attach_to_lowest_common_ancester(base, sub_tree);
    }
  }

  sort(base->children.begin(), base->children.end(), cmp);
  for (TreePointer tree_ptr : base->children) {
    print_node(tree_ptr, 0);
  }

  return 0;
}