import heapq
T = int(input())

for _ in range(T):
  N = int(input())
  arr = list(map(int, input().split()))
  brr = []

  i = 0
  while i < N:
    heapq.heappush(brr, arr[i % 10])
    print('brr',brr)
    if i % 2 == 0: 
      print(brr[i // 2], end=" ")
    if i % 10 == 9:
      arr = list(map(int, input().split()))
      print("")
    i += 1