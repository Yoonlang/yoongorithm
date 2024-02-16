N, M, H = map(int, input().split())

ladder = [[0 for _ in range(N+1)] for _ in range(H+1)]

for _ in range(M):
  y, x = map(int ,input().split())
  ladder[y][x] = 1

def check():
  for col in range(1, N):
    current = col
    for row in range(1, H+1):
      if ladder[row][current] == 1:
        current += 1 # right
      elif ladder[row][current-1] == 1:
        current -= 1 # left
    if current != col:
      return 0
  return 1

def dfs(max, cnt, idx):
  global answer
  if max == cnt:
    if check():
      answer = cnt
    return
  
  for row in range(idx, H+1):
    for col in range(1, N):
      if ladder[row][col] or ladder[row][col+1] or ladder[row][col-1]: continue
      ladder[row][col] = 1
      dfs(max, cnt+1, row)
      ladder[row][col] = 0

answer = -1

for i in range(4):
  dfs(i, 0, 1)
  if (answer != -1): break

print(answer)


'''
백트래킹을 알아차리기 어려웠음
  - 백트래킹이란 한 집합에서 특정 조건을 만족하는 순열을 찾는 알고리즘
  - 기본적으로 완전탐색이지만, Prunning이 중요한 알고리즘
  - 일반적인 완전탐색(조합 모든 경우 돌리기의 경우)은 Prunning이 까다롭다.
  - 이 문제에서의 한 집합: 사다리를 놓을 수 있는 경우들의 집합
  - 이 문제에서의 특정 조건: 자기 자리에서 출발해서, 자기 자리로 돌아와야함.
  - 이 문제에서의 가지치기: 특정조건을 불만족하는 경우 + 인접하게 사다리를 놓을 수 없음.
백트래킹의 힌트
  - 트리를 DFS 탐색. 혹은, 아래로 뻗은 그래프를 DFS 탐색
  - 트리 형태로 모델링 하는것이 중요함.
    - 이 문제는 이차원배열형태
'''