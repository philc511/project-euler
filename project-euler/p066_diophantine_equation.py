# Just implement the alogorithm implemented here:
# https://mathworld.wolfram.com/PellEquation.html
import math

def check_period(a0, seq):
    return len(seq) > 0 and seq[-1] == 2*a0

c=0

for i in range(1,10):
    a0=int(math.sqrt(i))
    p0=a0
    q0=1
    if a0*a0 != i:
        period=0
        length=0
        while period != 2*a0:
            p=
            m = d*a - m
            d = (i - m*m)/d
            a = int((a0+m)/d)
            period = a
            length += 1
        if length % 2 == 1:
            c=c+1
print(c)

