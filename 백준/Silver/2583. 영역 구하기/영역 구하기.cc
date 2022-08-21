#include<bits/stdc++.h>
using namespace std;

int board[105][105];
bool visited[105][105];
vector<int> ans;
int m,n,cnt;

void bfs(){
    int dx[4]={1, 0, -1, 0};
    int dy[4]={0, -1, 0, 1};

    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            if(visited[i][j]==1 || board[i][j]==1){
                continue;
            }

            queue<pair<int,int>> Q;
            visited[i][j] = 1;
            Q.push({i, j});

            int width=1;
            cnt++;
            while(!Q.empty()){
                auto cur = Q.front();
                Q.pop();

                for(int dir=0; dir<4; dir++){
                    int nx = cur.first + dx[dir];
                    int ny = cur.second + dy[dir];

                    if(nx<0 || nx>=m || ny<0 || ny>=n){
                        continue;
                    }
                    if(board[nx][ny]==1 || visited[nx][ny]==1){
                        continue;
                    }

                    Q.push({nx, ny});
                    visited[nx][ny] = 1;
                    width++;
                }
            }
            ans.push_back(width);
        }
    }
    sort(ans.begin(), ans.end());
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int k;
    cin>>m>>n>>k;

    while(k--){
        int a,b,c,d;
        cin>>a>>b>>c>>d;

        for(int i=b; i<d; i++){
            for(int j=a; j<c; j++){
                board[i][j]=1;
                visited[i][j]=1;
            }
        }
    }
    bfs();

    cout<<cnt<<'\n';
    for(auto t:ans){
        cout<<t<<' ';
    }
}