'''
모든 연결구간을 방문하고싶다.
-> 오일러 경로! (회로아님)
-> 차수가 없을 때, 오일러 경로의 조건
-> 1. 2개의 정점은 홀수 엘지, 나머지 정점은 짝수 엣지
-> 2. 모든 정점의 엣지가 모두 짝수
-> 3. 모두 연결되어있어야함.
'''
from collections import deque

def solve():

  # 1. 연결되어있는지 확인.
  visited = [0] * (V+1)
  visited[1] = 1
  queue = deque([1])
  while queue:
    current = queue.popleft()
    for neighbor in graph[current]:
      if not visited[neighbor]:
        queue.append(neighbor)
        visited[neighbor] = 1
  
  if len(visited) != V:
    return "NO"
  
  # 2. 홀수와 짝수 엣지 확인
  odd_edges = 0
  for i in range(1, V+1):
    if len(graph[i]) % 2 == 1:
      odd_edges += 1
  
  if odd_edges == 2 or odd_edges == 0:
    return "YES"
  
  return "NO"

V, E = map(int, input().split())
graph = [[] for _ in range(V+1)]

for _ in range(E):
  s, e = map(int, input().split())
  graph[s].append(e)
  graph[e].append(s)

print(solve())