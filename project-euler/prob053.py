def ncr(n, r):
    total = 1
    for i in range(1,2):
        print(i)
        total = total * (n+1-r)
        total = total // i
    return total
x = range(6)
for n in x:
  print(n) 
print (ncr(5,2))
#print (ncr(5,3))
#print (ncr(23,11))