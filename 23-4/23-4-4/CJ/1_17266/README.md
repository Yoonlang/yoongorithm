## Finished in 0:27:53

mehhhhhhh

It was a pretty easy problem, but I struggled a lot.

The edge case for me was when previous light with height H and current light with height H cannot cover the road between.

Firstly, I thought just setting the height H to the distance between the well lit point to the current light.

However, that was wrong. Because, increasing H means the previous light can cover more distance.

Therefore, I had to subtract the distance between previous light and current light and divide it by 2.

And now comes the other problem.

I should not just divide it by 2, but I should have ceil the result.

Again, easy problem, but I struggled badly.
