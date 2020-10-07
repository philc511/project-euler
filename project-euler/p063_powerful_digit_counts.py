#  if p is the power and n is the root, we require that
# 10^(p-1) <= n^p < 10^p
# in order for n^p to be n digits
# This implies 
# a) n < 10
# b) n >= 10^((p-1)/p)
#
count = 0
for p in range(1, 100):
    min = int(pow(10, (p-1)/p))
    for n in range(min, 10):
        if len(str(pow(n,p))) == p:
            count += 1
            print(n, p, pow(n,p))
print(count)
