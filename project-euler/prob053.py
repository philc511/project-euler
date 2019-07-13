def ncr(n, r):
    total = 1
    for i in range(r):
        total = total * (n-i)
        total = total // (i+1)
    return total
count = 0
for i in range(1,101):
    for j in range(1,i):
        if(ncr(i, j) > 1000000): count +=1
print (count)