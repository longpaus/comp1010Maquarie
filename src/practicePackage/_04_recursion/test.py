#!/usr/bin/env python3

def binarySearch(nums,To_Find,lo,hi):
    while hi - lo > 1:
        mid = (hi + lo) // 2
        if nums[mid] < To_Find:
            lo = mid + 1
        else:
            hi = mid
    if nums[lo] == To_Find:
        return lo
    elif nums[hi] == To_Find:
        return hi
    else:
        return -1
def search(nums: list[int], target: int) -> int:
    pivot = 0
    for i in range(len(nums) - 1,0,-1):
        if nums[i] > nums[0]:
            pivot = i + 1
            break
    print(pivot)
    if target >= nums[pivot] and target <= nums[-1]:
        return binarySearch(nums,target,pivot,len(nums) - 1)
    else:
        return binarySearch(nums,target,0,pivot - 1)
        
    
print(search([1,3],0))