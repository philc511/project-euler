# Did this mostly by hand to derive a formula
# 1 + sum (4*n*n + n + 1) from n to 1,2,3...
# eg n=2 for a 5x5 grid
# (5x5 grid contains central digit 1 then
# two layers, each with 4 diagonal numbers separated
# by 2*n, ie 3,5,7,9, then 13,17,21,25
# Using formulas for sum(n) and sum(n*n) can end up with
# 16*n*n*n/3 + 10*n*n + 26*n/3 + 1

size = 1001
n = (size-1)/2
puts (16*n*n*n + 30*n*n + 26*n + 3)/3