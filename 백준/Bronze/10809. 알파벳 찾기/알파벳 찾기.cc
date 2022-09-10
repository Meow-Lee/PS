#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    string str;
    cin>>str;

    int c = 97;
    while(c != 123){
        bool isYes=false;
        for(int i=0; i<str.length(); i++){
            if((int)str[i]==c){
                isYes = true;
                cout<<i<<' ';
                break;
            }
        }
        if(!isYes){
            cout<<-1<<' ';
        }
        c++;
    }

    return 0;
}