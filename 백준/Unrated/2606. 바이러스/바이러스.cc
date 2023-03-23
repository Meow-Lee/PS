#include <bits/stdc++.h>
using namespace std;

int main(){
    int n, m, s, e;
    cin>>n>>m;

    vector<int> v[n+1];
    bool visited[n+1];
    fill(visited, visited + n, false);
    for(int i=0; i<m; i++){
        cin>>s>>e;
        v[s].push_back(e);
        v[e].push_back(s);
    }

    queue<int> q;
    q.push(1);
    visited[1] = true;
    int cnt=0;
    while (!q.empty()) {
        int x = q.front();
        q.pop();

        for(int i=0; i<v[x].size(); i++){
            int y = v[x][i];
            if (!visited[y]) {
                q.push(y);
                visited[y]=true;
                cnt++;
            }
        }
    }
    cout<<cnt;
}