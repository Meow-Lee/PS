#include<bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    string str;
    cin>>str;

    list<char> L;
    for(auto c : str){
        L.push_back(c);
    }
    auto cursor = L.end();

    int M;
    cin>>M;
    while(M--){
        char ch;
        cin>>ch;

        if(ch=='L'){
            if(cursor != L.begin()){
                cursor--;
            }
        }
        else if(ch=='D'){
            if(cursor != L.end()){
                cursor++;
            }
        }
        else if(ch=='B'){
            if(cursor != L.begin()){
                cursor--;
                cursor = L.erase(cursor);
            }
        }
        else{
            char add;
            cin>>add;
            L.insert(cursor, add);
        }
    }
    for(auto c : L){
        cout<<c;
    }
}