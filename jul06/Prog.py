# Sort Zeros and ones 
l = [ 0 , 0 , 2,1, 1, 1,  2 , 1 , 2, 0]

res = []
zc = 0 
for x in l:
    if x == 0:
        res.insert(0 , 0)
        zc+=1
    if x == 1:
        res.insert(zc , 1)

    if x == 2:
        res.append(2)
        
print(res)