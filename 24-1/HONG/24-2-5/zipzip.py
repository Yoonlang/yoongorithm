'''
zip의 기본개념: 순서를 매칭해준다.
'''
zipp = zip([1,0,-1,0],[0,1,0,-1])

for a in zipp:
  print(a)


zippp = zip([1,2,3,4, 5], ['a','b','c','d'])

for e in zippp:
  print(e)

# 0이면 -> 빈공간 (체크리스트)
# 1이면 -> 치즈 (멜팅)