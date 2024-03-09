'''
start 56:11 
fail 27:39
restart 25:29
test 7:50
submit 2:30
success 
'''

N = int(input())
arr = list(map(int, input().split()))

from collections import deque # stack

def solve():
  if len(arr) % 2 == 1: return -1
  answer = 0
  stack = []
  idx = 0
  while True:
    if len(stack) > 0 and arr[idx] == stack[-1]:
      while stack:
        popped = stack.pop()
        if arr[idx] != popped:
          return -1
        if len(stack) > 0: idx += 1 # 조건추가
      answer += 1
    else:
      stack.append(arr[idx])
    idx += 1
    if idx >= N : break
  return answer

print(solve())


      
