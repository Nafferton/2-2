#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

ll primMST(vector<vector<pair<ll, ll>>> &adjList, ll n){
    priority_queue<pair<ll, ll>, vector<pair<ll, ll>>, greater<pair<ll, ll>>> pq;
    vector<bool> visited(n, false);
    ll total = 0;
    pq.push({0, 0});
    while(!pq.empty()){
        auto edge = pq.top();
        pq.pop();
        ll node = edge.second;
        ll weight = edge.first;
        if(visited[node] == true) continue;
        visited[node] = true;
        total += weight;
        for(auto edge : adjList[node]){
            ll adjNode = edge.first;
            ll adjWeight = edge.second;
            if(visited[adjNode] == false){
               pq.push({adjWeight, adjNode});
            }
        }
    }
    if(count(visited.begin(), visited.end(), true) != n) 
        return -1;
    return total;
}

int main(){
    ll n, m;
    cin >> n >> m;
    vector<vector<pair<ll, ll>>> adjList(n);
    for(int i=0; i<m; i++){
        ll u, v, w;
        cin >> u >> v >> w;
        adjList[u-1].push_back({v-1, w});
        adjList[v-1].push_back({u-1, w});
    }
    if(primMST(adjList, n) == -1) 
        cout << "IMPOSSIBLE" << endl;
    else
        cout << primMST(adjList, n) << endl;
}