# based on the fact that the next expression in the series from a/b is (a+2*b)/(a+b)
def next(fraction):
  return (fraction[0] + 2*fraction[1],fraction[0]+fraction[1])
f = (1,1)
count = 0
for i in range(1000):
  f = next(f)
  if len(str(f[0])) > len(str(f[1])):
    count+=1
print(count)
