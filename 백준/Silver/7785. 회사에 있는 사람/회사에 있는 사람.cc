#include<bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    unordered_set<string> s;
    string str;
    int n;
    cin>>n;

    while(n--){
        string a, b;
        cin>>a>>b;

        if(b=="enter"){
            s.insert(a);
        }
        else{
            s.erase(a);
        }
    }

    vector<string> ans(s.begin(), s.end());
    sort(ans.begin(), ans.end(), greater<string>());
    for(auto t : ans){
        cout<<t<<'\n';
    }
}