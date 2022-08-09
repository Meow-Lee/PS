#include<bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin>>t;

    while(t--){
        string str;
        cin>>str;

        stack<char> S;
        bool flag=true;

        for(auto c:str){
            if(c=='('){
                S.push(c);
            }
            else{
                if(S.empty() || S.top()!='('){
                    flag=false;
                    break;
                }
                S.pop();
            }
        }
        if(!S.empty()){
            flag=false;
        }

        if(flag){
            cout<<"YES"<<'\n';
        }
        else{
            cout<<"NO"<<'\n';
        }
    }
}