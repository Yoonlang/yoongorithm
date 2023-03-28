13518 트리와 쿼리 9

서로 다른 정점의 가중치 개수라..

set으로 처리해야하나?

메모리 제한 충분히 만족하는가?

---

segment tree 노드가 set 이라면

set 2개를 합치는데 시간복잡도가 일반적으로 O(N) 아닌가?

그러면 한 쿼리당 N만큼 걸리면 절대 안됨.

set merge, union, insert


```
auto result = mapA;
result.insert(mapB.begin(), mapB.end());
```

이렇게하면 $O(N)$ 이긴 함.

unordered_set 사용하면

makeSeg N log N

---

역시 예상대로 unordered_set 써도 시간초과.. 어떻게 해결할 수 있을까.

단순히 생각해도

query TC : $O(logN * N)$

---

mo's algorithm

활용했던 걸 또 써먹는다라..

8
105 2 9 3 8 5 7 7
1 2
1 3
1 4
3 5
3 6
3 7
4 8
2
2 5
7 8

---

2 5 면 만약 이전에 1 3이 있었어.

그러면 query(2), query(5)만 하면 되잖아?

일단 모든 쿼리에 대해 필요한 범위를 찾아내봐?

---

각 쿼리마다 vector<pair<int, int>> 가 있음.

=> construct $O(M * log N)$

예를 들어서 2 5 라면

{6, 6} {1, 3} 이렇게.

7 8 이라면
{5, 5} {1, 2} {7, 8}

원래라면 이거 다 하나씩 범위 탐색 했어야해. segment tree에서.

mo로 처리하면 위의 모든 쿼리들에 대해서 처리하고, 처리한건 다 unordered_map에 넣어두면

다시 첫 쿼리로 돌아가서 쿼리당 logN * 1 에 처리가능.

위에서 총 M log N개를 sorting

$O(MlogN * log (MlogN))$

mo's algorithm TC : $O(N\sqrt{N})$

이걸 통해서 풀면 segment tree 필요 없을듯?

잠만. 이게 아니잖아.

각 쿼리당 logN개의 범위, 범위당 최대 N개의 수 

실수했다.

어차피 segment tree 안쓰는데 euler 까진 그렇다쳐도 HLD도 필요가 없겠는데?

현재 인지한 실수 : HLD로 분할된 범위로 mo's algorithm 돌려도 구하고자한 쿼리에 대해서 처리를 못함.

