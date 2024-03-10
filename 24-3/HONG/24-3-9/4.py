def solution(gold_prices):
    answer = -1

    gold_prices.insert(0,0)
    acc_prices = [0] * len(gold_prices)
    for i in range(1, len(gold_prices)):
        acc_prices[i] = acc_prices[i-1] + gold_prices[i]

    def dfs(total, step, gold, canbuy):
        nonlocal answer
        nonlocal acc_prices

        if step == len(gold_prices):
            answer = max(total, answer)
            return

        # 현재 최대이윤이랑 남아있는돈 비교
        # if answer > (total + acc_prices[-1] - acc_prices[step-1]):
        #     return

        # 사자 (전날 팔면 안되었음)
        if canbuy:
            # print(' ' * step, end='')
            # print(f'구매. 가격={gold_prices[step]}, 이윤={total}')
            dfs(total, step+1, gold_prices[step], False)

        # 팔자
        if gold != 0:
            dfs(total+(gold_prices[step]-gold), step+1, 0, False)

        # 그냥가자
        dfs(total, step+1, gold, True)

    dfs(0, 1, 0, True)

    return answer