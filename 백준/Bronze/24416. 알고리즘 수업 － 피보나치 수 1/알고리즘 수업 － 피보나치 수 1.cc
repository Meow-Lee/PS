#include<bits/stdc++.h>
using namespace std;

int d[40];
int cnt_fib=1;

int fib(int n){
    if(n==1 || n==2){
        return 1;
    }
    cnt_fib++;
    return fib(n-1)+fib(n-2);
}

int fibonacci(int n){
    d[1]=1, d[2]=1;
    int cnt=1;
    for(int i=3; i<n; i++){
        d[i] = d[i-1]+d[i-2];
        cnt++;
    }
    return cnt;
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int n;
    cin>>n;

    fib(n);
    cout<<cnt_fib<<' '<<fibonacci(n);
}