13925

long long이면 10억 * 10억 처리가 되나? ㅇㅇ 되네.

그냥 단순히 seg tree with lazy propagation 아닌가?

쉬워보이는데 왜 플레 1이지?

seg[root] tuple<int, int, int, int>

현재 값, 더해줄 값, 곱해줄 값, 그냥 넣을 값

어차피 값 추가될때마다 MOD 떄려주면 됨.

action 1 : +

action 2 : *

action 3 : =

잠깐 queue 방식도 생각해봤는데.. 사실 queue 방식이 맞는거같은데.

만약 queue 방식 안쓰려면. 자식에 다른 action이 투입되어 있다면 그거 먼저 처리하고 넘어가는게 맞음.

queue 방식의 문제는 같은 action의 중복에 대한 처리를 못한다는 거임.

+1, +1 ... 쭉 되어있는걸 한방에 연산을 못해.

좀 귀찮더라도 직접 처리해주는 로직 짜는게 맞는듯.

직접 짜는 로직으로 대충 그려봤는데

처리해준걸 또 처리해주고 계속 타고타고 내려가는 일이 발생할거같아서

deque 쓰는 방향으로 생각.

deque 쓸 때는 최악의 상황이 머지?

플 곱 플 곱 플 곱 ... 이렇게 들어오면?

출력 쿼리 하나당 N 가능인데?

단순 deque 쓰면 시간초과 맞기 딱 좋음. 함정인듯.

---

또 잠깐 든 생각인데

MOD 특성 중에 그런거 있는거 아니야? 둘 중에 머 먼저 처리해도 괜찮은.. 이런거 없나? 아니면 + 한거에다가 곱하기 처리 따로 또 해주면 되려나

아니면 lazy propagation 내려갈 때는 현재값, +에 곱해주는 형태로 내려가면?

곱하기를 현재 값에, 더하기 값에 해주면 안되나?

이번에 곱하기가 나왔다는 의미는

원래는 더할거 처리해주고, 곱해줘야함.

근데 곱하기도 그냥 범위로 두려면 어떻게 처리해야할까?

당장 seg[root] 하나만 보자면 현재값, +값 각각 곱해줘도 문제는 없음

그러면 1차적으로는 냅둔다 치자.

다음에 곱하기 또 들어오면? 걍 곱하기에 곱하기 해주면 그만.

곱하기가 있는 상태에서 더하기가 들어오면?

얘는 문제가 발생할 수 있음. 따라서 곱하기 처리 다 해주고 더하기만 존재해야함.

곱해줘야할 값을 더하기로 승화시키는건 불가능함.

시점을 바꿔야하나

현재값에 곱해줘야할 수도 추가하면? 어차피 추가로 더해줘야할 값에는 곱해서 처리해도 전혀 문제 없잖아.


---

a, 0, 0, 0 이다

곱하기가 0이면 더하기는 얼마든지 추가 가능.

곱하기는 더하기가 있어도 냅다 곱해도 됨.

곱하기가 0이 아니면 ? 더하기는 지장이 생김

그래서 결과 처리해주고 lazy propagation 하는건데.

현재꺼에 더해주고, 곱하기 해주고. 내려주는 로직만 제대로 짜면 됨.

내려갈때 문제되는 케이스가 머지?

위에서 + 내려줄 때

밑에 곱하기가 있으면 문제가 됨. 처리 해줘야한다.

이게 또 문제가 되는게 머냐면

밑에 한줄로 쫙 곱하기가 있고, 위에서 + 내려주면 타고타고 O(N)이 되어버림.

깔끔하게 해결할 방법이 없을까?

밑에거 형태가 어떻든 내려보내기만 하면 해결되는 무적의 방법?

---

solution

tuple<int, int, int>

현재값, a, b

해당 범위 = 현재값 * a + b

lazy update 생각해보면

더하기, 곱하기 둘 다 있을 땐 머부터 처리하는게 맞을까?

값이랑 lazy 쪽이랑 완전 별개로 생각하는구나.

[참고](https://justicehui.github.io/ps/2019/06/14/BOJ13925/)

