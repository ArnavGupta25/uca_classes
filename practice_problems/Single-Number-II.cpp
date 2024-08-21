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