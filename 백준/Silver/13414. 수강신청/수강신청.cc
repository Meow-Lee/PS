#include<bits/stdc++.h>
using namespace std;

unordered_map<string, int> m;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int k, l;
    cin>>k>>l;

    for(int i=1; i<=l; i++){
        string str;
        cin>>str;

        if(m.find(str)!=m.end()){
            m.erase(str);
            m[str] = i;
        }
        else{
            m[str] = i;
        }
    }
    vector<pair<string, int>> ans(m.begin(), m.end());
    sort(ans.begin(), ans.end(), [](auto& a, auto& b){ return a.second < b.second; });

    int en = min(k, (int)ans.size());

    for(int i=0; i<en; i++){
        cout<<ans[i].first<<'\n';
    }
}