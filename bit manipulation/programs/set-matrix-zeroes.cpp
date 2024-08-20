//O(1) space but without bit manipulation

// #include <bits/stdc++.h>
// using namespace std;

// class Solution {
// public:
//     void setZeroes(vector<vector<int>>& matrix) {
//         int m = matrix.size();
//         int n = matrix[0].size();

//         int row = 0, col = 0;

//         for (int j = 0; j < n; j++) {
//             if (matrix[0][j] == 0) {
//                 row = 1;
//                 break;
//             }
//         }

//         for (int i = 0; i < m; i++) {
//             if (matrix[i][0] == 0) {
//                 col = 1;
//                 break;
//             }
//         }

//         for (int i = 1; i < m; i++) {
//             for (int j = 1; j < n; j++) {
//                 if (matrix[i][j] == 0) {
//                     matrix[i][0] = 0;
//                     matrix[0][j] = 0;
//                 }
//             }
//         }

//         for (int i = 1; i < m; i++) {
//             for (int j = 1; j < n; j++) {
//                 if (matrix[i][0] == 0 || matrix[0][j] == 0) {
//                     matrix[i][j] = 0;
//                 }
//             }
//         }

//         if (row==1) {
//             for (int j = 0; j < n; j++) {
//                 matrix[0][j] = 0;
//             }
//         }

//         if (col==1) {
//             for (int i = 0; i < m; i++) {
//                 matrix[i][0] = 0;
//             }
//         }
//     }
// };



//bit manipulation approach


