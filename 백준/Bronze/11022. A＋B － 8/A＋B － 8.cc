#include<bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int T,A,B;

    cin>>T;
    int cnt=1;
    while(T--){
        cin>>A>>B;
        cout<<"Case #"<<cnt++<<": "<<A<<" + "<<B<<" = "<<A+B<<'\n';
    }
}