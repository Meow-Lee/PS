#include<bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int n,m;
    cin>>n>>m;

    unordered_map<string, string> t;

    while(n--){
        string adr, pw;
        cin>>adr>>pw;

        t[adr]=pw;
    }

    while(m--){
        string str;
        cin>>str;

        cout<<t[str]<<'\n';
    }
}