//leetcode solution

#include <bits/stdc++.h>
using namespace std;

//approach 1 using long
class Solution
{
public:
    int reverse(int x)
    {
        long r = 0;
        while (x != 0)
        {
            r = r * 10 + x % 10;
            x = x / 10;
        }
        if (r < INT_MIN || r > INT_MAX)
        {
            return 0;
        }
        return int(r);
    }
};


// approach 2- without long

class Solution {
public:
    int reverse(int x) {
        int rem, ans = 0;

        while (x != 0) {
            rem = x % 10;
            
            // Check for overflow before multiplying and adding
            if (ans > INT_MAX / 10 || (ans == INT_MAX / 10 && rem > 7)) {
                return 0;
            }
            if (ans < INT_MIN / 10 || (ans == INT_MIN / 10 && rem < -8)) {
                return 0;
            }
            
            ans = ans * 10 + rem;
            x /= 10;
        }

        return ans;
    }
};
