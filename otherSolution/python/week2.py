#!/usr/bin/env python3
def intersection(a:list,b:list):
    result = 0
    for i in range(len(a)):
        for j in range(len(b)):
            if a[i] == b[j]:
                result += 1
                del b[j]
                break
    return result