def gen_pairs(expr):
    four_digit_nos = [expr(n) for n in range(10000) if expr(n)>999 and expr(n)<10000 and expr(n) % 100 > 9]
    return list(map(lambda x: (x//100,x%100), four_digit_nos))
def squares(n):
    return n*n
print(gen_pairs(squares))
