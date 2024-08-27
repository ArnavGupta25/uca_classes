#include <bits/stdc++.h>
using namespace std;

int solve(int i, int j, vector<vector<int>>& mat, int row, int col){
    if(i >= row || j >= col) return 0;
    if(i == row - 1 && j == col - 1){
        return mat[i][j];
    }
    int c1;
    if(i + 1 < row) {
        c1 = solve(i + 1, j, mat, row, col);
    }
    int c2;
    if(j + 1 < col){
        c2 = solve(i, j + 1, mat, row, col);
    }
    return mat[i][j] + min(c1, c2);
}

int main(){
    vector<vector<int>> matrix = {
        {1, 1, 1, 1},
        {1, 0, 0, 1},
        {1, 1, 1, 1},
        {0, 0, 0, 1}
    };
    cout<<solve(0, 0, matrix, matrix.size(), matrix[0].size())<<endl;
    return 0;
}