#include<iostream>
#include<vector>
#include<algorithm>
typedef long long ll;

using namespace std;

int main(){
    int t;
    cin >> t;
    while(t--){
        int n;
        cin >> n;
        vector<ll> a(n);
        ll x;
        cin >> x;
        ll total = 0;
        for(int i = 0; i < n; i++){
            cin >> a[i];
            total += a[i];
        }
        if(total < x){
            cout << -1 << endl;
            continue;
        }
        sort(a.begin(), a.end(), greater<ll>());
        ll sum = 0;
        for(int i=0; i<n; i++){
            sum += a[i];
            if(sum >= x){
                cout << i+1 << endl;
                break;
            }
        }
    }
}