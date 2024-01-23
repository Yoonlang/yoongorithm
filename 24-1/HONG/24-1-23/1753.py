import heapq

V, E = map(int, input().split())
S = int(input())

def dijkstra(start):

  distances = [int(1e9) for _ in range(V+1)]
  distances[start] = 0

  pq = [(0, start)]
  
  while pq:

    current_dist, current_node = heapq.heappop(pq)

    if current_dist > distances[current_node]:
      continue

    for neighbor, weight in graph[current_node]:
      distance = weight + distances[current_node]
      if distance < distances[neighbor]:
        distances[neighbor] = distance
        heapq.heappush(pq, (distance, neighbor))
  
  return distances

graph = [[] for _ in range(V+1)]

for _ in range(E):
  s,e,c = map(int, input().split())
  graph[s].append((e,c))

result = dijkstra(S)

for num in result[1:]:
  if(num == int(1e9)):
    print('INF')
  else:
    print(num)