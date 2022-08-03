#include<bits/stdc++.h>
using namespace std;

int n;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin>>n;

    if(n%4==0){
        if(n%100!=0){
            cout<< 1;
        }
        else if(n%400==0){
            cout<< 1;
        }
        else{
            cout<<0;
        }
    }
    else{
        cout<<0;
    }
}