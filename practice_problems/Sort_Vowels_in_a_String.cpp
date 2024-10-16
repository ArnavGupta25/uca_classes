#include<bits/stdc++.h>
using namespace std;

// Leetcode soln

class Solution {
public:
    string sortVowels(string s) {
        vector<int> vowel;
        for (char c : s) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                vowel.push_back(c);
            }
        }
        sort(vowel.begin(), vowel.end());
        int i = 0;
        while (i < vowel.size()) {
            for (char& c : s) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                    c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                    c = vowel[i];
                    i++;
                    ;
                }
            }
        }
        return s;
    }
};