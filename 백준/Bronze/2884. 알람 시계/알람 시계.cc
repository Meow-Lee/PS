#include<bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int H,M;
    cin>>H>>M;

    if(H>=0 && H<=23 && M>=0 && M<=59){
        if(H==0){
            if(M>=45){
                M=M-45;
            }
            else{
                H=H+23;
                M=M+15;
            }
        }
        else{
            if(M>=45){
                M=M-45;
            }
            else{
                H=H-1;
                M=M+15;
            }
        }
    }
    cout<<H<<' '<<M;
}