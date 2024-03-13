'''
다이나믹 프로그래밍은 역시 점화식을 떠올리는게 어렵다.
그래도 조금 방향 빠르게 잡는방법
1. DP[X][Y]를 정의하자.
- X의 매개변수는 어떤게 오는지,
- Y의 매개변수는 어떤게 오는지,
- 결국 DP[X][Y]값은 어떤걸 의미하는지를 이해해야한다.

2. For문을 돌리자.
- 일단 매개변수가 2개이기 때문에 2중반복문일 경우가많다.
- 항상 조건이 추가되기 때문에, 반복중에 if문을 잘 걸어주자.
'''
N = int(input())

HP = list(map(int, input().split()))
JOY = list(map(int, input().split()))

DP = [[0] * N for _ in range(101)]

DP[0][0] = 0
DP[HP[0]][0] = JOY[0]

for i in range(1, N):
  for hp in range(0, 100):
    DP[hp][i] = max(DP[hp][i], DP[hp][i-1])
    if hp + HP[i] < 100:
      DP[hp + HP[i]][i] = max(DP[hp + HP[i]][i], DP[hp][i-1] + JOY[i])

answer = 0
for i in range(1, 100):
   answer = max(answer, DP[i][N-1])
  
print(answer)