N = 5

for i in range(0, N-2):
  for j in range(i+1, N-1):
    for k in range(j+1, N-0):
      print(f'({i}, {j}, {k})')

def combinations(n,c):

  def combine(comb, start):
    if len(comb) == c:
      print(comb)
      return
    
    for i in range(start, n+1):
      comb.append(i)
      combine(comb, i+1)
      comb.pop()
  
  combine([], 1)

combinations

def permutates(n,c):

  used = [0] * (n+1)
  def permute(perm):
    if len(perm) == c:
      print(perm)
      return
    
    for i in range(1, n+1):
      if used[i]: continue
      used[i] = 1
      perm.append(i)
      permute(perm)
      used[i] = 0
      perm.pop()
  
  permute([], 1)

permutates(3, 3)

# 중복순열
def permutations_duplicated(n, p):
  def permutate(arr):
    if len(arr) == p:
      print(arr)
      return
    for i in range(1, n+1):
      arr.append(i)
      permutate(arr)
      arr.pop()
  permutate([], 1)