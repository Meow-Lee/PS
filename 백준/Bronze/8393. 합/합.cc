#include<bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int n, ans=0;
    cin>>n;

    for(int i=1; i<=n; i++){
        ans+=i;
    }
    cout<<ans;
}