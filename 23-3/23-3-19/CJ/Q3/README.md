## First Memo

Trying to find a point in the middle

life : [2, 1_000_000]
happiness : [0, 1_000_000_000]
fatigue : [0, 1_000_000_000]

if happiness and fatigue is not 0, the other values are all unique

if value is zero, it can be treated as any value (while being unique)

happy day should be higher than other days

tiring day should be lower than other days

Some sort of grouping

My Attempt:

1. sort descending with happiness
2. sort accending with fatigue

nope the above is dumb

1. sort descending with happiness
2. loop through fatigue until descending happens

Main thing is to deal with 0s

- What to keep track of
  - highest

Let's not think about the zeros, let's think that all zeros are filled up

- If the list is sorted with happiness
- I have to know highest sad and lowest sad of A[1, k] and B[k + 1, N]
- if **the highest sad of A** is higher than **the lowest of B**, that division is wrong, probably should stop.

## Finished in > 4:00:00

First, I thought I had to sort the list, but I didn't need to. The input sequence what I should work with.

Secondly, I thought the 0s needed to be filled with positive _integers_. I used `set` to keep track of all the "used/usings" numbers. I got TLE. However, the 0s can be positive _real_ numbers. Even if there is 1 given as a input, the 0s can be set to 0.1, 0.01, 0.001 and so on. Which means, I don't have to keep track of all the numbers that are used. I could just put the biggest numbers and smallest numbers to the 0s.
