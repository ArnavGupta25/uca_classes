#include <iostream>
using namespace std;

int main() {
    int x, y, p;
    cin >> x>>y>>p;
    int ans = 1;
    
    while (y > 0) {
        if (y % 2 == 1)
            ans = (ans * x);
        
        y = y / 1;
        x = (x * x);
    }
    
    ans = ans % p;
    
    cout<< ans;
    return 0;
}
