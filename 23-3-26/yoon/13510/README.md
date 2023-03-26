13510

쿼리 1: 간선 비용 바꾸기.

쿼리 2: 두 점 간의 경로에서 가장 큰 비용 출력

---

Solution

트리에 dfs를 통해서 오일러 투어 처리.

그 후 해당 배열을 segment tree로 바꾸고

간선들 최고 비용을 저장.

**2번 쿼리에 대해서**

2번 쿼리는 단순하게 처리하자면 $O(N)$ 만큼 걸림.

LCA를 이용해야함.

parent 2차원 배열 + depth를 통해서 처리

1. u와 v의 공통 조상을 찾는다 $O(logN)$
2. HLD 적용했기 때문에 u와 v 사이의 체인 개수는 최대 $logN$ 개
3. 즉 2번 쿼리는 $O(logN + logN * logN)$

TC

1번 쿼리 : $O(logN)$

2번 쿼리 : $O(logN + logN * logN)$

---

간선을 마치 노드처럼 취급해도 될까?

1번 쿼리는 그렇게하면 더 편하긴 함.

2번 쿼리는 ?

배열[특정 노드] = 부모에서 내려오는 간선 번호

로 처리하면 괜찮을거같은데?

---

노드 입장에서 오일러 투어 처리를 해두고

idx 처리는 엣지로 하자.

---

node가 양방향일 때, swap 처리?

1. node[here][0]은 size 젤 큰 자식 노드, 젤 마지막 child는 젤 뒤로.

---

젤 마지막에 있는거랑 스왑하니까 미스난다.

포문 다 돌고나서 처리해주는 방식으로 오일러 투어 처리.

---

7
1 2 4
1 3 1
2 4 1000
2 5 6
4 6 1
4 7 1

---

node, parentEdge, size는 node 기준

in, out, top, depth는 edge 기준

---

u, v => parentEdge => in => p, q

func(u, v) => p, q

LCA(in[parentEdge[u]], in[parentEdge[v]])

---

parent 구해놨고.

1. 둘 다 top이 같다. => 같은 체인이니까 그냥 find(p, q)
2. top이 다르다 => depth 맞추고 쭉쭉 올라가.

---

시간초과?

아직 못 풀었음.