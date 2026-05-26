#include <bits/stdc++.h>
#include <chrono>
using namespace std;
using namespace chrono;

bool greaterCompare(int x, int y) {
    return x > y;
}


bool absCompare(int x, int y) {
    if(abs(x) != abs(y)){
        return abs(x) < abs(y);
    }
    else{
        return x < y;
    }
}

int main() {
    int n;

    // freopen("../input/input0.txt","r",stdin);

    cin >> n;

    vector<int> a(n);
    for (int i = 0; i < n; i++) cin >> a[i];

    vector<int> b = a, c = a;

    // auto start1 = steady_clock::now();


    sort(a.begin(), a.end());
   sort(b.begin(), b.end(), greater<int>());
    // sort(b.begin(), b.end(), greaterCompare);
    sort(c.begin(), c.end(), absCompare);

    // auto end1 = steady_clock::now();

    // auto time1 = duration_cast<microseconds>(end1 - start1);

    for (int x : a) cout << x << " ";
    cout << "\n";

    for (int x : b) cout << x << " ";
    cout << "\n";

    for (int x : c) cout << x << " ";
    cout << "\n";

    // cout << "Time required: "<<time1.count()<< " micro second" << endl;

    return 0;
}
