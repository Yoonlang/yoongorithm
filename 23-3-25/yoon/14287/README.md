14287

이거 그건가?

트리에서 세그먼트 트리 체인 만들기.

`Heavy light Decomposition`

만약 체인 만들었어. 체인 개수 log N개.

특정 라인에 다 더해주는거 시간복잡도가 어떻게 되는거지?

$O(logN * logN)$ : 체인 개수 * lazy propagation update

가능하다! 한번 배워좌.

[출처](https://justicehui.github.io/hard-algorithm/2020/01/24/hld/)

```
int sz[MAXV], dep[MAXV], par[MAXV], top[MAXV], in[MAXV], out[MAXV];
vector<int> g[MAXV];
/*
sz[i] = i를 루트로 하는 서브트리의 크기
dep[i] = i의 깊이
par[i] = i의 부모 정점
top[i] = i가 속한 체인의 가장 위에 있는 정점
in[i], out[i] = dfs ordering
g[i] = i의 자식 정점
*/

```

보통 in, out으로 ordering을 하는구나. 14267에서 했던 오일러 투어 테크닉.

전에 봤을땐 이해 안갔는데 이제야 이해가 되네.

g => tree

root의 depth == 1

size swap 처리를 위해서 dfs1에서 next 직접 접근

out[]은 -1 해서 생각해줘야함.

---

query1을 짜는게 중요하다.

일단 in[b] 에서부터 top[in[b]] 까지는 idx가 linear 하다.

즉 update [in[b], top[in[b]]] 해주면 됨.

while top이 1이 나올때 까지.

---

어째서인지 dfs1에서 65365에서 맘춘다. 메모리 떄문인가?

---

일단 dfs 관련 메모리 이슈는 인지했고 디버깅 오류도 고쳤음. 이제 문제는 왜 출력 초과가 뜨냐인데..

swap 해주는 게 문제인지 테스트 한번 해보자.

dfs1에서 좀 잘못된거같음.

tree[a]->b 에서 a, b 둘다 기존 ID

depth, parent, size, top, out 기존 ID

in[기존 ID] = 오일러 ID

