// Lonely number problem - this time 2 numbers are lonely. Return those 2 number: ex [3,2,1,3,4,3] : returns [1,2] or [2,1] 

#include <bits/stdc++.h>

using namespace std;

//leetcode soln
class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        int n = nums.size();
        long x = 0;
        for (int i = 0; i < n; i++) {
            x = x ^ nums[i];
        }
        int rightmost = (x & (x - 1)) ^ x;
        int b1 = 0;
        int b2 = 0;
        for (int i = 0; i < n; i++) {
            if (rightmost & nums[i]) {
                b1 = b1 ^ nums[i];
            } else {
                b2 = b2 ^ nums[i];
            }
        }
        return {b1, b2};
    }
};

//quick select

#include <vector>
#include <algorithm>

using namespace std;

int partition(vector<int>& nums, int left, int right) {
    int pivot = nums[right];
    int i = left;
    
    for (int j = left; j < right; j++) {
        if (nums[j] <= pivot) {
            swap(nums[i], nums[j]);
            i++;
        }
    }
    swap(nums[i], nums[right]);
    return i;
}

void quickSelect(vector<int>& nums, int left, int right, int k) {
    if (left <= right) {
        int pivotIndex = partition(nums, left, right);
        
        if (pivotIndex == k) {
            return;  
        } else if (pivotIndex > k) {
            quickSelect(nums, left, pivotIndex - 1, k);
        } else {
            quickSelect(nums, pivotIndex + 1, right, k); 
        }
    }
}

vector<int> smallestKElements(vector<int>& nums, int k) {
    quickSelect(nums, 0, nums.size() - 1, k - 1); 
    return vector<int>(nums.begin(), nums.begin() + k);
}
