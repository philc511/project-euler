def pairs(elements):
    res = []
    head, *tail = elements
    if len(elements) == 2:
        res.append((head, tail[0]))
    else:
        for elt in tail:
            res.append((head, elt))
        res+=pairs(tail)
    return res

a = [1,2,3,4]
print(pairs(a))
