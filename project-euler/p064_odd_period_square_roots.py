# Just implement the alogorithm implemented here:
# Use wkipedia: https://en.wikipedia.org/wiki/Periodic_continued_fraction#Canonical_form_and_repetend 
# or here https://web.archive.org/web/20151221205104/http://web.math.princeton.edu/mathlab/jr02fall/Periodicity/mariusjp.pdf
# Tried to figure out a way using decimal multiplication but that had too many rounding errors in, even with "decimal" package
import math

def check_period(a0, seq):
    return len(seq) > 0 and seq[-1] == 2*a0

c=0

for i in range(1,10000):
    a=int(math.sqrt(i))
    a0=a
    m = 0
    d = 1
    if a*a != i:
        period=0
        length=0
        while period != 2*a0:
            m = d*a - m
            d = (i - m*m)/d
            a = int((a0+m)/d)
            period = a
            length += 1
        if length % 2 == 1:
            c=c+1
print(c)

