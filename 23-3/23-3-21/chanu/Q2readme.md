### 풀이

시간 복잡도 O(n)

n이 30만이기 때문에 무조건 nlogn 이하는 맞춰주어야한다.

연속된 k 접시 안에서 먹을 수 있는 초밥의 종류 + 쿠폰 초밥의 최대값을 구하면된다

1. 일단 K개의 초밥 종류를 맵에 넣는다
2. 배열울 쭉 순회한다
   1. 새로운 초밥을 넣고 
   2. 오래된 초밥을 뺸다 ex) x x x 오 1 2 3 새 x x x
   3. 해당 행위를 한 후 초밥 개수를 센다 + 쿠폰 초밥이 포함되었는지 센다
   4. 계산해서 맥스값 갱신한다


### 초밥 종류 세기에 대해

초밥의 종류를 세는 것은 map을 사용한다 (set을 고민했지만 중복을 허용한다. 만약 중복된 초밥을 빼는 경우라면 종류에서 초밥을 제외해야하는지 가만둬야하는지 알수 없다 개수를 모르기때문에 ex 2 2 1 1)

map(key: 초밥넘버, value: 초밥 개수)

개수가 0이되면 맵에서 삭제한다 -> size로 종류를 파악하기 위해.

삭제하지않으면 맵 순회를돌아 파악해야하는데 그러면 터진다

### 쿠폰 추가에 대해
맵을 관리하고있으면 쿠폰초밥이 맵에 포함되어있는지 찾는건 그냥 easy,.
찾아서 함께 맥스값 갱신 라인에 추가한다


### 회전 엣지 케이스
회전이기 떄문에 food[n-1] -> food[0] 로 돌아야함
- 엣지 케이스 나올 수 있음

-> k만킁 앞의 배열을 뒤에다가 붙여준다 foods[i] = foods[n-i] for n~n-k
key(번호) : value
