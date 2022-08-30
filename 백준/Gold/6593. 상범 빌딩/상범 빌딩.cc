#include <bits/stdc++.h>
using namespace std;

int dx[6]={1,0,-1,0,0,0};
int dy[6]={0,-1,0,1,0,0};
int dz[6]={0,0,0,0,1,-1};

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int L, R, C;
    while(true){
        cin>>L>>R>>C;
        if(L==0 && R==0 && C==0){
            break;
        }

        char board[35][35][35];
        int dist[35][35][35];
        queue<tuple<int, int, int>> Q;
        bool isEscape = false;

        for(int i=0; i<L; i++){
            for(int j=0; j<R; j++){
                fill(dist[i][j], dist[i][j]+C, 0);
            }
        }
        
        for(int i=0; i<L; i++){
            for(int j=0; j<R; j++){
                for(int k=0; k<C; k++){
                    cin>>board[j][k][i];
                    if(board[j][k][i]=='S'){
                        Q.push({j, k, i});
                        dist[j][k][i]=0;
                    }
                    else if(board[j][k][i]=='.'){
                        dist[j][k][i] = -1;
                    }
                }
            }
        }

        while(!Q.empty()){
            if(isEscape){
                break;
            }
            auto cur = Q.front();
            Q.pop();

            int curX, curY, curZ;
            tie(curX, curY, curZ) = cur;
            for(int dir=0; dir<6; dir++){
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                int nz = curZ + dz[dir];
                if(nx<0 || nx>=R || ny<0 || ny>=C || nz<0 || nz>=L){
                    continue;
                }
                if(board[nx][ny][nz]=='#' || dist[nx][ny][nz]>0){
                    continue;
                }
                dist[nx][ny][nz] = dist[curX][curY][curZ] + 1;
                if(board[nx][ny][nz]=='E'){
                    cout<<"Escaped in "<<dist[nx][ny][nz] <<" minute(s).\n";
                    isEscape = true;
                    break;
                }
                Q.push({nx, ny, nz});
            }
        }
        while(!Q.empty()){
            Q.pop();
        }
        if(!isEscape){
            cout<<"Trapped!"<<'\n';
        }
    }
    return 0;
}