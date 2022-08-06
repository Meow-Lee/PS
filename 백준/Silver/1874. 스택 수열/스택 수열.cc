#include<bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin>>n;

    stack<int> S;
    string ans;

    int cnt=1;
    while(n--){
        int t;
        cin>>t;

        while(cnt <= t){
            S.push(cnt++);
            ans+="+\n";
        }

        if(S.top()!=t){
            cout<<"NO\n";
            return 0;
        }
        S.pop();
        ans+="-\n";
    }
    cout<<ans;
}