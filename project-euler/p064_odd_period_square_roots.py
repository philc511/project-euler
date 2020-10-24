import math
def check_period(seq):
    is_period=False
    if len(seq) > 0 and len(seq) % 2 == 0:
        is_period = seq[len(seq)//2:]== seq[:len(seq)//2] 
    return is_period

c=0


for i in range(2,10000):
    a=math.sqrt(i) - int(math.sqrt(i))
    if a > 0:
        seq=[]
        while not check_period(seq):
            seq.append(int(1.0/a))
            a=1.0/a-int(1.0/a)
        if len(seq)//2 % 2 == 1:
            c=c+1
        print(i, len(seq)//2)
print(c)

