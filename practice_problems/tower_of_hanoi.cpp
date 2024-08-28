#include <iostream>
using namespace std;

void towerOfHanoi(int n, char a, char c, char b) {
    if (n == 1) {
        cout << "Move disk 1 from rod " << a << " to rod " << c << endl;
        return;
    }
    
    towerOfHanoi(n - 1, a, b, c);
    cout << "Move disk " << n << " from rod " << a << " to rod " << c << endl;
    towerOfHanoi(n - 1, b, c, a);
}

int main() {
    int n;
    cin >> n;
    
    towerOfHanoi(n, 'A', 'C', 'B'); 
    return 0;
}
