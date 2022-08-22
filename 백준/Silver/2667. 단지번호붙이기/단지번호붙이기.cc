#include<bits/stdc++.h>
using namespace std;

string board[30];
bool vis[30][30];
int n;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    cin>>n;
    for(int i=0; i<n; i++){
        cin>>board[i];
    }

    vector<int> ans;
    int cnt=0;

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(board[i][j]=='0' || vis[i][j]){
                continue;
            }

            queue<pair<int,int>> Q;
            Q.push({i, j});
            vis[i][j]=1;
            int width=1;
            cnt++;
            while(!Q.empty()){
                auto cur = Q.front();
                Q.pop();

                int dx[4] = {1, 0, -1, 0};
                int dy[4] = {0, -1, 0, 1};
                for(int dir=0; dir<4; dir++){
                    int nx = cur.first + dx[dir];
                    int ny = cur.second + dy[dir];

                    if(nx<0 || nx>=n || ny<0 || ny>=n){
                        continue;
                    }
                    if(board[nx][ny]=='0' || vis[nx][ny]){
                        continue;
                    }
                    Q.push({nx, ny});
                    vis[nx][ny]=1;
                    width++;
                }
            }
            ans.push_back(width);
        }
    }
    sort(ans.begin(), ans.end());
    cout<<cnt<<'\n';
    for(auto t:ans){
        cout<<t<<'\n';
    }
}