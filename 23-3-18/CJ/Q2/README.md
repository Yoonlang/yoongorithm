## First Memo

from, to = [1, 1_000_000_000]

Just a brute force?

## Finished in 0:44:11

The parameter should have been set to `long long` not `int`.

When it was set to `int`, overflow happened and the early return conditions weren't detected throughly.
