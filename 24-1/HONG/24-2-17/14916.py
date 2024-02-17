n = int(input())

i = n // 5

while 0 <= i:
  tmp = n
  five = i
  tmp %= 5
  tmp += (5 * (n // 5 - i))

  two = tmp // 2
  tmp %= 2

  if tmp == 1:
    i -= 1
  else:
    break

if i < 0:
  print("-1")
else:
  print(five + two)
  
  