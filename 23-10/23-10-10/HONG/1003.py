cnt0 = 0
cnt1 = 0

def fib(n):
  global cnt0, cnt1
  if n == 0:
    cnt0 += 1
    return 0
  elif n == 1:
    cnt1 += 1
    return 1
  else:
    return fib(n-1) + fib(n-2)

n = int(input())

for _ in range(n):
  num = int(input())
  fib(num)
  print(cnt0, cnt1)
  cnt0 = cnt1 = 0