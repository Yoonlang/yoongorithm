def get_combinations(n, c):
  # 1,2,3 => [1,2] [1,3] [2,3] 을 얻고싶다.
  combs = []
  def combine(start, comb):
    if len(comb) == c:
      combs.append(comb)
      return

    for i in range(start, n+1):
      combine(i+1, comb+[i])
  
  combine(1, [])
  return combs

def convert(string, combination):
  a = string[0:combination[0]]
  b = string[combination[0]:combination[1]]
  c = string[combination[1]:]
  return a[::-1]+b[::-1]+c[::-1]

def is_left_preceed(left, right):
  return left < right

original = input()

combinations = get_combinations(len(original)-1, 2)

answer = "z" * 50

for combination in combinations:
  converted = convert(original, combination)
  if is_left_preceed(converted, answer):
    answer = converted

print(answer)
