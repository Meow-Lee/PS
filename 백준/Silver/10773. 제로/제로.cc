#include<bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int K;
    cin>>K;

    stack<int> S;
    int ans=0;
    while(K--){
        int t;
        cin>>t;

        if(t==0){
            if(!S.empty()){
                ans-=S.top();
                S.pop();
            }
        }
        else{
            S.push(t);
            ans+=t;
        }
    }
    cout<<ans;
}