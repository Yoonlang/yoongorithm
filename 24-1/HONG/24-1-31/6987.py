'''
1 1 3 4 4 -> 13
2 3 5 3 -> 13


# 무는 짝수이며, cnt(무) / 2 만큼 column 승, column 패에서 빼야함
# 무의 합은 항상 짝수이며, 한 팀이 2무를 할 수 없다.
# 1. 각 행의 합은 5 여야함
# 2. 무
# 2-1. 무의 합은 항상 짝수이다.
# 2-2. 무 중 하나가 2이상인경우, 대응되는 다른팀과의 경기가 있어야한다.
#   N인경우 -> 다른팀들의 무승부1 카운트가 N이어야함 (N >= 2)
# 3. 각 열의 합은 15 - sum(무)/2 여야 한다.
'''

def is_valid_game(arr):
  # 1번
  for i in range(6):
    if sum(arr[i]) != 5:
      return 0
  
  # 2번
  n_index = -1
  sum_tie = 0
  for i in range(6):
    sum_tie += arr[i][1]
    if arr[i][1] >= 2:
      n_index = i
  if sum_tie % 2 != 0:
    return 0
  
  if n_index != -1:
    cnt_tie_morethan_two = arr[n_index][1]
    cnt_cmp = 0
    for j in range(6):
      if j == n_index:
        continue
      if arr[j][1] == 1:
        cnt_cmp += 1
    
    if cnt_tie_morethan_two != cnt_cmp:
      return 0
  
  # 3번
  expected_col_sum = 15 - (sum_tie // 2)
  for i in range(3):
    if i == 1:
      continue
    col_sum = 0
    for j in range(6):
      col_sum += arr[j][i]
    
    if col_sum != expected_col_sum:
      return 0

  return 1

result = []

for _ in range(4):
  tmp_arr = list(map(int, input().split()))
  
  arr = []
  sub_arr = []
  for i in range(0, 18):
    sub_arr.append(tmp_arr[i])
    if i % 3 == 2:
      arr.append(sub_arr)
      sub_arr = []
  
  result.append(str(is_valid_game(arr)))

print(" ".join(result))