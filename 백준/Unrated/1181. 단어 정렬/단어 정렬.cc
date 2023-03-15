#include <bits/stdc++.h>

using namespace std;

bool compare(string a, string b){
    if (a.length() == b.length()) {
        return a < b;
    }
    return a.length() < b.length();
}

int main(){
    int n;
    cin>>n;

    vector<string> v;
    for(int i=0; i<n; i++){
        string str;
        cin>>str;
        v.push_back(str);
    }
    sort(v.begin(), v.end(), compare);

    cout<<v[0]<<'\n';
    for(int i=1; i<v.size(); i++){
        if(v[i] == v[i-1]){
            continue;
        }
        cout<<v[i]<<'\n';
    }

    return 0;
}
