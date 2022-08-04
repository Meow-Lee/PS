#include<bits/stdc++.h>
using namespace std;

int n;
int arr[10];
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin>>n;
    while(n>0){
        int d = n%10;
        if(d==9 && arr[d]>arr[d-3]){
            arr[d-3]++;
        }
        else if(d==6 && arr[d]>arr[d+3]){
            arr[d+3]++;
        }
        else{
            arr[d]++;
        }
        n/=10;
    }

    int cnt=0;
    for(int i=0; i<10; i++){
        cnt = max(cnt, arr[i]);
    }
    cout<<cnt;
}