#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int n;
    cin>>n;

    int ans=0;
    while(n--){
        char t;
        cin>>t;

        ans += t - '0';
    }

    cout<<ans;


    return 0;
}