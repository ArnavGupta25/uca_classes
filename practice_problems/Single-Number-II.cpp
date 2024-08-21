//leetcode solution
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int singleNumber(vector<int>& arr) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            int x = (1 << i); 

            for (int j = 0; j < arr.size(); j++) {
                if (arr[j] & x) {
                    sum += 1;
                }
            }

            if (sum % 3 != 0) {
                ans |= x; 
            }
        }
        return ans;
    }
};


//one more approach

class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int n=nums.size();
        int bits[32] = {0};
       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 32; j++) {
                if (nums[i] & (1 << j)) {
                    bits[j]++;
                }
            }
        }

        int result = 0;

        for (int i = 0; i < 32; i++) {
            if (bits[i] % 3 != 0) {
                result |= (1 << i);
            }
        }

        return result;
    }
};