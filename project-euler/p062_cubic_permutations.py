def canonical(n):
    a = list(str(n))
    a.sort()
    return "".join(a)

powers_of_three = {}
for i in range(10000):
    p = i*i*i
    c = canonical(p)
    if c not in powers_of_three:
        powers_of_three[c] = []
    powers_of_three[c].append(p)

print("Use the lowest of these numbers...")
for i in iter(powers_of_three):
    if len(powers_of_three[i]) > 4:
        print(powers_of_three[i]) 

