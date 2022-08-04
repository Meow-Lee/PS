#include<bits/stdc++.h>
using namespace std;

int n, x, cnt;
int board[2000001];
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin>>n;

    int arr[n];
    for(int i=0; i<n; i++){
        cin>>arr[i];
    }

    cin>>x;

    for(int i=0; i<n; i++){
        if((x-arr[i])>=0 && board[x-arr[i]]){
            cnt++;
        }
        board[arr[i]] = 1;
    }
    cout<<cnt;
}