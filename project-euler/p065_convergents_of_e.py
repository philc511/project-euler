def getA(n):
    a = [1 for i in range(n)]
    a[0] = 2
    for k in range(2,n,3):
        a[k]=2*((k+1)//3)
    print(a)
    return a

i = 100
a = getA(i)
n = 1
d = a[i-1]
for i in range(i-2,-1,-1):
    oldn = n
    n = d
    d = d*a[i] + oldn
print(d,n)
print(sum(list(map(int, str(d).strip()))))
