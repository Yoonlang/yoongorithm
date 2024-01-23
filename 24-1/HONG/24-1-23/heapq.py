import heapq

pq = []

heapq.heappush(pq, 5)
heapq.heappush(pq, 3)
heapq.heappush(pq, 1)
heapq.heappush(pq, -10)

while pq:
  popped = heapq.heappop(pq)
  print(popped)


pq2 = []

heapq.heappush(pq2, (1,'c'))
heapq.heappush(pq2, (1, 'aaa'))
heapq.heappush(pq2, (2, 5))
heapq.heappush(pq2, (3, 5))

while pq2:
  popped = heapq.heappop(pq2)
  print(popped)
