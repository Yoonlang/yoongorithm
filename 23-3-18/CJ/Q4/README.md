# First Memo

building_types
buliding_relations
games
=> [1: 100_000]

for building_types lines
before -> after

for building_relations lines
1 (make) building
2 (destroy) building

King-God-Emperor
=> iff "built properly" || "destroy only the built"
Lier!
=> iff "built inproperly" || "destroy not yet built"

## Finished in 0:34:33

I got TLE for the first attempt.

I assumed there were some repeated computation of checking the already checked.

So, I added a additional arrays, `bool already_checked[100001];` along with `vector<int> build_precedents[100001];` for caching state of a checking prerequisites.

If destroying a `building` breaks the prerequisite, I invalidate the `already_checked` array for all `build_precedents[bulidng]` elements.
