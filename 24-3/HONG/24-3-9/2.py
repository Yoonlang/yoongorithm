'''
1. 학점 - split
2. 직선거리 - 피타고라스
3. 사전순
'''
def solution(names, homes, grades):
    order = list(range(1, len(names)+1))
    arr = list(zip(names, homes, grades, order))
    convert = sorted(arr, key=lambda x: (-int(x[2]), -(x[1][0]**2 + x[1][1]**2), x[0]))

    neworder = list(range(len(names)+1))
    for i, e in enumerate(convert):
        neworder[e[3]] = i+1

    return neworder[1:]