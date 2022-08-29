#include <bits/stdc++.h>
using namespace std;

bool board[10000];

int func(int n){
    int ans = n;
    while(n!=0){
        ans += n%10;
        n /= 10;
    }
    return ans;
}

int main(){
    ios::sync_with_stdio(0);

    int cur = 1;
    while(cur<10000){
        int temp = func(cur);
        if(temp>10000){
            cur++;
            continue;
        }
        board[temp]=true;
        cur++;
    }

    for(int i=1; i<10000; i++){
        if(!board[i]){
            cout<<i<<'\n';
        }
    }
    return 0;
}