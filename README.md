# Journey to the Moon

The problem derives from hackerrank:

https://www.hackerrank.com/challenges/journey-to-the-moon


People are preparing to send 2 astronauts to the Moon, with condition that each is from different country. How many pairs are available to pick?

Let's assume that initially all astronauts are from different countries. Every two candidates could be associated meaning they are from the same country.

----

## Input

N - total number of candidates
i,j - association of candidate _i_ with candidate _j_, meaning they are from the same country.

### Example Input

```
6
0 2
2 1
3 4
5 4
```
6 candidates, candidates 0, 1, 2 are from the one country; candidates 3, 4, 5 are from another.

## Output

K - number of possible pairs of candidates.

### Output example

```
9
```

### Explanation

Following 9 pairs of candidates are available: 
```
0 3
0 4
0 5
1 3
1 4
1 5
2 3
2 4
2 5
```

### Solution
 - Simple union find 
 - Combinatorics (pairs count between disjoint set elements)