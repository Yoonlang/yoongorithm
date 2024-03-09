'''
사이클 중에서, 최단거리 사이클 찾기
-> 사이클을 찾으면서 최단거리 업데이트

두 마을을 왕복해도 사이클임.

방향그래프에서 사이클 쉽게 찾는방법 있나?
'''

V, E = map(int, input().split())

graph = [[0 for _ in range(V+1)] for _ in range(V+1)]

for _ in range(E):
  s, e, c = map(int, input().split())
  # graph[s].append((e,c))
  graph[s][e] = c

def solve():

  answer = int(1e10)
  cycle_nodes = set()

  def get_dist(cycle):
    dist = 0
    length = len(cycle)
    for i in range(0, length-1):
      dist += graph[cycle[i]][cycle[i+1]]
    return dist

  def dfs(current, dist, trail):
    nonlocal answer
    nonlocal cycle_nodes

    if dist > answer:
      return

    if visited[current] >= 2:
      cycle = trail[trail.index(current):]
      cycle_nodes.update(cycle)
      answer = min(get_dist(cycle), answer)
      return

    for neighbor in range(1, V+1):
      if graph[current][neighbor] == 0: continue
      cost = graph[current][neighbor]
      visited[neighbor] += 1
      trail.append(neighbor)
      dfs(neighbor, dist + cost, trail)
      visited[neighbor] -= 1
      trail.pop()

  for i in range(1, V+1):
    if i in cycle_nodes: continue
    visited = [0] * (V+1)
    visited[i] = 1
    dfs(i, 0, [i])
  
  if answer == int(1e10):
    print("-1")
  else:
    print(answer)
  
solve()