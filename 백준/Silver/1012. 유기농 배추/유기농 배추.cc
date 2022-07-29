#include<iostream>
#include<queue>
using namespace std;
#define X first
#define Y second

int board[51][51];
bool vis[51][51];
int n,m,k;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,-1,0,1};
queue<pair<int, int>> Q;

void bfs(int x, int y){
    vis[x][y] = 1;
    Q.push({x, y});

    while(!Q.empty()){
        auto cur = Q.front();
        Q.pop();

        for(int dir=0; dir<4; dir++){
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];

            if(nx<0 || nx>=n || ny<0 || ny>=m){
                continue;
            }
            if(board[nx][ny] != 1 || vis[nx][ny]){
                continue;
            }
            vis[nx][ny] = 1;
            Q.push({nx, ny});
        }
    }
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int t;
    cin>>t;

    while(t--){
        cin>>m>>n>>k;

        int x, y;
        for(int i=0; i<k; i++){
            cin>>x>>y;
            board[y][x]=1;
        }

        int res=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]==1 && !vis[i][j]){
                    bfs(i, j);
                    res++;
                }
            }
        }
        cout<<res<<'\n';

        for(int i=0; i<n; i++){
            fill(board[i], board[i]+m, 0);
            fill(vis[i], vis[i]+m, false);
        }
    }
    return 0;
}