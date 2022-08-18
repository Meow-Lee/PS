#include<bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int t;
    cin>>t;

    while(t--){
        unordered_map<string, int> t;

        int n;
        cin>>n;

        while(n--){
            string a,b;
            cin>>a>>b;
            t[b]++;
        }

        int ans=1;
        for(auto v : t){
            ans*=v.second+1;
        }
        cout<<ans-1<<'\n';
    }
}