#include<bits/stdc++.h>
using namespace std;

int n, k;
int arr[2][7];
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin>>n>>k;

    for(int i=0; i<n; i++){
        int s, y;
        cin>>s>>y;

        arr[s][y]++;
    }

    int cnt=0;

    for(int i=0; i<2; i++){
        for(int j=1; j<7; j++){
            cnt += arr[i][j]/k;
            if(arr[i][j] % k){
                cnt++;
            }
        }
    }
    cout<<cnt;
}