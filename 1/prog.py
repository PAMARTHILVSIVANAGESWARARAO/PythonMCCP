n = [1 , 2 , 3 , 4, 5]
for i in range(len(n)-2):
    j = i+1
    k = len(n)-1

    while(j<k):
        if n[i]+n[j]+n[k] == 6:
            print(n[i] , n[j] , n[k])
