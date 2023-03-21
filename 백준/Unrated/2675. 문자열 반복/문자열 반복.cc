#include <bits/stdc++.h>
using namespace std;

int main(){
    int t, r;
    string s, p;
    cin>>t;
    for(int i=0; i<t; i++){
        cin >> r >> s;
        for(int j=0; j<s.size(); j++){
            for(int k=0; k<r; k++){
                p += s[j];
            }
        }
        cout<<p<<'\n';
        p="";
    }
}