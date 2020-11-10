#Use wkipedia: https://en.wikipedia.org/wiki/Periodic_continued_fraction#Canonical_form_and_repetend
# or here https://web.archive.org/web/20151221205104/http://web.math.princeton.edu/mathlab/jr02fall/Periodicity/mariusjp.pdf

import math
import decimal

def check_period(a0, seq):
    return len(seq) > 0 and seq[-1] == 2*a0

c=0

for i in range(1,100):
    a=decimal.Decimal(i).sqrt()
    a0=int(a)
    a=a-a0
    print(a0,a)
    if a0*a0 != i:
        period=0
        length=0
        while period != 2*a0:
            a = decimal.Decimal(1)/a
            aint=int(a)
            a = a-aint
            period = aint
            length += 1
        if length % 2 == 1:
            c=c+1
        #print(i, length)
print(c)

