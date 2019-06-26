from math import sqrt 


def numOfDistinctFactors(size):
    root = int(sqrt(size))
    
    a = [0] * (size+1)
    a[1] = 1
    for j in range(2, root):
        if a[j] == 0:
            for k in range(j, size, j):                
                a[k] += 1
    return a
	

factors = numOfDistinctFactors(1000000)

n = 1
p = 4
cont = 0
while(cont < p):
    if (factors[n] == p): 
        cont += 1
        n += 1
    else:
        cont = 0
        n += 1
print(n-p)