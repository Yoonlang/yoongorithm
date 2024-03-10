def solution(n):

    def solve(n):
        arr = [0] * (n+1)
        squared = int(n**0.5)

        i = 1
        while True:
            if i > squared: break
            arr[i**2] = 1
            i += 1

        return sum(arr)   

    return solve(n)