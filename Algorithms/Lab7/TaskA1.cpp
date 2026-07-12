#include<bits/stdc++.h>
using namespace std;

typedef long long ll;

vector<ll> items;
vector<ll> parent;
vector<ll> setSize;
vector<ll> setRank;

void init(ll n){
    for(ll i=0; i<n; i++){
        parent.push_back(i);
        setSize.push_back(1);
        setRank.push_back(0);
    }
}

ll find(ll u){
    if(parent[u] == u)  return u;
    return parent[u] = find(parent[u]);
}

void unionBySize(ll u, ll v){
    ll pu = find(u);
    ll pv = find(v);
    if(pu != pv){
        if(setSize[pu] >= setSize[pv]){
            parent[pv] = pu;
            setSize[pu] += setSize[pv];
        }
        else{
            parent[pu] = pv;
            setSize[pv] += setSize[pu];
        }
    }
}

ll kruskalMST(vector<vector<pair<ll, ll>>> &adjList, ll n){
    vector<pair<ll, pair<ll, ll>>> edges;
    for(ll i=0; i<n; i++){
        for(auto edge : adjList[i]){
            ll adjNode = edge.first;
            ll weight = edge.second;
            edges.push_back({weight, {i, adjNode}});
        }
    }
    sort(edges.begin(), edges.end());
    init(n);
    ll total = 0;
    for(ll i=0; i<edges.size(); i++){
        ll u_node = edges[i].second.first;
        ll v_node = edges[i].second.second;
        if(find(u_node) != find(v_node)){
            unionBySize(u_node, v_node);
            total += edges[i].first;
        }
    }
    if(find(0) != find(n-1)) return -1;
    return total;
}

int main(){
    ll n, m;
    cin >> n >> m;
    ll u, v, w;
    vector<vector<pair<ll, ll>>> adjList(n);
    for(ll i=0; i<m; i++){
        cin >> u >> v >> w;
        adjList[u-1].push_back({v-1, w});
        adjList[v-1].push_back({u-1, w});
    }
    ll mstWeight = kruskalMST(adjList, n);
    if(mstWeight == -1) cout << "IMPOSSIBLE" << endl;
    else cout << mstWeight << endl;

}