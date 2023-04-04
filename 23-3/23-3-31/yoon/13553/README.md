13553

이것도 오프라인 쿼리고

모스 알고리즘 쓰면 될거같은데

-K <= Ai - Aj <= K

Aj - K <= Ai <= Aj + K

seg find 범위를 [Aj - K, Aj + K]로 해서 정답 찾으면 될듯.

주의해야할 점은 1 뺴줘야한다는 것.

그럼 걸음 옮길때마다 log N
find 할 때 log N

보통 걸음당 O(1)을 추구할때 시간제한이 2초니까

시간제한 3초면 충분하지않을까?

---

응 충분하지 않아.

이 문제도 sqrt decomposition 쓰는 문제일까? 놉

정답은 fenwick tree 였습니다!

현재 segment tree로 구현한 로직을 fenwick으로 처리하면 됨.

그렇다면 왜 seg tree는 안되고 fenwick tree는 될까?

채찍이한테 물어본 결과, 두 자료구조의 차이점은 범위 update.

먼저 range update, point query

seg => O(log N)

fenwick => O(N log N)

하지만 point update, range query는?

seg => O(log^2 N)

fenwick => O(log N)

이게 어떻게 되는건지는 팬윅트리 공부하면서 알아보자.

?? 근데 내가 짠건 O(log N)인데.

왜 내껀 시간초과가 날까.

잠깐 생각해보면 update, find니까 2 log N 이라서?

시간제한이 1초만 늘어난거 생각해보면 상수차이일 수도 있겠다.