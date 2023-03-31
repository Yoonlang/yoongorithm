13546

특정 범위에서

값이 같은 index 두개에 대해 가장 큰 값 찾기라..

mo's algorithm 쌔리고

K가 10만이야? 개꿀딱인데.

---

잠만.

maxx 값 처리에 대해서 이슈가 생긴거같은데.

다른 max 값들을 알고있어야

maxx 하나 뺐을 때, 다음 최대값을 알지.

set으로 처리하기? 넣고빼기 쉬울거같은데.

한칸 움직이는데 $log N$? 이게 맞나.

---

왜 에러가 나는걸까

내 생각에는 5 5 에서 6 6으로 이동할 때 에러가 발생할 수도 있겠는데

---

10 7
4 2 3 1 7 4 4 2 1 7 
5
6 6
5 6
3 5
3 7
1 7

1 7
3 5
5 6
3 7
6 6

지금 1 6, 1 7에서 처리할 때, 6 7 처리를 안해줘서 5가 남고 1이 없는데 1을 지워서 문제가 발생.

현재 방식으로 처리하려면 넣을 때 $log N$일 줄 알았지만 $Nlog N$인데?

다른 방식을 생각해보자.

---

length마다 최고값들이 있음.

이걸 segment tree를 쓴다면?

값 갱신 log N

---

7 7
4 5 6 6 5 7 4
5
6 6
5 6
3 5
3 7
1 7

1 7
3 5
3 7
5 6
6 6

---

seg fault

```
mo's algorithm 관해서 seg fault 안나려면
범위 증가 처리를 하고, 범위 감소 처리를 해야함.
```

만약 처음에 3 3 이야

그럼 값 가지고 있긴 함.

근데 6 6 나왔어.

---

시간초과?

segment tree를 쓰면 시간초과가 남.

---

solution

내가 모르겠는 부분

K개의 list의 back - front들 중 최대값 찾기 => sqrt decomposition

[참고](https://justicehui.github.io/ps/2019/10/04/BOJ13546/)

sqrt decomposition을 이용하면 $O(\sqrt N)$ 처리가 가능하다.

근데 segment tree 쓰면 logN 처리가 가능한데 이게 더 빠른거 아닌가?

아! sqrt decomposition에서의 update는 $O(1)$ 이구나.

find는 $O(\sqrt N)$

list에는 N개 들어갈 수 있지.

기존 back - front를 prev, 현을 now라 한다면

prev 뺴주고, now 넣어주고.

해당 구간에 값이 있냐없냐, 그리고 구간 업데이트에 범위로 처리해야하는 게 따로 없다면 sqrt decomposition 앞으로 고려하자.