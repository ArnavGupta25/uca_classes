// leetcode solution

#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<string> generateParenthesis(int n)
    {
        vector<string> ans;
        helper(ans, n, 0, 0, "");
        return ans;
    }

    void helper(vector<string> &ans, int n, int open, int close, string s)
    {
        if (s.size() == n * 2)
        {
            ans.push_back(s);
            return;
        }
        if (open < n)
        {
            helper(ans, n, open + 1, close, s + "(");
        }
        if (close < open)
        {
            helper(ans, n, open, close + 1, s + ")");
        }
    }
};