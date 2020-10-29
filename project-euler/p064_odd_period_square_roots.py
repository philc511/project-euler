import math
import decimal

def check_period(seq):
    is_period=False
    if len(seq) > 0 and len(seq) % 2 == 0:
        is_period = seq[len(seq)//2:]== seq[:len(seq)//2] 
    return is_period

c=0

for i in range(1,10000):
    a=decimal.Decimal(i).sqrt()
    a=a-int(a)
    if a > 0:
        seq=[]
        while not check_period(seq):
            a = decimal.Decimal(1)/a
            aint=int(a)
            a = a-aint
            seq.append(aint)
        if len(seq)//2 % 2 == 1:
            c=c+1
        print(i, len(seq)//2)
print(c)

