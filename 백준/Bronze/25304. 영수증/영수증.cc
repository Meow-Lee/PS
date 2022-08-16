#include<bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int x,n,a,b;
    cin>>x>>n;

    int ans=0;
    while(n--){
        cin>>a>>b;

        ans+=a*b;
    }

    if(ans==x){
        cout<<"Yes";
    }
    else{
        cout<<"No";
    }
}