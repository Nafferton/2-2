#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

bool urgency(const pair<ll, pair<ll, ll>> &a, const pair<ll, pair<ll, ll>> &b){
    ll ca = a.first;
    ll pa = ca * (a.second.first+1 + a.second.second+1);
    ll cb = b.first;
    ll pb = cb * (b.second.first+1 + b.second.second+1);
    return pa < pb;
}

vector<ll> items;
vector<ll> parent;
vector<ll> setSize;
vector<ll> setRank;

void init(ll n){
    setSize.assign(n,1);
    setRank.assign(n,0);
    parent.assign(n,0);
    for(ll i=0; i<n; i++){
        parent[i] = i;
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
    ll edgesAdded = 0;
    for(ll i=0; i<n; i++){
        for(auto edge : adjList[i]){
            ll adjNode = edge.first;
            ll weight = edge.second;
            edges.push_back({weight, {i, adjNode}});
        }
    }
    sort(edges.begin(), edges.end(), urgency);
    init(n);
    ll total = 0;
    for(ll i=0; i<edges.size(); i++){
        ll u_node = edges[i].second.first;
        ll v_node = edges[i].second.second;
        if(find(u_node) != find(v_node)){
            unionBySize(u_node, v_node);
            total += edges[i].first;
            edgesAdded++;
        }
    }
    if(edgesAdded != n-1)
        return -1;
    return total;
}

int main(){
    ll n, m;
    cin >> n >> m;
    vector<vector<pair<ll, ll>>> adjList(n);
    for(ll i = 0; i < m; i++){
        ll u, v, w;
        cin >> u >> v >> w;
        adjList[u-1].push_back({v-1, w});
        adjList[v-1].push_back({u-1, w});
    }

    ll MSTweight = kruskalMST(adjList, n);
    if(MSTweight == -1){
        cout << "IMPOSSIBLE" << endl;
    }
    else{
        cout << MSTweight << endl;  
    }
}