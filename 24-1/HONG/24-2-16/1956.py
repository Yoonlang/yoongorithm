'''
사이클 중에서, 최단거리 사이클 찾기
-> 사이클을 찾으면서 최단거리 업데이트

두 마을을 왕복해도 사이클임.

방향그래프에서 사이클 쉽게 찾는방법 있나?

'''
V, E = map(int, input().split())

graph = [[] for _ in range(V+1)]

for _ in range(E):
  s, e, c = map(int, input().split())
  graph[s].append((e,c))

def solve():

  answer = int(1e10)

  def dfs(current, dist):
    nonlocal answer

    if dist > answer:
      return

    if visited[current] >= 2:
      answer = min(answer, dist)
      return

    for neighbor, cost in graph[current]:
      visited[neighbor] += 1
      dfs(neighbor, dist + cost)
      visited[neighbor] -= 1

  for i in range(1, V+1):
    visited = [0] * (V+1)
    visited[i] = 1
    dfs(i, 0)
  
  if answer == int(1e10):
    print("-1")
  else:
    print(answer)
  
solve()