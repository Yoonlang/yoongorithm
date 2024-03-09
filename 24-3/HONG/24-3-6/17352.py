'''
연결그래프인지 확인하는 문제.
연결 그래프를 확인하는 방법
1. BFS : 노드 갯수를 확인
2. DFS : 노드 갯수를 확인

Q. 무엇이 더 빠를까?
-> 문제 유형마다 다르다.


BFS
1. 인접리스트로 구현한경우
  - 각각의 노드 V 에 대해서, 엣지를 확인한다. E => VE
2. 인접행렬로 구현한경우
  - 각각의 노드 V 에 대해서, 엣지를 확인한다. V => VV
레벨별로 순차적으로 탐색하기 때문에, 가까이 있는 노드를 먼저 탐색하는 최단거리 문제에서 활용하기 좋다.

DFS
1. 인접리스트
  - 이것도 VE 아닌가 싶네. -> 확인
2. 인접행렬
  - VV이다.
깊이있게 먼저 탐색하기 때문에, 백트래킹, 모든 해를 찾는 문제등에서 활용된다.

BFS / DFS 중 뭐가 더 빠른진 모르겠다.
그리고, Dense 하지 않은 그래프이기 때문에 (엣지가 N-1개)
인접리스트로 관리하는게 좋아보인다.

시간복잡도 = BFS 인접리스트로 구현 * 모든 케이스 확인 NC2
= V*V*V*V.... =V^4? 

말이안된다.

=> 그냥 탐색한번 돌린후, visited에 없는 친구 하나만 아무거나 연결시켜주면됨!


# 
'''

# 시작: 1:51:43

from collections import deque

N = int(input())

graph = [[] for _ in range(N+1)] 
for _ in range(N-2):
  s, e = map(int, input().split())
  graph[s].append(e)
  graph[e].append(s)

visited = [0] * (N+1)
visited[1] = 1

def dfs(current):
  for neighbor in graph[current]:
    if not visited[neighbor]:
      visited[neighbor] = 1
      dfs(neighbor)

def bfs(start):

  queue = deque([start])
  while queue:
    current = queue.popleft()
    for neighbor in graph[current]:
      if not visited[neighbor]:
        visited[neighbor] = 1
        queue.append(neighbor)

# dfs(1)
bfs(1)

lonely = 1
for idx, val in enumerate(visited):
  if idx != 0 and val == 0:
    lonely = idx
    break

if lonely == 1:
  print("1 2")
else:
  print(f'1 {lonely}')

# 1:44:30 - 1트
# 1:24:55 - 마지막
# 디버깅시간: 20분! 습관적으로 타자치지말자.