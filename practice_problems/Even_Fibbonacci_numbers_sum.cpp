#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;

    long long a = 1, b = 1, sum = 0;
    
    while (b <= n) {
        if (b % 2 == 0) {
            sum += b;
        }
        long long next = a + b;
        a = b;
        b = next;
    }
    
    cout << sum << endl;
    return 0;
}
