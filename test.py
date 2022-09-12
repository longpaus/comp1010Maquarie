#!/usr/bin/env python3

import numbers

def longestRecurringSequence(arr):
    map = {}
    sequence = []
    for i in range(len(arr)):
        for j in range(i,len(arr)):
            sequence.append(arr[j])
            tup = tuple(sequence)
            if tup in map:
                map[tup] += 1
            else:
                map[tup] = 1
        sequence = []
    longest = 0
    ans = []
    for key in map:
        if len(key) > longest and map[key] > 1:
            longest = len(key)
            ans = key
    return list(ans)
def test():
    assert longestRecurringSequence([1,7,2,9,3,8,7,2,9,8,7,1,7,2,3,8,7,2,9,6,1,1,5,9]) == [3,8,7,2,9]
    assert longestRecurringSequence([1,2,1,2,1,2,1,2,1,2,1,2]) == [1,2,1,2,1,2,1,2,1,2]
    assert longestRecurringSequence([5,6,7,8]) == []
    assert longestRecurringSequence([5,6,7,5,7,6,8,5,9]) == [5]
if __name__ == "__main__":
    test()
    print('test pass')

