#include <bits/stdc++.h>
using namespace std;

int board[105][105];
bool vis[105][105];
int dx[4]={1,0,-1,0};
int dy[4]={0,-1,0,1};


int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int n;
    cin>>n;

    int max_height=0;
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            cin>>board[i][j];
            max_height = max(max_height, board[i][j]);
        }
    }

    int ans=0;
    for(int height=0; height<=max_height; height++){
        for(int i=0; i<n; i++){
            fill(vis[i], vis[i]+n, 0);
        }

        queue<pair<int, int>> Q;
        int width=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(vis[i][j] || board[i][j]<=height){
                    continue;
                }
                Q.push({i,j});

                while(!Q.empty()){
                    auto cur = Q.front();
                    Q.pop();

                    for(int dir=0; dir<4; dir++){
                        int nx = cur.first + dx[dir];
                        int ny = cur.second + dy[dir];
                        if(nx<0 || nx>=n || ny<0 || ny>=n){
                            continue;
                        }
                        if(!vis[nx][ny] && board[nx][ny]>height){
                            Q.push({nx,ny});
                            vis[nx][ny]=1;
                        }
                    }
                }
                width++;
            }
        }
        ans = max(ans, width);
    }

    cout<<ans;
    return 0;
}