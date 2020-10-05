import itertools

def gen_pairs(expr):
    four_digit_nos = [expr(n) for n in range(10000) if expr(n)>999 and expr(n)<10000 and expr(n) % 100 > 9]
    return list(map(lambda x: (x//100,x%100), four_digit_nos))

def triangle(n):
    return n*(n+1)//2 
def square(n):
    return n*n

def pentagonal(n):
    return n*(3*n-1)//2 

def hexagonal(n):
    return n*(2*n-1) 

def heptagonal(n):
    return n*(5*n-3)//2

def octagonal(n):
    return n*(3*n-2) 

all_pairs=[]

all_pairs.append(gen_pairs(triangle))
all_pairs.append(gen_pairs(square))
all_pairs.append(gen_pairs(pentagonal))

for perms in itertools.permutations(all_pairs[1:]):
    for tri_pair in all_pairs[0]:
        for sq_pair in perms[0]:
            if tri_pair[1] == sq_pair[0]:
                for pe_pair in perms[1]:
                    if sq_pair[1] == pe_pair[0]:
                        if pe_pair[1] == tri_pair[0]:
                            print (tri_pair, sq_pair, pe_pair)
#print(gen_pairs(hexagonal))
#print(gen_pairs(heptagonal))
#print(gen_pairs(octagonal))
