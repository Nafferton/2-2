#include<iostream>
#include<vector>
#include<algorithm>
typedef long long int ll;

using namespace std;

int main(){
    int t;
    cin >> t;
    while(t--){
        int n;
        cin >> n;
        vector<ll> a(n), b(n), w(n);
        for(int i=0; i<n; i++){
            cin >> a[i];
        }
        sort(a.begin(), a.end());
        for(int i=0; i<n; i++){
            cin >> b[i];
        }
        sort(b.begin(), b.end());
        for(int i=0; i<n; i++){
            cin >> w[i];
        }
        sort(w.begin(), w.end(), greater<int>());
        ll sum = 0;
        vector<ll> diffs(n);
        for(int i=0; i<n; i++){
            diffs[i] = abs(a[i] - b[i]);
        }
        sort(diffs.begin(), diffs.end());
        for(int i=0; i<n; i++){
            sum += w[i]*diffs[i];
        }
        cout << sum << endl;
    }
}