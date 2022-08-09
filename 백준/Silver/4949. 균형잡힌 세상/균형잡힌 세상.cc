#include<bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    while(true){
        string str;
        getline(cin, str);

        if(str=="."){
            break;
        }
        stack<char> S;
        bool flag = true;

        for(auto c:str){
            if(c=='(' || c=='['){
                S.push(c);
            }
            else if(c==')'){
                if(S.empty() || S.top()!='('){
                    flag=false;
                    break;
                }
                S.pop();
            }
            else if(c==']'){
                if(S.empty() || S.top()!='['){
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
            cout<<"yes"<<'\n';
        }
        else{
            cout<<"no"<<'\n';
        }
    }
}