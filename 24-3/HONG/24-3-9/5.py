'''
부분합문제긴한디

1. 부분합 구하기
2. 전부다 더해서 나누기 3, -> target
3. target을 만족하는 x 구하기
4. target을 만족하는 y 구하기 -> 나머지는 자동으로 구해짐

'''
from itertools import combinations

def solution(foods):
    foods.insert(0, 0)

    sum_foods = [0] * len(foods)
    for i in range(1, len(foods)):
        sum_foods[i] = foods[i] + sum_foods[i-1]

    total = sum_foods[-1]

    if total % 3 != 0: return 0

    target = total // 3

    # target을 만족하는 x, y 구하기

    answer = 0
    for x, y in combinations(range(1, len(foods)-1), 2):
        sum_a = sum_foods[x] - sum_foods[0]
        if sum_a != target: continue
        sum_b = sum_foods[y] - sum_foods[x]
        if sum_a != target: continue
        sum_c = total - sum_a - sum_b
        if sum_c != target: continue

        answer += 1

    return answer
