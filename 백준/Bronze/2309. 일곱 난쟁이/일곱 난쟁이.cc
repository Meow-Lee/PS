#include<bits/stdc++.h>
using namespace std;

int num[9], res[7];
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    for(int i=0; i<9; i++){
        cin>>num[i];
    }

    for(int a=0; a<8; a++){
        int tot=0;

        for(int b=a+1; b<9; b++){
            tot=0;

            for(int c=0, i=0; c<9; c++){
                if(c!=a && c!=b){
                    res[i++] = num[c];
                }
            }

            for(int i=0; i<7; i++){
                tot+=res[i];
            }

            if(tot==100){
                break;
            }
        }
        if(tot==100){
            break;
        }
    }

    sort(res, res+7);
    for(int i=0; i<7; i++){
        cout<<res[i]<<'\n';
    }
}