#include<iostream>
#include<algorithm>
#include<vector>
typedef long long ll;

using namespace std;

int main(){
    int n, q;
    cin >> n >> q;
    vector<ll> a(n);
    for(int i = 0; i < n; i++){
        cin >> a[i];
    }
    sort(a.begin(), a.end());
    while(q--){
        int l, h;
        cin >> l >> h;
        int low = lower_bound(a.begin(), a.end(), l) - a.begin();
        int high = upper_bound(a.begin(), a.end(), h) - a.begin();
        cout << high - low << endl;
    }
}