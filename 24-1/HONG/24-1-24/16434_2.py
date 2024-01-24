'''
3 3
1 1 20
2 3 10
1 3 100
'''
import math

N, attack = map(int, input().split())

requiredHP, minHP = 0, 0

for _ in range(N):
  t, a, h = map(int, input().split())
  if t == 1: # fight
    requiredHP += (math.ceil(h / attack) - 1) * a
    minHP = max(minHP, requiredHP)
  else: # portion
    requiredHP -= h
    attack += a
    if requiredHP < 0:
      requiredHP = 0

print(minHP + 1)

'''
  1. 
  죽었다고 해서, for문을 나갈필요 없다.
  max로 계속 업데이트 해주면 되기 때문이다.

  2. 
  나의 접근: 검증
  (1) 랜덤한 HP 를 설정해두고, 
  (2) 그 HP 가 맞는지를 검증. 
  (3) 그 대신, 검증하는 과정을 이분탐색으로 활용했음.

  상대방의 접근: 계산
  (1) 랜덤하게 HP 를 설정하지 않았음.
  (2) 그대신, 필요한 로직을 하면서 HP를 계산하였음. (이런경우가 없지도 않을까..)
  (3) 한번 정해진 HP를 검증하는게 아니라, 계속 업데이트했음.

'''