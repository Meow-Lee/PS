#include<bits/stdc++.h>
using namespace std;

unordered_map<string, int> t;
string name[100005];

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int n,m;
    cin>>n>>m;

    for(int i=1; i<=n; i++){
        cin>>name[i];
        t[name[i]]=i;
    }

    while(m--){
        string str;
        cin>>str;
        if(isdigit(str[0])){
            cout<<name[stoi(str)]<<'\n';
        }
        else{
            cout<<t[str]<<'\n';
        }
    }
}