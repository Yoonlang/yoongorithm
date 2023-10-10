# 0 1 2 3 4
# 0 1 1 2 3

n = int(input())

pp = 0
p = 1
ans = 1

if n == 0:
  print(0) 
elif n == 1:
  print(1)
else:
  while(n-2 >= 0):
    ans = pp + p
    pp = p
    p = ans
    n -= 1
  print(ans)