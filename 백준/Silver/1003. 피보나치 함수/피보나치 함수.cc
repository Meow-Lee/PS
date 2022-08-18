#include<bits/stdc++.h>
using namespace std;

int fib[50][2];

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int T;
    cin>>T;

    fib[0][0]=1, fib[1][1]=1;
    for(int i=2; i<=40; i++){
        fib[i][0] = fib[i-1][0] + fib[i-2][0];
        fib[i][1] = fib[i-1][1] + fib[i-2][1];
    }

    while(T--){
        int n;
        cin>>n;

        cout<<fib[n][0]<<' '<<fib[n][1]<<'\n';
    }
}