N = int(input())
arr = []

for _ in range(N):
  arr.append(int(input()))

# 배열 뒤에서 검색하기
i = len(arr) - 1 - 1 # 마지막원소는 굳이 안건드려도됨 / 뒤에서 2번째부터 시작

ans = 0
while i >= 0:

  left = arr[i]
  right = arr[i + 1]

  if left >= right:
    tobe = right - 1
    ans += (left - tobe)
    arr[i] = tobe

  i -= 1

print(ans)

'''
3
5
5
5
-> 3 4 5 로 만들어야함
-> 2 1 0 = 3

4
5
3
7
5
-> 2 3 4 5 로 만들어야함
-> 3 0 3 0 = 6

1
1
-> 0

2
30
2
-> 1 2 로 만들어야함
-> 29 0 = 29

'''