// There are n cities given along with respective population. You have to open m clinics in those cities such that maximum load on clinics are minimized. ex:  

// • n = 3
// • population = [100, 50, 200] 
// • m = 4 

// if I open 2 clinic in first city, 1 in second and 1 in third then the load on clinics will be 100/2, 50/1 and 200/1
// Here the clinic in 3rd city has maximum load (200).
// A better option : open clinic in order [1,1,2] then max load on clinics would be 100. [100/1, 50/1,200/2]
// Constraints:

// • n and m are large numbers. 
// • m >= n

#include <bits/stdc++.h>
using namespace std;

int main(){
	int n;
	cin >> n;
	priority_queue<pair<int, int>> pq;
	for(int i = 0; i < n; i++){
		int temp;
		cin >> temp;
		pq.push({temp, 1});
	}
	int m;
	cin >> m;
	m -= n;
	int clinics = 1;
	while(clinics <= m){
		clinics++;
		int popu = pq.top().first;
		int clin = pq.top().second;
		pq.pop();
		popu *= clin;
        clin++;
		popu /= clin;
		pq.push({popu, clin});
	}
	cout << pq.top().first;
}