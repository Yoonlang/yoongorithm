# union find
# start 07:27 

def find(current):
  global parents
  if current == parents[current]: return current
  parents[current] = find(parents[current])
  return parents[current]

def union(a, b): # assign parent
  global parents
  A = find(a)
  B = find(b)
  if A < B: parents[B] = parents[A]
  else: parents[A] = parents[B]

N = int(input())

parents = list(range(N+1))

for _ in range(N-2):
  s, e = map(int, input().split())
  union(s,e)


for i in range(1, N+1):
  parents[i] = find(i)

for i in range(2, N+1):
    if parents[i] != 1:
      print(1, i)
      break
