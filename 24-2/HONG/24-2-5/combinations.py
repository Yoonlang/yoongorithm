# n개 중에서 c개를 선택하는 경우의수
# 5개중에, 2개를 선택하면,
# 12/13/14/15/23/24/25/34/35/45 => 10개


def combinations(n,c):
  combs = []
  def combine(start, comb):
    if len(comb) == c:
      combs.append(comb)
      return

    for i in range(start, n+1):
      combine(i+1, comb + [i])
  
  combine(1, [])
  print(combs)

combinations(5,3)

for i in range(1,6):
  for j in range(i+1, 6):
    for k in range(j+1, 6):
      print((i,j,k))