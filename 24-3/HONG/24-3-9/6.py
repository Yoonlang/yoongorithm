'''
스텝별로 방향을 잘 정하는게 필수다.
'''

dx, dy = [1, 0, -1, 0], [0, 1, 0 -1] # 동, 남, 서, 북
dir_map = [
    [1,3],
    [0,2],
    [1,3],
    [0,2]
]

def solution(cells):

    row = len(cells)
    col = len(cells[0]) 

    def dfs(cy, cx, start, visited, step, first_dir):

        dirs = range(4)
        if step == 2: dirs = dir_map[first_dir]
        elif step == 3: dirs = [first_dir]

        for i in dirs:
            ny = cy + dy[i]
            nx = cx + dx[i]
            if 0 <= ny < row and 0 <= nx < col and cells[ny][nx] == start:
                dfs(ny, nx, start, visited, step+1, first_dir)


    def solve():

        # 싹 다 돌아보자.

        for i in range(row):
            for j in range(col):
                start = cells[i][j]
                visited = [[0 for _ in range(col)] for _ in range(row)]
                visited[i][j] = 1
                dfs(i, j, start, visited, 1, 0)

    return -1

    return solve()