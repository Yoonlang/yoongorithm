
'''
총 경우의수 : 4^20 == 2^40 == 10^12! / 2초는 2억번가능 (2*10^10)
-> 백트래킹을 한번 해보자.
-> 백트래킹의 조건이 뭐가있을까?
-> 이전에 나온게 있으면 안됨.
1
  1 -> 2
  5 -> 6
  10 -> 11
  50 -> 51
5
  5 -> 10
  10 -> 15
  50 -> 55
10
  10 -> 20
  50 -> 60
50
  50 -> 50

'''

N = int(input())

_set = set()
arr = [1,5,10,50]

def dfs(depth, start, sum):
  if depth == N:
    _set.add(sum)
    return
  
  for i in range(start, 4):
    dfs(depth+1, i, sum+arr[i])

dfs(0, 0, 0)

print(len(_set))