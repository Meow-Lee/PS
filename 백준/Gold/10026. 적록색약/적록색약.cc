#include<iostream>
#include<queue>
using namespace std;

string board[101];
int visited[101][101];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, -1, 0, 1};
int n;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin>>n;

    for(int i=0; i<n; i++){
        cin>>board[i];
    }

    queue<pair<int, int>> Q1; //적록색약 아닌 사람
    queue<pair<int, int>> Q2; //적록색약인 사람


    int num1=0, num2=0;
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(visited[i][j]){
                continue;
            }
            Q1.push({i,j});
            visited[i][j] = 1;

            while(!Q1.empty()){
                auto cur = Q1.front();
                Q1.pop();
                for(int dir=0; dir<4; dir++){
                    int nx = cur.first + dx[dir];
                    int ny = cur.second + dy[dir];

                    if(nx<0 || nx>=n || ny<0 || ny>=n){
                        continue;
                    }
                    if(visited[nx][ny] || board[i][j] != board[nx][ny]){
                        continue;
                    }
                    visited[nx][ny] = 1;
                    Q1.push({nx, ny});
                }
            }
            num1++;
        }
    }

    for(int i=0; i<n; i++){
        fill(visited[i],visited[i]+n, 0);
    }
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(board[i][j] == 'G'){
                board[i][j] = 'R';
            }
        }
    }

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(visited[i][j]){
                continue;
            }
            Q2.push({i, j});
            visited[i][j] = 1;

            while(!Q2.empty()){
                auto cur = Q2.front();
                Q2.pop();
                for(int dir=0; dir<4; dir++){
                    int nx = cur.first + dx[dir];
                    int ny = cur.second + dy[dir];
                    if(nx<0 || nx>=n || ny<0 || ny>=n){
                        continue;
                    }
                    if(visited[nx][ny] || board[i][j] != board[nx][ny]){
                        continue;
                    }
                    visited[nx][ny] = 1;
                    Q2.push({nx, ny});
                }
            }
            num2++;
        }
    }
    cout<<num1<<" "<<num2;

    return 0;
}