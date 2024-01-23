import heapq

V, E, P = map(int, input().split())

def dijkstra(start):

  distances = [int(1e10)] * (V+1)
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
  start, end, cost = map(int, input().split())
  graph[start].append((end, cost))
  graph[end].append((start, cost))

# save him = 1 to P + P to V
# go straight = 1 to V
result_from_S = dijkstra(1)
result_from_P = dijkstra(P)

if result_from_S[V] >= result_from_S[P] + result_from_P[V]:
  print("SAVE HIM")
else:
  print("GOOD BYE")
