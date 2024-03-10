def solution(n, k):
    answer = 0
    # a1, a2, a3,,, ak 의 합이 N이고
    # a1 < a2 < a3 인 경우의 수

    def dfs(total, step, start):
        nonlocal answer
        if total > n: return # ?

        if step == k:
            if total == n: # 최적화 가능할듯
                answer += 1
            return

        for jump in range(start, k-step-1, -1): 
            dfs(total + jump, step+1, jump-1)

    dfs(0, 0, n-k+1)

    return answer % 1000000007

print(solution(10,5))
