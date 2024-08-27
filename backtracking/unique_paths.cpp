#include <bits/stdc++.h>

using namespace std;
void solve(int i, int j, int m, int n){
    if(i == m - 1 && j == n - 1){
        cout<<"("<<i<<", "<<j<<")";
        cout<<endl;
        return;
    }
    cout<<"("<<i<<", "<<j<<") ";
    if(i < m - 1) solve(i + 1, j, m, n);
    if(j < n - 1) solve(i, j + 1, m, n);
}
int main(){
    int m,n;
    cin>>m>>n;
    solve(0, 0, m, n);
    return 0;
}