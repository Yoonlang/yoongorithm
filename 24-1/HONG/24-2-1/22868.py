'''
3 3
1 2
1 3
2 3
1 2
>> 3 correct 
>> 2 wrong 
'''

import heapq

def get_visited_nodes(paths, current):
  visited = []
  current = paths[current]
  while current != 0:
    visited.append(current)
    current = paths[current]
  return visited[:-1] # except start node

def get_visited_trails(paths, current):
  visited = []
  while paths[current] != 0:
    visited.append({current, paths[current]})
    current = paths[current]
  return visited

def dijkstra(graph, start, visited_trails, visited_nodes):

  paths = [0] * (N+1)
  distances = [int(1e10)] * (N+1)
  distances[start] = 0

  pq = [(0, start)]

  while pq:
    cur_distance, cur_node = heapq.heappop(pq)
    for neighbor, weight in graph[cur_node]:
      distance = cur_distance + weight
      if distance < distances[neighbor] and not { cur_node, neighbor } in visited_trails and not neighbor in visited_nodes:
        distances[neighbor] = distance
        heapq.heappush(pq, (distance, neighbor))
        paths[neighbor] = cur_node
  
  return distances, paths

N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]

for i in range(M):
  s, e = map(int, input().split())
  graph[s].append((e,1))
  graph[e].append((s,1))
S, E = map(int, input().split())

distances1, paths1 = dijkstra(graph, S, [], [])
distances2, paths2 = dijkstra(graph, E, get_visited_trails(paths1, E), get_visited_nodes(paths1, E))


print(distances1[E] + distances2[S])