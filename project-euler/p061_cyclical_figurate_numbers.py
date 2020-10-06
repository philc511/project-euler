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

def iterate_pair(perms, depth, prev_pair, good_seq):
    for pair in perms[depth]:
        if prev_pair[1] == pair[0]:
            good_seq.append(pair)
            if depth < len(perms)-1:
                iterate_pair(perms, depth+1, pair, good_seq)
            else:
                if pair[1] == good_seq[0][0]:
                    print(good_seq)
                    print(sum(100*p[0]+p[1] for p in good_seq))
            
tri_pairs=gen_pairs(triangle)

non_tri_pairs=[]
non_tri_pairs.append(gen_pairs(square))
non_tri_pairs.append(gen_pairs(pentagonal))
non_tri_pairs.append(gen_pairs(hexagonal))
non_tri_pairs.append(gen_pairs(heptagonal))
non_tri_pairs.append(gen_pairs(octagonal))

for perms in itertools.permutations(non_tri_pairs):
    for tri_pair in tri_pairs:
        iterate_pair(perms, 0, tri_pair, [tri_pair])

#print(gen_pairs(hexagonal))
#print(gen_pairs(heptagonal))
#print(gen_pairs(octagonal))
