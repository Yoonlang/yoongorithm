from collections import deque

def bfs(graph, start):

  visited = [0] * (V+1)
  queue = deque([start])

  while queue:
    current = queue.popleft()
    for neighbor in graph[current]:
      if not visited[neighbor]:
        queue.append(neighbor)
        visited[neighbor] = 1
  
  return sum(visited) == V

def check_euiler_trail(graph):

  # check connected first
  if not bfs(graph, 1):
    return 0

  edges = [len(graph[i]) for i in range(1, V+1)]
  cnt_odd = sum(1 for x in edges if x % 2 == 1)

  return 1 if cnt_odd in [0, 2] else 0

graph = [[] for _ in range(3001)]
V, E = map(int, input().split())

for _ in range(E):
  s, e = map(int, input().split())
  graph[s].append(e)
  graph[e].append(s)

result = check_euiler_trail(graph)

if result:
  print("YES")
else:
  print("NO")