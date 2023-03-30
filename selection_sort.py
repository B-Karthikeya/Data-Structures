a = [15,22,84,74,55,22,1,3]

def selection_sort(a) :
    for i in range(len(a)-1) :
        m = i
        for j in range(i+1,len(a)) :
            if a[j]<a[m] :
                m=j
        if m!=i :
            a[i],a[m] = a[m],a[i]

    return a

print(selection_sort(a))