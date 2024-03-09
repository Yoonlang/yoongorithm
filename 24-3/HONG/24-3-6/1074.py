'''
#1:20:02
문제이해 3분정도.

풀이는.. 재귀인건알겠음.
#1:05:50

# 제출 57:34 -> 정답

23분걸리노!
'''

N, r, c = map(int, input().split())

def dfs(size, r, c, answer):
  if size == 1:
    print(int(answer))
    return

  mid = size / 2

  blocks = size**2 // 4

  if 0 <= r < mid and 0 <= c < mid: # 1사분면
    dfs(mid, r, c, answer + (0 * blocks))
  elif 0 <= r < mid and mid <= c < size: # 2
    dfs(mid, r, c - mid, answer + (1 * blocks))
  elif mid <= r < size and 0 <= c < mid: # 3
    dfs(mid, r - mid, c, answer + (2 * blocks))
  elif mid <= r < size and mid <= c < size: # 4
    dfs(mid, r - mid, c - mid, answer + (3 * blocks))

dfs(2**N, r, c, 0)