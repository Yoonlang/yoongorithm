## First Memo

1. apply discount to k dishes in a row
2. one coupon of a sushi dish
   1. if a customer uses event #1, one free sushi dish
   2. if there is no sushi on the belt, chef makes new one

Input:

- dishes: [2, 3_000_000]
- sushis: [2, 3_000]
- discount_dishes: [2, 3_000]
- coupon: [1, sushis(3_000)]

make 2 \* dishes array, because it uses circular array

make discount_dishes long sequence, count unique sushis. coupon can be added also.

## Finished in 1:00:31

I used set and iterate every discount_dishes time. That caused TLE.

arr[3_000_000]? => counting unique sushis will be very expensive.

vector? => maybe making some sort of queue could work? However, finding and erasing particular sushi will be costly.

Let's go back to set, because finding and erasing sushi is very frequent.

But also check the amount of sushi types that are added. If the amount of a sushi type is 0, erase the sushi from the set. And that seems to work. Only adds (\*) O(log N) time complexity.

I got off by one error when computing "next dish to add". But, I catched that pretty early, so didn't waste that much time.
