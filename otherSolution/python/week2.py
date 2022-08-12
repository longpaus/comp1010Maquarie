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
def getLongestAscendingSequence(data):
    info = {}
    numbers = []
    for num in data:
        if len(numbers) == 0 or num >= numbers[-1]:
            numbers.append(num)
        else:
            if len(numbers) not in info:
                info[len(numbers)] = numbers
            numbers = [num]
    info[len(numbers)] = numbers
    return info[max(info, key=(lambda k: info[k] and k))]

    