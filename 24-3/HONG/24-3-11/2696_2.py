'''
파이썬 heapq는 기본적으로 minHeap
뽑을때마다 최소값이 나옴.
'''

def get_min(arr):
  return arr[0]

def get_max(arr):
  return -arr[0]

def push_min(arr, val):
  heappush(arr, val)

def push_max(arr, val):
  heappush(arr, -val)

def pop_min(arr):
  return heappop(arr)

def pop_max(arr):
  return -heappop(arr)

from heapq import *

T = int(input())

for _ in range(T):
  N = int(input())
  result = []
  small, big = [], [] # maxHeap, minHeap
  for i in range(N):
    if i % 10 == 0:
      arr = list(map(int, input().split()))
    val = arr[i % 10]

    if i == 0:
      push_max(small, val)
      result.append(get_max(small))
    elif i % 2 == 0:
      _max = get_max(small)
      if _max < val:
        push_min(big, val)
        result.append(get_min(big))
      else:
        push_max(small, val)
        result.append(get_max(small))
    elif i % 2 == 1: # 1번째, 3번째.. 일때
      _max = get_max(small)
      if _max < val:
        push_min(big, val)
      else:
        push_max(small, val)

      # 길이교정
      if len(small) < len(big): # big이 2개 더 많음
        push_max(small, pop_min(big))
      elif len(small) > len(big): # small이 2개 더 많음
        push_min(big, pop_max(small))
      else: # 같은경우는 패스해도됨
        pass

  print(len(result))
  for i, val in enumerate(result):
    print(val, end=" ")
    if i % 10 == 9:
      print("")
  print("")


# 1
# 21
# -100 -9 -8 -7 -6 -5 -4 -3 -2 -1
# -1 -2 -3 -4 -5 -6 -7 -8 -9 -10
# -99

# 1
# 23
# 23 41 13 22 -3 24 -31 -11 -8 -7
# 3 5 103 211 -311 -45 -67 -73 -81 -99
# -33 24 56
  
# 1
# 42
# 1 2 3 4 5 6 7 8 9 10
# 11 12 13 14 15 16 17 18 19 20
# 21 22 23 24 25 26 27 28 29 30
# 31 32 33 34 35 36 37 38 39 40
# 41 42