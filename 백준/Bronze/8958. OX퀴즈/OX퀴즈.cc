#include<bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int t;
    cin>>t;

    while(t--){
        string str;
        cin>>str;

        int cnt=1, res=0;
        for(auto s:str){
            if(s=='O'){
                res+=cnt;
                cnt++;
            }
            else{
                cnt=1;
            }
        }
        cout<<res<<'\n';
    }
}