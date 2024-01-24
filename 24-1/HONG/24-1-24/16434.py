# 23.01.24 - 68퍼센트에서 실패함

def get_min_hp(attack, damage, health): # 10, 5, 101
  attack_cnt = health // attack
  if health % attack > 0:
    attack_cnt += 1 
  
  endure_cnt = attack_cnt - 1

  return endure_cnt * damage + 1

def fight(my_a, my_h, enemy_a, enemy_h):
  min_hp = get_min_hp(my_a, enemy_a, enemy_h)
  if my_h >= min_hp:
    return my_h - (min_hp-1)
  return 0

T, attack = map(int, input().split())

left = 1
right = int(1e16)
rooms = []

for _ in range(T):
  t, a, h = map(int, input().split())
  rooms.append((t,a,h))

while left <= right:
  mid = (left+right) // 2
  tmp_health = mid
  tmp_attack = attack
  result = 1

  for room in rooms:
    t, a, h = room
    if t == 1: # 스파링
      result = fight(tmp_attack, tmp_health, a, h)
      if result == 0: # 졌음 -> 체력 높이고 나가기
        left = mid + 1
        break
      tmp_health = result
    elif t == 2: # 물약
      tmp_health = tmp_health + h if tmp_health + h <= mid else mid
      tmp_attack += a
  
  if result == 0:
    continue
  
  if tmp_health > 0: # 정답
    right = mid - 1
  else:
    left = mid + 1

print(right + 1)