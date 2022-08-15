#include<bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int A,B,C;
    cin>>A>>B>>C;

    if(A>=0 && A<=23 && B>=0 && B<=59){
        if(A==23){
            if(B+C >= 60){
                A=(B+C)/60 -1;
                B=(B+C)%60;
            }
            else{
                B=B+C;
            }
        }
        else{
            if(B+C >=60){
                A+=(B+C)/60;
                A%=24;
                B=(B+C)%60;
            }
            else{
                B=B+C;
            }
        }
    }
    cout<<A<<' '<<B;
}