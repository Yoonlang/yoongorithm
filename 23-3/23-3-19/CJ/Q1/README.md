## First Memo

elements: [1, 15_000]
armor: [1, 10_000_000]
element_numbers: [1, 100_000]

sorting problem?

## Finished in 0:18:06

I first thought it was dp problem, made cache of 15_001 \* 10_000_001.

My Macbook Air crashed.

So, I thought there will be a better solution, I thought of sorting.

Then, I looped over the elements tried to find if there was a pair.

By the way, this problem was freaking hard to understand.

All the element number was unique, and armor can only be made with _two_ elements.

I missed the fact that the all element was unique, I didn't check the condition of when to break. _THE EQUAL sign @ LINE 32_.

One another odd thing about this problem is that, the range of element is [1, 100_000] which then can add upto 199_999 but armor range is [1, 10_000_000], WTF?

Now that I think of it, I think this problem tried to eliminate the possiblity of dp solution.
