## Finished in 0:40:00

Well, the first thing poped up in my head about prime was erasthosthenes sieve.

However, using erasthosthenes sieve with the problem's input exceeded the memory limit.

So, I had to find another way to solve the problem.

I thought of just checking if the number is prime or not, but that would be too slow.

However, it turns out to be the only solution.

The time complexity of the solution was just O(k \* sqrt(n)) (where k is interval between primes, expected to be not that big).

Another thing that I missed was that the input overflows int range.

I had to use long long instead.
